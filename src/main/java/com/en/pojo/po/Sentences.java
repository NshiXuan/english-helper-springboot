package com.en.pojo.po;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Sentences{
    
    private Integer id;
    //例句
    private String sentence;
    //例句中文
    private String sentenceCn;
}
