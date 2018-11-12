package com.mugua.dianying.service.Impl;

import com.mugua.dianying.entity.Board;
import com.mugua.dianying.mapper.BoardMapper;
import com.mugua.dianying.service.BoardService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 某个视频隶属的版块(例如:电影,电视剧,动漫) 服务实现类
 * </p>
 *
 * @author xiaobai123
 * @since 2018-11-06
 */
@Service
public class BoardServiceImpl extends ServiceImpl<BoardMapper, Board> implements BoardService {

}
