package com.Chynchenko.container;

import com.Chynchenko.model.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Node<T> extends Car {
    T data;
    Node<T> left, right;

    Node(T data) {
        this.data = data;
    }

    @Override
    public int restore() {
        return 0;
    }
}
