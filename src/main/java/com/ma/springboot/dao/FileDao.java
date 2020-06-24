package com.ma.springboot.dao;

import java.util.List;

public interface FileDao {

    List<String> readAllLines(String path);
}
