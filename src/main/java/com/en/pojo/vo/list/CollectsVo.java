package com.en.pojo.vo.list;

import lombok.Data;

@Data
public class CollectsVo{
    
    private Integer id;
    
    private Integer userId;
    //收藏夹名称
    private String name;
    //单词id
    private Long wrodId;
}
