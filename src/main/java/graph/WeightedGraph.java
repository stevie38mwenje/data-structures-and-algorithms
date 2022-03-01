package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {
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

    public static class Edge{
        private Node to;
        private Node from;
        private int weight;

        public Edge(Node to, Node from, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Edge>> adjacencyList= new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node,new ArrayList<>());
        //System.out.println(nodes);
    }


    public void addEdge(String from, String to,int weight){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if(fromNode==null || toNode==null){
            throw new IllegalArgumentException();
        }
        adjacencyList.get(fromNode).add(new Edge(fromNode,toNode,weight));
        adjacencyList.get(toNode).add(new Edge(toNode,fromNode,weight));
    }

}
