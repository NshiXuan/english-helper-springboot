package com.en.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.en.mapper.CollectsMapper;
import com.en.pojo.po.Collects;
import com.en.service.CollectsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("collectsService")
public class CollectsServiceImpl extends ServiceImpl<CollectsMapper, Collects> implements CollectsService {

}

