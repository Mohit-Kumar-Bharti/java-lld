package com.mohit.lld.lrucache;

public class Node <K,V>{
     K key;
     V value;
     Node<K,V> next;
     Node<K,V> prev;
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
