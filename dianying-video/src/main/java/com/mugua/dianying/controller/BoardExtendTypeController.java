package com.mugua.dianying.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mugua.dianying.common.pojo.RespBean;
import com.mugua.dianying.common.utils.ObjectId;
import com.mugua.dianying.entity.BoardExtendType;
import com.mugua.dianying.pojo.BoardExtendTypePojo;
import com.mugua.dianying.service.BoardExtendTypeService;
import com.mugua.dianying.service.BoardService;
import com.mugua.dianying.service.ExtendTypeService;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaobai123
 * @since 2018-11-08
 */
@RestController

public class BoardExtendTypeController {
	@Autowired
	BoardService boardService;
	@Autowired
	ExtendTypeService extendTypeService;
	@Autowired
	BoardExtendTypeService boardExtendTypeService; 
	
	/**
	 * 给版块绑定扩展属性
	 * @param boardExtendTypePojo
	 * @return
	 */
	@PostMapping("/boardExtendType")
	public RespBean add(@RequestBody BoardExtendTypePojo boardExtendTypePojo) {
		RespBean result = new RespBean();
		String boardSysId = boardExtendTypePojo.getBoardSysId();
		String extendTypeSysId = boardExtendTypePojo.getExtendTypeSysId();
		// 如果版块或扩展属性不存在,不允许绑定
		if (boardService.selectById(boardSysId) == null || extendTypeService.selectById(extendTypeSysId) == null) {
			result.setStatus(500);
			result.setMsg("FAULT");
			return result;
		}
		String boardExtendTypeSysId = ObjectId.getObjectId();
		BoardExtendType boardExtendType = new BoardExtendType();
		boardExtendType.setSysId(boardExtendTypeSysId);
		boardExtendType.setExtendSection(boardSysId);
		boardExtendType.setExtendTypes(extendTypeSysId);
		// 进行绑定
		boolean flag = boardExtendTypeService.insert(boardExtendType);
		if (flag) {
			result.setStatus(200);
			result.setMsg("SUCCESS");
		}else {
			result.setStatus(500);
			result.setMsg("FAULT");
		}
		
		return result;
	}
}

