package trees;

public class Main {
    public static void main(String[] args) {
        var tree = new Tree();
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(20);
        var list = tree.getNodesAtDistance(1);
        for(var item:list){
            System.out.println(item);
        }

        System.out.println(tree.isBinarySearchTree());

        System.out.println("===minimum===");
        System.out.println(tree.minBst());

        System.out.println("===LEVELORDER===");
        tree.traverseLevelOrder();

        System.out.println("===POSTORDER===");
        tree.traversePostOrder();
        System.out.println("===INORDER===");
        tree.traverseInorder();
        System.out.println("===PREORDER===");
        tree.traversePreorder();

        System.out.println("===BFS===");
        tree.bfs();

        System.out.println("===MINIMUM VALUE===");
        System.out.println(tree.minBst());

        System.out.println("===DEPTH===");
        System.out.println(tree.maxDepth());
//        System.out.println("Height of tree is : " +
//                mytree.maxDepth());
//        System.out.println(Thread.activeCount());
//        System.out.println(Runtime.getRuntime().availableProcessors());

    }


}


