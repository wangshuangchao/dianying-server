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
import com.mugua.dianying.common.constant.CommonConstant;
import com.mugua.dianying.common.pojo.RespBean;
import com.mugua.dianying.common.utils.ObjectId;
import com.mugua.dianying.entity.Board;
import com.mugua.dianying.entity.ExtendType;
import com.mugua.dianying.entity.ValScope;
import com.mugua.dianying.service.ExtendTypeService;
import com.mugua.dianying.service.ValScopeService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 扩展属性
 * @author 28695
 *
 */
@RestController
public class ExtendTypeController {
	@Autowired
	ExtendTypeService extendTypeService;
	@Autowired
	ValScopeService valScopeService;
	
	/**
	 *  添加扩展属性
	 * @param extendType
	 * @return
	 */
	@PostMapping("/extendtype")
	public RespBean add(@RequestBody ExtendType extendType){
		RespBean result = new RespBean();
		String sysId = ObjectId.getObjectId();
		extendType.setSysId(sysId);
		// 0,单选 1,多选 2,数值 3,字符串
		extendType.setExtendType(extendType.getExtendType());
		extendType.setCreateTime(new Date());
		// 当前登录的操作员
		extendType.setCreateMan("张三");
		extendType.setModifyTime(new Date());
		System.out.println(new Date());
		// 当前登录的操作员
		extendType.setModifyMan("张三");
		boolean flag = extendTypeService.insert(extendType);
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
	 *  根据id删除某个扩展属性(软删除)
	 * @param id
	 * @return
	 */
	@DeleteMapping("/extendtype/{sysId}")
	public RespBean delete(@PathVariable(name = "sysId") String id){
		RespBean result = new RespBean();
		EntityWrapper wrapperValScope = new EntityWrapper();
		List<ValScope> data = valScopeService.selectList(wrapperValScope.eq("extend_type", id));
		// 如果扩展属性已有可选值,不允许删除
		if (data.size() != 0) {
			result.setStatus(500);
			result.setMsg("FAULT");
			return result;
		}
		ExtendType extendType = extendTypeService.selectById(id);
		extendType.setModifyMan("张三");
		extendType.setModifyTime(new Date());
		extendType.setIsDelete(CommonConstant.DELETE);
		EntityWrapper wrapperExtendType = new EntityWrapper();
		// 软删除
		boolean flag = extendTypeService.update(extendType, wrapperExtendType.eq("sys_id", id));
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
	 * 
	 * @param extendType
	 * @return
	 */
	@PutMapping("/extendtype")
	public RespBean modify(@RequestBody ExtendType extendType){
		RespBean result = new RespBean();
		extendType.setModifyMan("张三");
		extendType.setModifyTime(new Date());
		System.out.println("board:" + extendType.toString());
		boolean flag = extendTypeService.updateById(extendType);
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
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping( "/extendtype/{sysId}")
	public RespBean queryOneById(@PathVariable(name="sysId") String id){
		ExtendType extendType = extendTypeService.selectById(id);
		RespBean result = new RespBean();
		if (extendType != null) {
			result.setStatus(200);
			result.setMsg("SUCCESS");
			result.setObj(extendType);
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;
		
	}
	
	/**
	 * 
	 * @param current
	 * @param size
	 * @param ascs
	 * @param descs
	 * @return
	 */
	@GetMapping("/extendtype")
	public RespBean queryOnePage(int current,  int size, String ascs, String descs){
		System.out.println("current:" + current + ",size:" + size);
		//返回结果
		RespBean result = new RespBean();
		Page<ExtendType> page = new Page<ExtendType>();
		page.setCurrent(current);
		page.setSize(size);
		// 过滤和排序等查询条件
		EntityWrapper<ExtendType> wrapper = new EntityWrapper<ExtendType>();
		Page<ExtendType> resultPage = extendTypeService.selectPage(page, wrapper);
		List<ExtendType> data = resultPage.getRecords();
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

