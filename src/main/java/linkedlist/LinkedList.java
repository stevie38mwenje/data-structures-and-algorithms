package linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value= value;
            next = null;
        }
    }

    private Node first;
    private Node last;

    public void addLast(int item){
        var node = new Node(item);
        if(isEmpty()){
            first = node;
            last = node;
        }else
            last.next = node;
            last  = node;
    }

    public void addFirst(int item){
        var node = new Node(item);
        if(isEmpty()){
            first = node;
            last=node;
        }
        else
            node.next = first;
            first = node;
    }

    private void removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        if(first == last){
            first =last= null;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
    }

    private void removeLast(){
        var previous = getPreviousNode(last);
        last = previous;
        last.next = null;

    }

    public LinkedList reverseList(LinkedList list){
        var current = list.first;
        //var previous = getPreviousNode(list.first);
        var previous = first;

        while(current!=null){
            var next = current.next;
            current.next=previous;
            previous = current;
            current = next;
        }
        return list;
    }

    public void reverse(){
        var previous = first;
        var current = first.next;

        last = first;
        last.next = null;
        while(current!=null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        first = previous;
    }


    private boolean removeMiddle(Node node){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        if(first == last){
            first =last= null;
            return false;
        }
        var next = node.next;
        node.value=next.value;
        node.next=next.next;
        return true;


    }

    private Node getPreviousNode(Node node){
        var current = first;
        while(current!=null){
            if(current.next==node){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty(){
        return first==null;
    }

}
