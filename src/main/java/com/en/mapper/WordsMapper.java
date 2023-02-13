package com.en.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.en.pojo.po.Words;
import com.en.pojo.vo.list.WordsVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WordsMapper extends BaseMapper<Words> {
  WordsVo selectWord(String word);
}
