package com.en.pojo.vo.req.save;

import lombok.Data;

@Data
public class SentencesReqVo{
    
    private Integer id;
    //例句
    private String sentence;
    //例句中文
    private String sentenceCn;
}
