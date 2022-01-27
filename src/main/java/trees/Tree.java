package trees;

public class Tree {


    private static class Node{
        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }

        private int value;
        private Node leftChild;
        private Node rightChild;


        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    private void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        var current = root;
        var node = new Node(value);
        while (true) {
            if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;

            } else {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
        }
    }

    private boolean findNode(int value){
        var current = root;
        while(current !=null){
            if(value<current.value){
                current=current.leftChild;
            }
            else if(value>current.value){
                current = current.rightChild;
            }
            else
                return true;

        }
        return false;
    }
    private void traversePreOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root){
        if(root==null){
            return;
        }
        traverseInOrder(root.leftChild);
        System.out.println(root);
        traversePreOrder(root.rightChild);

    }

    private void traversePostOrder(Node root){
        if(root==null){
            return;
        }
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root);

    }

}
