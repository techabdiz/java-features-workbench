package com.deadspider;


import lombok.ToString;

import java.util.Objects;

@ToString
public class Node<T> {

    private final T value;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

   /* @Override // THIS WILL DELETE DUPLICATE NODES... DO NOT IMPLEMENT
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;

        return Objects.equals(value, node.value);
    }*/

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
