package com.en.controller;

import com.en.service.WordsService;
import com.en.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/words")
public class WordsController {
    @Autowired
    private WordsService service;

    /**
     *
     * @param word 单词名称
     * @return 单词数据
     */
    @GetMapping
    public R getWord(String word)   {
        return R.success( service.getWord(word));
    }
}

