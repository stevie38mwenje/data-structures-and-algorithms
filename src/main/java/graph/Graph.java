package graph;

import java.util.*;

public class Graph {
    public static class Node{
        private String label;

        public Node(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return label;
        }
    }


    //private List<Node> nodes = new ArrayList<>();
    private Map<String,Node> nodes = new HashMap<>();
    private final Map<Node,List<Node>> adjacencyList= new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node,new ArrayList<>());
        //System.out.println(nodes);
    }


    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if(fromNode==null||toNode==null){
            throw new IllegalArgumentException();
        }
        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeEdge(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if(fromNode==null || toNode==null ){
            throw new IllegalArgumentException();
        }
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void print(){
        for(var source:adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty()){
                System.out.println( source + " is connected to "+ targets);
            }
        }
    }

    public void removeNode(String label){
        var node = nodes.get(label);
        if(node==null) return;

        for(var n:adjacencyList.keySet()){
            adjacencyList.get(n).remove(node);
            adjacencyList.remove(node);
            nodes.remove(node);
        }
    }

//    public void graphbfs(){
//        graphbfs();
//    }


    public void graphbfs(String root){
        var node = nodes.get(root);
        if(node==null)return;
        Set <Node> visited = new HashSet<>();
        Queue <Node> graphqueue = new LinkedList<>();
        graphqueue.add(node);
        while(!graphqueue.isEmpty()){
            var currentNode = graphqueue.remove();
            if(visited.contains(currentNode))
                continue;
            System.out.println(currentNode);
            visited.add(currentNode);

            for(var neighbour:adjacencyList.get(currentNode))
                if(!visited.contains(neighbour))
                    graphqueue.add(neighbour);
        }
    }


    public void graphdfs(String root){
        var node = nodes.get(root);
        if(node==null)return;
        graphdfs(node,new HashSet<>());
    }
    private void graphdfs(Node root,Set<Node> visited){
        System.out.println(root);
        visited.add(root);

        for(var neighbour:adjacencyList.get(root))
            if(!visited.contains(neighbour))
                graphdfs(neighbour,visited);

    }

    public void graphdfsIteravive(String root){
            var node = nodes.get(root);
            if(node==null)return;
            Set<Node> visited = new HashSet<>();
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            while(!stack.isEmpty()){
                var currentNode = stack.pop();
                if(!visited.contains(currentNode))
                    visited.add(currentNode);
                    System.out.println(currentNode);

                for(var neighbour:adjacencyList.get(currentNode)){
                    if(!visited.contains(neighbour))
                        stack.push(neighbour);
                }
            }
        }




    }

//    public void dfs(Node root, Set<Node> unvisited){
//
//    }

