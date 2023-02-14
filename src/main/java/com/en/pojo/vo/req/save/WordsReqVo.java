package com.en.pojo.vo.req.save;

import com.en.pojo.po.Sentences;
import lombok.Data;

import java.util.List;

@Data
public class WordsReqVo{
    private Integer id;
    //单词
    private String word;

    private Integer level;
    //中文意思
    private String meanCn;

    private List<Sentences> sentences;
}