package com.en.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.en.mapStruct.MapStructs;
import com.en.pojo.po.Users;
import com.en.pojo.vo.req.save.UsersReqVo;
import com.en.service.UsersService;
import com.en.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequestMapping("/users")
public class UsersController extends BaseController<Users, UsersReqVo> {
  @Autowired
  private UsersService service;

  /**
   * 注册接口
   *
   * @param reqVo
   * @return
   */
  @PostMapping("/register")
  public R register(@RequestBody UsersReqVo reqVo) {
    // 1.获取参数 并转为po
    Users users = MapStructs.INSTANCE.reqVo2po(reqVo);

    // 2.判断用户是否已存在
    LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(Users::getUsername, users.getUsername());
    if (service.getOne(wrapper) != null) {
      return R.error("用户已存在");
    }

    // 3.不存在则添加用户
    service.save(users);

    return R.ok("注册成功");
  }

  /**
   * 登录接口
   *
   * @param reqVo 用户名称 用户密码
   * @return
   */
  @PostMapping("/login")
  public R login(@RequestBody UsersReqVo reqVo) {
    // 1.获取参数 转为po
    Users users = MapStructs.INSTANCE.reqVo2po(reqVo);

    // 2.判断用户密码是否存在
    LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(Users::getUsername, users.getUsername());
    Users resUser = service.getOne(wrapper);
    if (resUser == null) {
      return R.error("用户不存在");
    }

    // 3.判断用户密码是否正确
    if (!users.getPassword().equals(resUser.getPassword())) {
      return R.error("密码不正确");
    }

    return R.success(resUser);
  }

  /**
   * 获取用户列表
   * @return
   */
  @GetMapping("list")
  public R getUserList(){
    return  R.success(service.list());
  }


  @Override
  protected IService<Users> getService() {
    return service;
  }

  @Override
  protected Function<UsersReqVo, Users> getFunction() {
    return MapStructs.INSTANCE::reqVo2po;
  }
}

