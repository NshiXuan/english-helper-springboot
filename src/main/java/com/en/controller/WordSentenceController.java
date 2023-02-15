package com.en.controller;



import com.en.service.WordSentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wordSentences")
public class WordSentenceController {
    @Autowired
    private WordSentenceService service;


}

