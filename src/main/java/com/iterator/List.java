package com.iterator;

public interface List<E> {
    int size();

    void put(E o);

    Iterator<E> iterator();
}
