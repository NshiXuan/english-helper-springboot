package com.en.pojo.vo.req.save;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CollectsReqVo{
    
    private Integer id;
    
    private Integer userId;
    //收藏夹名称
    private String name;
}
