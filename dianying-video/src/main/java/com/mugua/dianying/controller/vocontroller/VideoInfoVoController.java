package com.mugua.dianying.controller.vocontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mugua.dianying.common.pojo.RespBean;
import com.mugua.dianying.common.utils.ObjectId;
import com.mugua.dianying.entity.Board;
import com.mugua.dianying.entity.ExtendType;
import com.mugua.dianying.entity.ExtendTypeVal;
import com.mugua.dianying.entity.Sysoperator;
import com.mugua.dianying.entity.ValScope;
import com.mugua.dianying.entity.VideoInfo;
import com.mugua.dianying.entity.VideoInfoBoard;
import com.mugua.dianying.pojo.VideoInfoPojo;
import com.mugua.dianying.service.BoardService;
import com.mugua.dianying.service.ExtendTypeService;
import com.mugua.dianying.service.ExtendTypeValService;
import com.mugua.dianying.service.VideoInfoService;
import com.mugua.dianying.service.voService.VideoInfoVoService;
import com.mugua.dianying.vo.VideoInfoVo;

@RestController
public class VideoInfoVoController {
	@Autowired
	VideoInfoService videoInfoService;
	@Autowired
	BoardService boardService;
	@Autowired
	ExtendTypeService extendTypeService;
	@Autowired
	ExtendTypeValService extendTypeValService;
	@Autowired
	VideoInfoVoService videoInfoVoService;
	
	/**
	 * 新增一条视频信息
	 * @param videoInfoVo
	 * @return
	 */
	@PostMapping("/videoInfoVo")
	public RespBean add(@RequestBody VideoInfoPojo videoInfoPojo){
		RespBean result = new RespBean();
		boolean flag =  videoInfoVoService.addVideoInfoVo(videoInfoPojo);
		
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	/**
	 * 删除一条视频信息(软删除)
	 * @param id
	 * @return
	 */
	@DeleteMapping("/videoInfoVo/{sysId}")
	public RespBean delete(@PathVariable(name = "sysId") String id){
		RespBean result = new RespBean();
		boolean flag = videoInfoVoService.deleteVideoInfoVo(id);
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	/**
	 * 修改视频信息
	 * @param videoInfoVo
	 * @return
	 */
	@PutMapping("/videoInfoVo")
	public RespBean modify(@RequestBody VideoInfoPojo videoInfoPojo){
		RespBean result = new RespBean();
		boolean flag = videoInfoVoService.modifyVideoInfoDetail(videoInfoPojo);
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	/**
	 * 根据id获取一条视频信息
	 * @param id
	 * @return
	 */
	@GetMapping( "/videoInfoVo/{sysId}")
	public RespBean queryOneById(@PathVariable(name="sysId") String id){
		RespBean result = new RespBean();
		VideoInfoVo videoInfoVo = videoInfoVoService.selectById(id);
		if (videoInfoVo != null) {
			result.setStatus(200);
			result.setMsg("SUCCESS");
			result.setObj(videoInfoVo);
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
		
	}
	/*
	@GetMapping("/board")
	public RespBean queryOnePage(int current,  int size, String ascs, String descs){
		System.out.println("current:" + current + ",size:" + size);
		//返回结果
		RespBean result = new RespBean();
		Page<Board> page = new Page<Board>();
		// 第几页
		page.setCurrent(current);
		// 一页要多少条数据
		page.setSize(size);
		// 过滤和排序等查询条件
		EntityWrapper<Board> wrapper = new EntityWrapper<Board>();
		Page<Board> resultPage = boardService.selectPage(page, wrapper);
		List<Board> data = resultPage.getRecords();
		//表中总的数据条数
		int total = resultPage.getTotal();
		if (data != null) {
			result.setStatus(200);
			result.setMsg("SUCCESS");
			result.setObj(data);
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}*/
}
