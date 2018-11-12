package com.mugua.dianying.pojo;

import com.mugua.dianying.entity.Board;
import com.mugua.dianying.entity.ExtendType;
import com.mugua.dianying.entity.ExtendTypeVal;
import com.mugua.dianying.entity.ValScope;
import com.mugua.dianying.entity.VideoInfo;
import com.mugua.dianying.entity.VideoInfoBoard;

import lombok.Data;

@Data
public class VideoInfoPojo {
	// 接收参数用
	VideoInfo videoInfo;
	Board board;
	ExtendType extendType;
	ValScope valScope;
	VideoInfoBoard videoInfoBoard;
	ExtendTypeVal[] extendTypeValList;
}
