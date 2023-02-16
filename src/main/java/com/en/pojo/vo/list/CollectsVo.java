package com.en.pojo.vo.list;

import com.en.pojo.po.Users;
import com.en.pojo.po.Words;
import lombok.Data;

import java.util.List;

@Data
public class CollectsVo{
    private Integer id;
    
    //收藏夹名称
    private String name;
    //单词id
    private Users user;

    private List<Words> words;
}
