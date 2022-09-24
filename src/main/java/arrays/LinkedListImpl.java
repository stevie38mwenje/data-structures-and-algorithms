package arrays;

import java.util.NoSuchElementException;

public class LinkedListImpl {
    private static class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
            this.next=null;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    private int size(){
        return size;
    }

    private void addFirst(int value){
        var node = new Node(value);
        if (head == null) {
            head=tail=node;
        }
        node.next = head;
        head=node;

    }

    private void addLast(int value){

    }

    private void addAtPosition(int index, int value){

    }

    private void removeFirst(){
        if(isEmpty())throw new NoSuchElementException();

        if(head==tail) {
            head = tail = null;
            return;
        }
        var second = head.next;
        head.next=null;
        second = head;
        size--;
    }

    private void removeLast(){
        var prev= getPreviousNode(tail);
        tail = prev;
        tail.next = null;
        size--;
    }

    private void removeAtPosition(int index){

    }
    private boolean isEmpty(){
        return head==null;
    }

    private Node getPreviousNode(Node node){
        var current = head;

        while(current!=null){
            if(current.next == node) {
                return current;
            }
            current=current.next;
        }
        return null;
    }

}
