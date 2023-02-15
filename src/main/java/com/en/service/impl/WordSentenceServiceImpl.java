package com.en.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.en.mapper.WordSentenceMapper;
import com.en.pojo.po.WordSentence;
import com.en.service.WordSentenceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("wordSentenceService")
@Transactional
public class WordSentenceServiceImpl extends ServiceImpl<WordSentenceMapper, WordSentence> implements WordSentenceService {

}

