package trees;

public class Main {
    public static void main(String[] args) {
        Tree mytree = new Tree();
        mytree.insert(2);
        mytree.insert(1);
        mytree.insert(5);
        mytree.insert(6);
        mytree.insert(7);
        mytree.insert(20);
        mytree.traversePostOrder();


        //System.out.println(mytree.toString());
//        System.out.println("Height of tree is : " +
//                tree.maxDepth(tree);
//        System.out.println(Thread.activeCount());
//        System.out.println(Runtime.getRuntime().availableProcessors());

    }


}
