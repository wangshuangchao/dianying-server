package com.mugua.dianying.mapper.vomapper;

import org.apache.ibatis.annotations.Select;

import com.mugua.dianying.entity.Board;
import com.mugua.dianying.vo.VideoInfoVo;

public interface VideoInfoVoMapper {
	Integer addVideoInfoVo(VideoInfoVo videoInfoVo);
	
	@Select(value = { "select " + 
			"info.sys_id videoInfoSysId,info.amounts,info.witchone,info.picture,info.cost,info.putaway,info.test,info.test_man,info.test_time,info.video_from,info.url," +
			"info.counts,info.last_modify_time,info.last_modify_man,info.is_delete," +
			"board.sys_id boardSysId,board.name,board.create_time,board.create_man,board.modify_time,board.modify_man " + 
			"from " + 
			"video_info info,board board,video_info_board infoboard " + 
			"where " + 
			"infoboard.video_info = info.sys_id and infoboard.board = board.sys_id and info.sys_id = \'5be298b2a5800eaf9b954e57\';" })
	public VideoInfoVo selectById(String id);
	
	
}


