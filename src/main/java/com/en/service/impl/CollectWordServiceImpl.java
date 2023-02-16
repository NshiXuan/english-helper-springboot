package com.en.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.en.mapper.CollectWordMapper;
import com.en.pojo.po.CollectWord;
import com.en.service.CollectWordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("collectWordService")
@Transactional
public class CollectWordServiceImpl extends ServiceImpl<CollectWordMapper, CollectWord> implements CollectWordService {

}

