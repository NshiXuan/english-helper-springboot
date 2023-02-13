package com.en.pojo.vo.req.save;

import lombok.Data;

@Data
public class UsersReqVo{
    //主键
    private Integer id;
    
    private String username;
    
    private String password;
}
