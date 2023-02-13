package com.en.pojo.po;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Words{
    
    private Long id;
    //单词
    private String word;
    
    private Integer level;
    //中文意思
    private String meanCn;
}
