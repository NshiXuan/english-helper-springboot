package com.en.mapStruct;

import com.en.pojo.po.Collects;
import com.en.pojo.po.Users;
import com.en.pojo.po.Words;
import com.en.pojo.vo.list.WordsVo;
import com.en.pojo.vo.req.save.CollectsReqVo;
import com.en.pojo.vo.req.save.UsersReqVo;
import com.en.pojo.vo.req.save.WordsReqVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
// 我们在这里定义的接口 Mapstructs会自动生成对应的impl转成Vo或Po, ReqVo转成Po
// 内部的原理很简单 就是通过setXXX一个一个的赋值
public interface MapStructs {
  MapStructs INSTANCE = Mappers.getMapper(MapStructs.class);

  /* Po -> Vo*/
  WordsVo po2vo(Words po);

  // LoginVo po2loginVo(Users po);

  /* ReqVo -> Po */
  Words reqVo2po(WordsReqVo reqVo);

  Users reqVo2po(UsersReqVo reqVo);

  Collects reqVo2po(CollectsReqVo reqVo);

  // 把WordReqVo数据转成List<Sentences>
  // List<Sentences> reqVO2List(List<> reqVo);
}
