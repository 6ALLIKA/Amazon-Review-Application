package com.ma.springboot.service;

import java.util.List;

public interface FileReaderService {

    List<String> readAllLines(String path);
}
