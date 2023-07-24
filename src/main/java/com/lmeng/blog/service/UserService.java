package com.lmeng.blog.service;

import com.lmeng.blog.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 26816
* @description 针对表【ms_sys_user】的数据库操作Service
* @createDate 2023-07-24 10:34:45
*/
public interface UserService extends IService<User> {


    User findUserById(Long userId);
}
