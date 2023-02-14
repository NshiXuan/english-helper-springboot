package com.en.pojo.vo.list;

import com.en.pojo.po.Sentences;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WordsVo{
    private Integer id;
    private String word;
    private Integer level;
    private String meanCn;
    private List<Sentences> sentences;
}
