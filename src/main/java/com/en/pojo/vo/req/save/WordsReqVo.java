package com.en.pojo.vo.req.save;

import lombok.Data;

@Data
public class WordsReqVo{
    private Long id;

    //单词
    private String word;
    
    private Integer level;

    //中文意思
    private String meanCn;
}
