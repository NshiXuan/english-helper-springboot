package com.en.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.en.mapper.SentencesMapper;
import com.en.pojo.po.Sentences;
import com.en.service.SentencesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("sentencesService")
@Transactional
public class SentencesServiceImpl extends ServiceImpl<SentencesMapper, Sentences> implements SentencesService {

}

