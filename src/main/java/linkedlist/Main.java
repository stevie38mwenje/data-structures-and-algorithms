package linkedlist;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(14);
        list.addLast(15);
        list.addLast(10);
        list.addLast(190);
        list.addLast(109);
        list.addLast(160);



        list.reverse();
//        list.reverseList();

        var array = list.toArray();
        var mylist = Arrays.toString(array);

        System.out.println(mylist);


        //System.out.println(list);
//        System.out.println(mylist);

//        LRUCache lruCache = new LRUCache(2);

    }
}
