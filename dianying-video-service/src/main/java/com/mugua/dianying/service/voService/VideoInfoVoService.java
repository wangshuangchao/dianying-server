package com.mugua.dianying.service.voService;

import com.mugua.dianying.pojo.VideoInfoPojo;
import com.mugua.dianying.vo.VideoInfoVo;

/**
 * 接收前端传递的参数
 * @author 28695
 *
 */
public interface VideoInfoVoService {
	public boolean addVideoInfoVo(VideoInfoPojo videoInfoPojo) ;
	public boolean deleteVideoInfoVo(String sysId) ;
	public boolean modifyVideoInfoDetail(VideoInfoPojo videoInfoPojo) ;
	public VideoInfoVo selectById(String id);
}
