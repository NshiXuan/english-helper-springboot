package com.en.controller;



import com.en.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userss")
public class UsersController {
    @Autowired
    private UsersService service;


}

