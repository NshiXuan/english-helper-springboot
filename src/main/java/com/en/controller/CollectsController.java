package com.en.controller;



import com.en.service.CollectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collectss")
public class CollectsController {
    @Autowired
    private CollectsService service;


}

