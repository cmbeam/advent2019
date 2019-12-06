package com.oddsonlogic.coding.advent;


import java.util.ArrayList;
import java.util.List;

public class OrbitTree<T> {
    private Orbit<T> root;

    public  OrbitTree(T rootData) {
        root = new Orbit<T>();
        root.data = rootData;
        root.children = new ArrayList<Orbit<T>>();
    }

    public  class Orbit<T> {
        private T data;
        private Orbit<T> parent;
        private List<Orbit<T>> children;
    }
}
