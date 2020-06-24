package com.ma.springboot.controller;

import com.ma.springboot.dao.FileDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private FileDao fileDao;

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @ResponseBody
    @GetMapping("/lines")
    public List<String> readLines() {
        return fileDao.readAllLines("src/main/resources/Reviews.csv");
    }
}
