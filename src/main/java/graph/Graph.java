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
    private Map<Node,List<Node>> adjacencyList= new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node,new ArrayList<>());
        //System.out.println(nodes);
    }


    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        if(fromNode==null){
            throw new IllegalArgumentException();
        }
        var toNode = nodes.get(to);
        if(toNode==null){
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
        if(node==null){
            return;
        }

        for(var n:adjacencyList.keySet()){
            adjacencyList.get(n).remove(node);

            adjacencyList.remove(node);
            nodes.remove(node);
        }
    }

    public void bfs(Node root, Set<Node> unvisited){

    }

    public void dfs(Node root, Set<Node> unvisited){

    }
}
