package com.ma.springboot.controller;

import com.ma.springboot.service.FileReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class IndexController {
    private final FileReaderService fileReaderService;

    @GetMapping
    public String getIndex() {
        return "index";
    }
}
