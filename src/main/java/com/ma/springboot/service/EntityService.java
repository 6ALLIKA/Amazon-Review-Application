package com.ma.springboot.service;

import java.util.List;
import java.util.Set;

public interface EntityService<T> {

    T save(T element);

    List<T> saveAll(Set<T> elements);
}
