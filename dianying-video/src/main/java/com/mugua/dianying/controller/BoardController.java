package com.mugua.dianying.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.mugua.dianying.common.pojo.RespBean;
import com.mugua.dianying.common.utils.ObjectId;
import com.mugua.dianying.entity.Board;
import com.mugua.dianying.entity.ExtendType;
import com.mugua.dianying.service.BoardService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 某个视频隶属的版块(例如:电影,电视剧,动漫) 前端控制器
 * </p>
 *
 * @author xiaobai123
 * @since 2018-11-02
 */
@RestController
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@PostMapping("/board")
	public RespBean add(@RequestBody Board board, @RequestBody ExtendType[] extendTypeList){
		RespBean result = new RespBean();
		String sysId = ObjectId.getObjectId();
		board.setSysId(sysId);
		board.setCreateTime(new Date());
		board.setModifyTime(new Date());
		boolean flag = boardService.insert(board);
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	@DeleteMapping("/board/{sysId}")
	public RespBean delete(@PathVariable(name = "sysId") String id){
		RespBean result = new RespBean();
		Board board = boardService.selectById(id);
		board.setModifyTime(new Date());
		boolean flag = boardService.deleteById(id);
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	@PutMapping("/board")
	public RespBean modify(@RequestBody Board board){
		RespBean result = new RespBean();
		board.setModifyTime(new Date());
		System.out.println("board:" + board.toString());
		boolean flag = boardService.updateById(board);
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	@GetMapping( "/board/{sysId}")
	public RespBean queryOneById(@PathVariable(name="sysId") String id){
		Board board = boardService.selectById(id);
		RespBean result = new RespBean();
		if (board != null) {
			result.setStatus(200);
			result.setMsg("SUCCESS");
			result.setObj(board);
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
		
	}
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
	}
}
	

