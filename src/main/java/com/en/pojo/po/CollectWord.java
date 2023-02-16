package com.en.pojo.po;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
public class CollectWord{
    
    private Integer collectId;
    
    private Integer wordId;
}
