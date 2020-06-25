package com.ma.springboot.controller;

import com.ma.springboot.service.FileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private FileReaderService fileReaderService;

    @GetMapping
    public String getIndex() {
        return "index";
    }
}
