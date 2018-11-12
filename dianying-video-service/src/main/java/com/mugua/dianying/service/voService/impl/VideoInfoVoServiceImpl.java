package com.mugua.dianying.service.voService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mugua.dianying.common.utils.ObjectId;
import com.mugua.dianying.entity.Board;
import com.mugua.dianying.entity.ExtendType;
import com.mugua.dianying.entity.ExtendTypeVal;
import com.mugua.dianying.entity.ValScope;
import com.mugua.dianying.entity.VideoInfo;
import com.mugua.dianying.entity.VideoInfoBoard;
import com.mugua.dianying.mapper.vomapper.VideoInfoVoMapper;
import com.mugua.dianying.pojo.VideoInfoPojo;
import com.mugua.dianying.service.ExtendTypeValService;
import com.mugua.dianying.service.ValScopeService;
import com.mugua.dianying.service.VideoInfoBoardService;
import com.mugua.dianying.service.VideoInfoService;
import com.mugua.dianying.service.voService.VideoInfoVoService;
import com.mugua.dianying.vo.VideoInfoVo;

@Service
@Transactional
public class VideoInfoVoServiceImpl implements VideoInfoVoService {
	@Autowired
	VideoInfoService videoInfoService;
	@Autowired
	VideoInfoBoardService videoInfoBoardService;
	@Autowired
	ExtendTypeValService extendTypeValService;
	@Autowired
	VideoInfoVoMapper videoInfoVoMapper;

	/**
	 *  添加视频信息,包含版块信息和扩展属性值信息
	 */
	@Override
	public boolean addVideoInfoVo(VideoInfoPojo videoInfoPojo) {

		// 从videoIfoVO中获取VideoInfo,VideoInfoBoard,ExtendTypeVal[]
		VideoInfo videoInfoEntity = videoInfoPojo.getVideoInfo();
		VideoInfoBoard videoInfoBoard = videoInfoPojo.getVideoInfoBoard();
		ExtendTypeVal[] extendTypeValEntityList = videoInfoPojo.getExtendTypeValList();

		//如果视频信息存在则返回,否则添加视频信息id
		String sysIdVideoInfo = videoInfoEntity.getSysId();
		if (sysIdVideoInfo != null) {
			return false;
		}else {
			sysIdVideoInfo = ObjectId.getObjectId();
			videoInfoEntity.setSysId(sysIdVideoInfo);
		}

		boolean flag = false;
		// 添加视频基本信息
		boolean flagVideoInfo = videoInfoService.insert(videoInfoEntity);
		// 添加视频信息和版块信息关联信息
		videoInfoBoard.setSysId(ObjectId.getObjectId());
		videoInfoBoard.setVideoInfo(sysIdVideoInfo);
		boolean flagVideoInfoBoard = videoInfoBoardService.insert(videoInfoBoard);
		// 添加视频扩展属性值
		boolean flagExtendTypeValList = true;
		for (ExtendTypeVal extendTypeVal : extendTypeValEntityList) {
			extendTypeVal.setSysId(ObjectId.getObjectId());
			extendTypeVal.setVideoInfo(sysIdVideoInfo);
			boolean flagExtendTypeVal = extendTypeValService.insert(extendTypeVal);
			if (!flagExtendTypeVal) {
				flagExtendTypeValList = false;
			}
		}

		//两个都添加成则成功
		if (flagVideoInfo && flagVideoInfoBoard&&flagExtendTypeValList) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 根据id删除视频信息(软删除)
	 * 0:未删除,1:删除
	 */
	@Override
	public boolean deleteVideoInfoVo(String sysId) {
		VideoInfo videoInfo = videoInfoService.selectById(sysId);
		videoInfo.setIsDelete(1);
		EntityWrapper<VideoInfo> wrapper = new EntityWrapper<VideoInfo>();
		boolean flag = videoInfoService.update(videoInfo, wrapper.eq("sys_id", sysId));
		return flag;
	}

	/**
	 * 修改视频信息详情
	 * @param videoInfoVo
	 * @return
	 */
	@Override
	public boolean modifyVideoInfoDetail(VideoInfoPojo videoInfoPojo) {
		// 从videoIfoVO中获取VideoInfo,VideoInfoBoard,ExtendTypeVal[]
		VideoInfo videoInfoEntity = videoInfoPojo.getVideoInfo();
		VideoInfoBoard videoInfoBoard = videoInfoPojo.getVideoInfoBoard();
		ExtendTypeVal[] extendTypeValEntityList = videoInfoPojo.getExtendTypeValList();

		//如果视频信息不存在则返回
		String sysIdVideoInfo = videoInfoEntity.getSysId();
		if (sysIdVideoInfo == null) {
			return false;
		}

		boolean flag = false;
		// 添加视频基本信息
		EntityWrapper<VideoInfo> wrapperVideoInfo = new EntityWrapper<VideoInfo>();
		boolean flagVideoInfo = videoInfoService.update(videoInfoEntity, wrapperVideoInfo.eq("sys_id", sysIdVideoInfo));
		// 添加视频信息和版块信息关联信息
		String sysIdVideoInfoBoard = videoInfoBoard.getSysId();
		EntityWrapper<VideoInfoBoard> wrapperVideoInfoBoard = new EntityWrapper<VideoInfoBoard>();
		boolean flagVideoInfoBoard = videoInfoBoardService.update(videoInfoBoard, wrapperVideoInfoBoard.eq("sys_id", sysIdVideoInfoBoard));
		// 添加视频扩展属性值
		boolean flagExtendTypeValList = true;
		for (ExtendTypeVal extendTypeVal : extendTypeValEntityList) {
			String sysIdextendTypeVal = extendTypeVal.getSysId();
			EntityWrapper<ExtendTypeVal> wrapperExtendTypeVal = new EntityWrapper<ExtendTypeVal>();
			boolean flagExtendTypeVal = extendTypeValService.update(extendTypeVal, wrapperExtendTypeVal.eq("sys_id", sysIdextendTypeVal));
			if (!flagExtendTypeVal) {
				flagExtendTypeValList = false;
			}
		}

		//两个都添加成则成功
		if (flagVideoInfo && flagVideoInfoBoard&&flagExtendTypeValList) {
			flag = true;
		}
		return flag;
	}

	
	/**
	 *  根据id查询某一条视频信息
	 */
	@Override
	public VideoInfoVo selectById(String id) {
		VideoInfoVo videoInfoVo = videoInfoVoMapper.selectById(id);
		System.out.println("videoInfoVo: " + videoInfoVo);
		return videoInfoVo;
	}

}
