package com.en.pojo.vo.req.save;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CollectWordReqVo{
    
    private Integer collectId;
    
    private Integer wordId;
}
