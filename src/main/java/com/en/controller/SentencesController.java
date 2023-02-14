package com.en.controller;



import com.baomidou.mybatisplus.extension.service.IService;
import com.en.pojo.po.Sentences;
import com.en.pojo.vo.req.save.SentencesReqVo;
import com.en.service.SentencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequestMapping("/sentencess")
public class SentencesController extends BaseController<Sentences, SentencesReqVo> {
    @Autowired
    private SentencesService service;


    @Override
    protected IService<Sentences> getService() {
        return null;
    }

    @Override
    protected Function<SentencesReqVo, Sentences> getFunction() {
        return null;
    }
}

