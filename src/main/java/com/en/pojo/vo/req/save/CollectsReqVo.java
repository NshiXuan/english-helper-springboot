package com.en.pojo.vo.req.save;

import lombok.Data;

@Data
public class CollectsReqVo{
    
    private Integer id;
    
    private Integer userId;
    //收藏夹名称
    private String name;
    //单词id
    private Long wrodId;
}
