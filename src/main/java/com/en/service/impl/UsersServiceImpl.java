package com.en.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.en.mapper.UsersMapper;
import com.en.pojo.po.Users;
import com.en.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usersService")
@Transactional
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}

