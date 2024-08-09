package com.deadspider;


import com.deadspider.exceptions.PageFullException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Page {

    private static final Integer MAX_PAGE_SIZE = 20; //NODES

    private final List<Node> nodes = new ArrayList<Node>();

    public void add(Node n) throws PageFullException {
        if(Objects.equals(nodes.size(), MAX_PAGE_SIZE)) {
            throw new PageFullException();
        }
        nodes.add(n);
    }

    public void remove(Node n) {
        nodes.remove(n);
    }

    public Optional<Node> getNode(int i) {
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
