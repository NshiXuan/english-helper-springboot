package com.en.controller;



import com.en.service.SentencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sentencess")
public class SentencesController {
    @Autowired
    private SentencesService service;


}

