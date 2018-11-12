package com.mugua.dianying.service.Impl;

import com.mugua.dianying.entity.User;
import com.mugua.dianying.mapper.UserMapper;
import com.mugua.dianying.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaobai123
 * @since 2018-10-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
