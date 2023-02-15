package com.en.pojo.vo.req.save;

import com.en.pojo.po.Sentences;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WordsReqVo{
    private Integer id;
    //单词
    private String word;

    private Integer level;
    //中文意思
    private String meanCn;

    private List<Sentences> sentences;
}