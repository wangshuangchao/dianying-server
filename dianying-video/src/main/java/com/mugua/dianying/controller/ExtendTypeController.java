package com.mugua.dianying.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mugua.dianying.common.constant.CommonConstant;
import com.mugua.dianying.common.pojo.RespBean;
import com.mugua.dianying.common.utils.ObjectId;
import com.mugua.dianying.entity.ExtendType;
import com.mugua.dianying.entity.ValScope;
import com.mugua.dianying.service.BoardService;
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
	BoardService boardService;
	@Autowired
	ExtendTypeService extendTypeService;
	@Autowired
	ValScopeService valScopeService;

	/**
	 *  添加扩展属性
	 * @param extendType 添加的扩展属性
	 * @return 是否添加成功
	 */
	@PostMapping("/extendtype")
	public RespBean add(@RequestBody ExtendType extendType){
		RespBean result = new RespBean();

		// 如果扩展属性名为空字符串或者属性不在范围之内,则不允许添加,
		Integer typeVal = extendType.getExtendType();
		boolean bo = typeVal == null || typeVal != 0 && typeVal != 1 && typeVal != 2 && typeVal !=3; 
		if ("".equals(extendType.getName()) ||bo) {
			result.setStatus(500);
			result.setMsg("FAULT");
			return result;
		}

		// 添加id
		String sysId = ObjectId.getObjectId();
		extendType.setSysId(sysId);

		// 设置属性 0,单选 1,多选 2,数值 3,字符串
		extendType.setExtendType(extendType.getExtendType());
		extendType.setCreateTime(new Date());

		// 设置创建人(当前登录的操作员),创建时间 
		extendType.setCreateMan("张三");
		extendType.setModifyTime(new Date());
		System.out.println(new Date());

		// 设置修改人(当前登录的操作员),修改时间
		extendType.setModifyMan("张三");

		// 添加扩展属性
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
	 * @param id 扩展属性id
	 * @return 删除成功或失败
	 */
	@DeleteMapping("/extendtype/{sysId}")
	public RespBean delete(@PathVariable(name = "sysId") String id){
		RespBean result = new RespBean();

		// 如果扩展属性已有可选值,不允许删除
		EntityWrapper<ValScope> wrapperValScope = new EntityWrapper<ValScope>();
		wrapperValScope.eq("extend_type", id);
		List<ValScope> data = valScopeService.selectList(wrapperValScope);
		if (data.size() != 0) {
			result.setStatus(500);
			result.setMsg("FAULT");
			return result;
		}

		// 如果扩展属性不存在或者已经软删除,不允许删除
		ExtendType extendType = extendTypeService.selectById(id);
		if (extendType == null || extendType.getIsDelete() ==1) {
			result.setStatus(500);
			result.setMsg("FAULT");
			return result;
		}

		// 设置变动信息: 修改人,修改时间
		extendType.setModifyMan("张三");
		extendType.setModifyTime(new Date());

		// 进行软删除
		extendType.setIsDelete(CommonConstant.DELETE);
		EntityWrapper<ExtendType> wrapperExtendType = new EntityWrapper<ExtendType>();
		boolean flag = extendTypeService.update(extendType, wrapperExtendType.eq("sys_id", id));

		// 返回结果,是否(软)删除成功
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
	 * 修改扩展属性的名称或类型(单选,多选...)
	 * @param extendType 要改变的扩展属性
	 * @return 更改成功或失败
	 */
	@PutMapping("/extendtype")
	public RespBean modify(@RequestBody ExtendType extendType){
		RespBean result = new RespBean();

		// 如果扩展属性不存在或者已经软删除,不允许修改
		String id = extendType.getSysId();
		ExtendType extendTypeQue = extendTypeService.selectById(id);
		if (extendTypeQue == null || extendTypeQue.getIsDelete() == 1) {
			result.setStatus(500);
			result.setMsg("FAULT");
			return result;
		}

		// 设置修改人,修改时间
		extendType.setModifyMan("张三");
		extendType.setModifyTime(new Date());
		System.out.println("board:" + extendType.toString());

		// 进行修改
		boolean flag = extendTypeService.updateById(extendType);

		// 返回修改结果
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
	 * 根据id查询某个扩展属性信息
	 * @param id
	 * @return 扩展属性的详细信息
	 */
	@GetMapping( "/extendtype/{sysId}")
	public RespBean queryOneById(@PathVariable(name="sysId") String id){
		RespBean result = new RespBean();

		// 如果扩展属性不存在或者已经软删除,不允许查询
		ExtendType extendType = extendTypeService.selectById(id);
		if (extendType == null || extendType.getIsDelete() ==1) {
			result.setStatus(500);
			result.setMsg("FAULT");
			return result;
		}

		result.setStatus(200);
		result.setMsg("SUCCESS");
		result.setObj(extendType);
		return result;

	}

	/**
	 * 分页查询扩展属性或根据版块查询扩展属性
	 * @param current 当前页
	 * @param size 每页的数据个数
	 *  @param sizeboardSysId 某个版块id
	 * @return 查询到的扩展属性信息列表
	 */
	@GetMapping("/extendtype")
	public RespBean queryOnePage(String current,  String size, String boardSysId){
		RespBean result = new RespBean();

		// 分页查询
		if ((!"0".equals(current)) && (!"0".equals(size)) && 
				Integer.parseInt(current) > 0 && Integer.parseInt(size) > 0) {
			Page<ExtendType> page = new Page<ExtendType>();
			page.setCurrent(Integer.parseInt(current));
			page.setSize(Integer.parseInt(size));
			EntityWrapper<ExtendType> wrapper = new EntityWrapper<ExtendType>();

			// 如果接收了版块,则根据版块进行筛选
			if (boardSysId != null) {

				// 版块不存在,则查询失败
				if (boardService.selectById(boardSysId) != null){
					wrapper.eq("board", boardSysId);
				}else {
					result.setStatus(500);
					result.setMsg("FAULT");
					return result;
				}
			}
			Page<ExtendType> resultPage = extendTypeService.selectPage(page, wrapper.eq("is_delete", 0));
			List<ExtendType> data = resultPage.getRecords();

			// 表中总的数据条数
			// int total = resultPage.getTotal();
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

