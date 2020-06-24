package com.ma.springboot.controller;

import com.ma.springboot.service.FileReaderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private FileReaderService fileReaderService;

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @ResponseBody
    @GetMapping("/lines")
    public List<String> readLines(@Value("src/main/resources/Reviews.csv") String path) {
        return fileReaderService.readAllLines(path);
    }
}
