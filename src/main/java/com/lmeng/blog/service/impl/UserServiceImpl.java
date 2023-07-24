package com.lmeng.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmeng.blog.model.domain.User;
import com.lmeng.blog.service.UserService;
import com.lmeng.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 26816
* @description 针对表【ms_sys_user】的数据库操作Service实现
* @createDate 2023-07-24 10:34:45
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(Long userId) {
        User user = userMapper.selectById(userId);
        if (user == null) {
            user = new User();
            user.setNickname("码神之路");
        }
        return user;
    }

}




