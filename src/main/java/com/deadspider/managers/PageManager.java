package com.deadspider.managers;

import com.deadspider.Page;


public interface PageManager<T> {

    Page<T> getPageFor(T t);
    void add(T t);
    void remove(T t);
    boolean has(T t);

}
