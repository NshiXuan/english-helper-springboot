package com.en.controller;



import com.en.service.CollectWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collectWords")
public class CollectWordController {
    @Autowired
    private CollectWordService service;


}

