package com.mohit.lld.lrucache;

public class DoubleyLL <K,V>{
    Node<K,V> head, tail;

    public  DoubleyLL(){
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
        head.next = tail;
        tail.prev = head;

    }

    public void  addToFirst(Node<K,V> node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void moveToFront(Node<K,V> node){
        remove(node);
        addToFirst(node);
    }

    public void remove(Node<K,V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node<K,V> removeLast(){
        if(tail.prev == head){
            return null;
        }
        remove(tail.prev);
        return tail.prev;
    }


}
