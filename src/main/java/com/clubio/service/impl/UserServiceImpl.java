package com.clubio.service.impl;

import com.clubio.entity.User;
import com.clubio.mapper.UserMapper;
import com.clubio.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Smile
 * @since 2023-10-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
