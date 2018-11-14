package com.mugua.dianying.service.Impl;

import com.mugua.dianying.entity.VideoInfo;
import com.mugua.dianying.mapper.VideoInfoMapper;
import com.mugua.dianying.service.VideoInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户端展示的视频信息及用到的视频信息 服务实现类
 * </p>
 *
 * @author xiaobai123
 * @since 2018-11-14
 */
@Service
public class VideoInfoServiceImpl extends ServiceImpl<VideoInfoMapper, VideoInfo> implements VideoInfoService {

}
