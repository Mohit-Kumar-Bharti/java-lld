package com.mohit.lld.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUServ<K,V> {
    private static LRUServ instance;
    DoubleyLL<K,V> doubleyLL = new DoubleyLL<>();
    Map<K,Node<K,V>> map;
    int capacity;
    LRUServ(int capacity) {
        this.capacity = capacity;
        map = new HashMap<K,Node<K,V>>();
    }

    public synchronized static LRUServ getInstance() {
        if (instance == null) {
            instance = new LRUServ<>(10);
        }
        return instance;
    }

    public synchronized void put(K key, V value) {
        if(map.containsKey(key)){
            Node<K,V> node = map.get(key);
            node.value = value;
            doubleyLL.moveToFront(node);
            return;
        }
        if(map.size() >= capacity){
            Node<K,V> last = doubleyLL.removeLast();
            if ( last != null ){
                map.remove(last.key);
            }
        }
        Node<K,V> node = new Node<>(key, value);
        doubleyLL.addToFirst(node);
        map.put(key, node);

    }

    public synchronized V get(K key) {
        if(map.containsKey(key)){
            doubleyLL.moveToFront(map.get(key));
            return map.get(key).value;
        }
        return null;
    }
}
