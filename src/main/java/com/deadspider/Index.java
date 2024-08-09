package com.deadspider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Index {

    /* private final LinkedList<Integer> index = new LinkedList<>();

    public int getNodeIndex(Node node) {
        if(index.isEmpty()) {
            index.add(node.getValue());
            return 0;
        }
        int i = 0;
        boolean set = false;
        Iterator<Integer> indexIterator =  index.iterator();
        while(indexIterator.hasNext()) {
            int ind = indexIterator.next();
            if(node.getValue() < ind) {
                set = true;
                i = i++;
            }
        }

        if(!set) {
            index.add(node.getValue());
            i = index.size()-1;
        }
        return i;
    }

    @Override
    public String toString() {
        return "Index{" +
                "index=" + index +
                '}';
    }*/
}
