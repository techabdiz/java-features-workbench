package com.deadspider.managers;

import com.deadspider.Node;
import com.deadspider.Page;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

@ToString
public class SimplePageManager {
    private final LinkedList<Page> pages = new LinkedList<>();


    public Page getPageFor(Integer i) {
        if(pages.isEmpty() || pages.getLast().isFull()) {
            Page p = new Page();
            pages.add(p);
        }
        return pages.getLast();
    }

    public void add(Integer i) {
        getPageFor(i).add(new Node(i));
    }

    public void remove(Integer i) {
        Page p = getPageFor(i);
        if(p.getNode(i).isPresent()) {
            p.remove(p.getNode(i).get());
        }
    }

    public boolean has(Integer i) {
        Page p = getPageFor(i);
        return Objects.nonNull(p) && p.getNode(i).isPresent();
    }


}
