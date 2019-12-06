package com.oddsonlogic.coding.advent;


import java.util.LinkedList;
import java.util.List;

public class Orbit<T>{

    T data;
    Orbit<T> parent;
    List<Orbit<T>> children;

    public Orbit(T data) {
        this.data = data;
        this.children = new LinkedList<Orbit<T>>();
    }

    public Orbit<T> addChild(T child) {
        Orbit<T> childNode = new Orbit<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }



}
