package com.en.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.en.mapper.WordsMapper;
import com.en.pojo.po.Words;
import com.en.pojo.vo.list.WordsVo;
import com.en.service.WordsService;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service()
// @Service("WrodsService") 起个别名 也可以不要
// @Transactional 最好放在方法上
public class WordsServiceImpl extends ServiceImpl<WordsMapper, Words> implements WordsService {

  @Override
  public WordsVo getWord(String word) {
    System.out.println(baseMapper.selectWord(word));

    return baseMapper.selectWord(word);
  }
}

