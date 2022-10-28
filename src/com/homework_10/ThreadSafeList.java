package com.homework_10;

import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeList<T> {
    private final CopyOnWriteArrayList<T> threadSafeList;

    public ThreadSafeList() {
        this.threadSafeList = new CopyOnWriteArrayList<>();
    }

    public void add(T element) {
        threadSafeList.add(element);
    }

    public void remove(T element) {
        threadSafeList.remove(element);
    }

    public T get(int index) {
        return threadSafeList.get(index);
    }
}
