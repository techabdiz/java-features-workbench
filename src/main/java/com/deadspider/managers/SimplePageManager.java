package com.deadspider.managers;

import com.deadspider.Node;
import com.deadspider.Page;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

@ToString
public class SimplePageManager<T> implements PageManager<T>{
    private final LinkedList<Page<T>> pages = new LinkedList<>();



    public Page<T> getPageFor(T i) {
        if(pages.isEmpty() || pages.getLast().isFull()) {
            Page p = new Page();
            pages.add(p);
        }
        return pages.getLast();
    }

    public void add(T i) {
        getPageFor(i).add(new Node(i));
    }

    public void remove(T i) {
        Page<T> p = getPageFor(i);
        if(p.getNode(i).isPresent()) {
            p.remove(p.getNode(i).get());
        }
    }

    public boolean has(T i) {
        return pages.stream().anyMatch(node->node.getNode(i).isPresent());
    }

}
