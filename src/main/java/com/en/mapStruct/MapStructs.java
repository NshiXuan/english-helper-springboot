package com.en.mapStruct;

import com.en.pojo.po.Words;
import com.en.pojo.vo.list.WordsVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructs {
  MapStructs INSTANCE = Mappers.getMapper(MapStructs.class);

  /* Po -> Vo*/
  WordsVo po2vo(Words po);

  // LoginVo po2loginVo(Users po);

  /* ReqVo -> Po */
  // Chat reqVo2po(ChatReqVo reqVo);

  // Favor reqVo2po(FavorReqVo reqVo);

  // Goods reqVo2po(GoodsReqVo reqVo);

  // Users reqVo2po(UsersReqVo reqVo);
}
