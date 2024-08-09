package com.deadspider;


import com.deadspider.exceptions.PageFullException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Page<T> {

    private static final Integer MAX_PAGE_SIZE = 20; //NODES

    private final List<Node<T>> nodes = new ArrayList<Node<T>>();

    public void add(Node<T> n) throws PageFullException {
        if(Objects.equals(nodes.size(), MAX_PAGE_SIZE)) {
            throw new PageFullException();
        }
        nodes.add(n);
    }

    public void remove(Node<T> n) {
        nodes.remove(n);
    }

    public Optional<Node<T>> getNode(T i) {
        return nodes.stream().filter(s->s.getValue().equals(i)).findFirst();
    }

    public boolean isFull() {
        return Objects.equals(nodes.size(), MAX_PAGE_SIZE);
    }

    @Override
    public String toString() {
        return "Page{" +
                "nodes=" + nodes +
                '}';
    }
}
