package com.en.pojo.po;

import lombok.Data;

@Data
public class Collects{
    
    private Integer id;
    
    private Integer userId;
    //收藏夹名称
    private String name;
    //单词id
    private Long wrodId;
}
