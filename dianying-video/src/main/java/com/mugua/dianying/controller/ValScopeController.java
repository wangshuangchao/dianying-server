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
import com.mugua.dianying.pojo.ValScopePojo;
import com.mugua.dianying.service.BoardService;
import com.mugua.dianying.service.ExtendTypeService;
import com.mugua.dianying.service.ValScopeService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 扩展属性可选值
 * @author 28695
 *
 */
@RestController
public class ValScopeController {
	@Autowired
	ValScopeService valScopeService;
	@Autowired
	ExtendTypeService extendTypeService;

	/**
	 * 给某个扩展属性添加可选值
	 * @param valScopePojo
	 * @return
	 */
	@PostMapping("/valScope")
	public RespBean add(@RequestBody ValScopePojo valScopePojo){
		RespBean result = new RespBean();
		String extendTypeId = valScopePojo.getExtendTypeSysId();
		// 如果没有传递扩展属性id或者扩展属性不存在,不允许添加扩展属性可选值
		if (extendTypeId != null) {
			ExtendType extendType = extendTypeService.selectById(extendTypeId);
			if (extendType == null) {
				result.setStatus(500);
				result.setMsg("FAULT");
				return result;
			}
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
			return result;
		}
		
		// 哪个扩展属性的值
		ValScope valScope = valScopePojo.getValScope();
		valScope.setExtendType(extendTypeId);
		valScope.setSysId(ObjectId.getObjectId());
		// 当前登录的操作员
		valScope.setCreateMan("李四");
		valScope.setCreateTime(new Date());
		// 当前登录的操作员
		valScope.setModifyMan("李四");
		valScope.setModifyTime(new Date());
		boolean flag = valScopeService.insert(valScope);
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
	 * 删除某个扩展属性的某个值
	 * @param id
	 * @return
	 */
	@DeleteMapping("/valScope/{sysId}")
	public RespBean delete(@PathVariable(name = "sysId") String id){
		RespBean result = new RespBean();
		ValScope valScope = valScopeService.selectById(id);
		if (valScope == null) {
			result.setStatus(500);
			result.setMsg("FAULT");
			return result;
		}
		// 登录的操作员
		valScope.setModifyMan("王五");
		valScope.setModifyTime(new Date());
		// 软删除,更改字段is_delete的值,0:未删除(默认值),1:删除
		valScope.setIsDelete(CommonConstant.DELETE);
		EntityWrapper wrapper = new EntityWrapper();
		boolean flag = valScopeService.update(valScope, wrapper.eq("sys_id", id));
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
	 *  修改扩展属性的某个可选值的值
	 * @param valScope
	 * @return
	 */
	@PutMapping("/valScope")
	public RespBean modify(@RequestBody ValScope valScope){
		RespBean result = new RespBean();
		// 登录的操作员
		valScope.setModifyMan("赵六");
		valScope.setModifyTime(new Date());
		boolean flag = valScopeService.updateById(valScope);
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
	 * 根据id获取扩展属性可选值的某个值的详细信息
	 * @param id
	 * @return
	 */
	@GetMapping( "/valScope/{sysId}")
	public RespBean queryOneById(@PathVariable(name="sysId") String id){
		RespBean result = new RespBean();
		ValScope valScope =valScopeService.selectById(id);
		if (valScope.getIsDelete() == 1) {
			result.setStatus(500);
			result.setMsg("FAULT");
			return result;
		}
		if (valScope != null) {
			result.setStatus(200);
			result.setMsg("SUCCESS");
			result.setObj(valScope);
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		return result;

	}

	/**
	 * 分页查询或者按扩展属性查询
	 * @param current 当前页
	 * @param size 每页多少条数据
	 * @param ascs
	 * @param descs
	 * @param extendType 扩展属性id
	 * @return
	 */
	@GetMapping("/valScope")
	public RespBean queryOnePage(String current,  String size, String ascs, String descs, String extendType){
		//返回结果
		RespBean result = new RespBean();
		// 分页查询
		if (extendType == null && !"0".equals(current) && !"0".equals(size)) {
			Page<ValScope> page = new Page<ValScope>();
			page.setCurrent(Integer.parseInt(current));
			page.setSize(Integer.parseInt(size));
			EntityWrapper<ValScope> wrapper = new EntityWrapper<ValScope>();
			Page<ValScope> resultPage = valScopeService.selectPage(page, wrapper.eq("is_delete", 0));
			List<ValScope> data = resultPage.getRecords();
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
		}
		// 根据扩展属性查询
		if (extendType != null) {
			EntityWrapper<ValScope> wrapper = new EntityWrapper<ValScope>();
			List<ValScope> data = valScopeService.selectList(wrapper.eq("extend_type", extendType).eq("is_delete", 0));
			if (data != null) {
				result.setStatus(200);
				result.setMsg("SUCCESS");
				result.setObj(data);
			}else {
				result.setStatus(500);
				result.setMsg("FAULT");
			}
		}
		return result;
	}
}

