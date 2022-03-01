package trees;

public class Tree {

    public Tree(Node root) {
        this.root = root;
    }

    public Tree() {

    }



    private static class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;


        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private Node root;

    public void insert(int value) {
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

    public void traversePreorder() {
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }


    public void traverseInorder(){
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root){
        if(root==null){
            return;
        }
        traverseInOrder(root.leftChild);
        System.out.println(root);
        traverseInOrder(root.rightChild);

    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root){
        if(root==null){
            return;
        }
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root);

    }

    public int min() {
        return min(root);
    }

    private int min(Node root){
        if(isLeaf(root)){
            return root.value;
        }

            var right = min(root.rightChild);
            var left = min(root.leftChild);
            return Math.min(Math.min(right,left),root.value);

    }
    public int maxDepth(){
        return maxDepth(root);
    }

    private int maxDepth(Node root){
        if(root==null){
            return -1;
        }

        if(isLeaf(root)){
            return 0;
        }

//        var right = maxDepth(root.rightChild);
//        var left = maxDepth(root.leftChild);

        return 1 +Math.max(maxDepth(root.leftChild),maxDepth(root.rightChild));

    }

    public int minBst(){
        return minBst(root);
    }

    private int minBst(Node root){
        if(root==null){
            throw new IllegalStateException();
        }
       var current = root;
       var last = current;
       while(current!=null){
          last = current;
           current = current.leftChild;

       }
        return last.value;


    }

    private boolean isLeaf(Node root){
        return root.rightChild==null&&root.leftChild==null;
    }




}
