package queues;


import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;


class WorkingWithQueue {

   public static void main(String[] args) {
       queues();
       List<Person> linkedlist =  new LinkedList<>();
       linkedlist.add(new Person("MWENJE",4));
       linkedlist.add(new Person("MWENJE STEVE",34));

       ListIterator<Person> listIterator = linkedlist.listIterator();
       while (listIterator.hasNext()){
           System.out.println(listIterator.next());

       }






   }

    private static void queues() {
        Queue<Person> supermarket = new LinkedList<>();
        supermarket.add(new Person("Steve",4));
        supermarket.add(new Person("Steve",5));
        supermarket.add(new Person("Steve",6));


        ListIterator<Person> personListIterator = (ListIterator<Person>) supermarket.iterator();
        while (personListIterator.hasNext()){
            System.out.println(personListIterator.next());
        }
        System.out.println("===============");

    }

    static record Person (String name, int age) {}
}
