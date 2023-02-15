package com.en.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.en.pojo.po.Words;
import com.en.pojo.vo.list.WordsVo;
import java.util.List;

public interface WordsService extends IService<Words> {
  WordsVo getWord(String word);

  List<WordsVo> getWordList();
}

