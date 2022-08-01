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

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }


    }

    public int size(){
        return size;
    }
    public int[] toArray() {
        int [] array = new int[size];
        var current = first;
        var index = 0;
        while(current!=null){
            array[index]=current.value;
            index++;
            current = current.next;
        }
        return array;
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item){
        var node = new Node(item);
        if(isEmpty()){
            first = last = node;
        }else{
            last.next = node;
            last  = node;}
        size++;

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

        size--;

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

    public void reverse1(){
        Node slowptr = null;
        var firstptr = first;
        var temp = first.next;

        while(firstptr!=null){
            firstptr.next = slowptr;
            slowptr = firstptr;
            firstptr = temp;
        }
        first=slowptr;
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


//    private Node getMiddleNode(Node node){
//
//    }

    private boolean isEmpty(){
        return first==null;
    }

}
