package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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


    public void bfs(){
        bfs(root);
    }
    private void bfs(Node root){
        if(root==null){
            return;
        }
        Queue <Node> treequeue = new LinkedList<>();
        treequeue.add(root);
        while(treequeue.isEmpty()==false){
            Node currentNode = treequeue.remove();
            System.out.println(currentNode.value);
            if(currentNode.leftChild !=null){
                treequeue.add(currentNode.leftChild);
            }
            if(currentNode.rightChild !=null){
                treequeue.add(currentNode.rightChild);
            }
        }
    }

    public ArrayList<Integer> getNodesAtDistance(int distance){
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance,list);
        return list;
    }
    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        if(distance==0){
            list.add(root.value);
//            System.out.println(root.value);
            return;
        }
        getNodesAtDistance(root.leftChild, distance - 1,list);
        getNodesAtDistance(root.rightChild, distance - 1,list);

    }

    public void traverseLevelOrder(){
        for(var i = 0;i<=height();i++){
           var list = getNodesAtDistance(i);
           for(var item:list){
               System.out.println(item);
           }

        }
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.leftChild)+1,height(root.rightChild)+1);
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

//    public boolean isValidBST(Node root){
//        if(root==null){
//            return true;
//        }
//        return validateNode(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
//
//    }
//
//    private boolean validateNode(Node root, int minValue, int maxValue) {
//        if(root.value<=minValue||root.value>=maxValue){
//            return false;
//        }
//        if(root.leftChild!=null){
//            if(!validateNode(root.leftChild, minValue, root.value-1)){
//                return false;
//            }
//        }
//        if(root.rightChild!=null){
//            if(!validateNode(root.rightChild, maxValue, root.value-1)){
//                return false;
//            }
//        }
//
//        return true;
//    }


    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }


    private boolean isBinarySearchTree(Node root, int min, int max){
        if(root==null){
            return true;
        }
        if(root.value<=min||root.value>=max){
            return false;
        }
        return isBinarySearchTree(root.leftChild, min, root.value - 1) && isBinarySearchTree(root.rightChild, min, root.value + 1);
    }

    public int min() {
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
