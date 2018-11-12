package com.mugua.dianying.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mugua.dianying.common.pojo.RespBean;
import com.mugua.dianying.common.utils.ObjectId;
import com.mugua.dianying.entity.ClientUser;
import com.mugua.dianying.entity.ExtendType;
import com.mugua.dianying.service.ClientUserService;
import com.mugua.dianying.service.ExtendTypeService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaobai123
 * @since 2018-11-05
 */
@RestController
public class ClientUserController {
	@Autowired
	ClientUserService clientUserService;
	
	@PostMapping("/clientUser")
	public RespBean add(@RequestBody ClientUser clientUser){
		RespBean result = new RespBean();
		// 创建id
		String sysId = ObjectId.getObjectId();
		clientUser.setSysId(sysId);
		// 注册时间
		clientUser.setRegTime(new Date());
		// 访问时间
		clientUser.setLastVisitTime(new Date());
		boolean flag = clientUserService.insert(clientUser);
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
	 * 注销,伪删除
	 * @param id
	 * @return
	 */
	@DeleteMapping("/clientUser/{sysId}")
	public RespBean delete(@PathVariable(name = "sysId") String id){
		RespBean result = new RespBean();
		ClientUser clientUser = clientUserService.selectById(id);
		clientUser.setLastVisitTime(new Date());
		clientUser.setIsDelete(1);
		boolean flag = clientUserService.updateById(clientUser);
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	@PutMapping("/clientUser")
	public RespBean modify(@RequestBody ClientUser clientUser){
		RespBean result = new RespBean();
		clientUser.setLastVisitTime(new Date());
		boolean flag = clientUserService.updateById(clientUser);
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	@GetMapping( "/clientUser/{sysId}")
	public RespBean queryOneById(@PathVariable(name="sysId") String id){
		ClientUser clientUser = clientUserService.selectById(id);
		RespBean result = new RespBean();
		if (clientUser != null) {
			result.setStatus(200);
			result.setMsg("SUCCESS");
			result.setObj(clientUser);
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
	}
	
	@GetMapping("/clientUser")
	public RespBean queryOnePage(int current,  int size, String ascs, String descs){
		System.out.println("current:" + current + ",size:" + size);
		//返回结果
		RespBean result = new RespBean();
		Page<ClientUser> page = new Page<ClientUser>();
		// 第几页
		page.setCurrent(current);
		// 一页要多少条数据
		page.setSize(size);
		// 过滤和排序等查询条件
		EntityWrapper<ClientUser> wrapper = new EntityWrapper<ClientUser>();
		Page<ClientUser> resultPage = clientUserService.selectPage(page, wrapper);
		List<ClientUser> data = resultPage.getRecords();
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

