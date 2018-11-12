package com.mugua.dianying.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mugua.dianying.common.pojo.RespBean;
import com.mugua.dianying.common.utils.ObjectId;
import com.mugua.dianying.entity.ExtendType;
import com.mugua.dianying.entity.VideoInfo;
import com.mugua.dianying.service.ExtendTypeService;
import com.mugua.dianying.service.VideoInfoService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 客户端展示的视频信息及用到的视频信息 前端控制器
 * </p>
 *
 * @author xiaobai123
 * @since 2018-11-02
 */
@Controller
public class VideoInfoController {
	@Autowired
	VideoInfoService videoInfoService;
	
	@PostMapping("/videoInfo")
	public RespBean add(@RequestBody VideoInfo videoInfo){
		RespBean result = new RespBean();
		String sysId = ObjectId.getObjectId();
		videoInfo.setSysId(sysId);
		boolean flag = videoInfoService.insert(videoInfo);
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	@DeleteMapping("/videoInfo/{sysId}")
	public RespBean delete(@PathVariable(name = "sysId") String id){
		RespBean result = new RespBean();
		VideoInfo videoInfo = videoInfoService.selectById(id);
		boolean flag = videoInfoService.deleteById(id);
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	@PutMapping("/videoInfo")
	public RespBean modify(@RequestBody VideoInfo videoInfo){
		RespBean result = new RespBean();
		System.out.println("board:" + videoInfo.toString());
		boolean flag = videoInfoService.updateById(videoInfo);
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	@GetMapping( "/videoInfo/{sysId}")
	public RespBean queryOneById(@PathVariable(name="sysId") String id){
		VideoInfo videoInfo = videoInfoService.selectById(id);
		RespBean result = new RespBean();
		if (videoInfo != null) {
			result.setStatus(200);
			result.setMsg("SUCCESS");
			result.setObj(videoInfo);
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
		
	}
	@GetMapping("/videoInfo")
	public RespBean queryOnePage(int current,  int size, String ascs, String descs){
		System.out.println("current:" + current + ",size:" + size);
		//返回结果
		RespBean result = new RespBean();
		Page<VideoInfo> page = new Page<VideoInfo>();
		// 第几页
		page.setCurrent(current);
		// 一页要多少条数据
		page.setSize(size);
		// 过滤和排序等查询条件
		EntityWrapper<VideoInfo> wrapper = new EntityWrapper<VideoInfo>();
		Page<VideoInfo> resultPage = videoInfoService.selectPage(page, wrapper);
		List<VideoInfo> data = resultPage.getRecords();
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
	}
}

