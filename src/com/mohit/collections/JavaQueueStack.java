package com.mohit.collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JavaQueueStack {
    public static void main(String[] args) {
        // LinkedList, PriorityQueue

        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");

        // poll : remove first ele and return null if empty queue
        // remove : remove first ele and throw exception if emepty quue
        System.out.println(queue.poll());
        System.out.println(queue.size());


        // peek() : to only check first element
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());

        System.out.println("...deque...");

        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addLast("c");

        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.size());
        //peek just show the element, it doesn't remove like poll
        System.out.println(deque.peekFirst());

        System.out.println("..stack...");

        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }
}
