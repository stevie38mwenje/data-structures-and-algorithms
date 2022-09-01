package arrays;

import java.util.*;

public class Graph {

    public static class Node {
        private String label;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public Map<String, Node> graphNodes = new HashMap<>();
    public Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        graphNodes.putIfAbsent(label, node);
        adjacencyList.put(node, new ArrayList<>());
    }

    public void removeNode(String label) {
        var node = graphNodes.get(label);
        if(node==null) return;
        for(var n:adjacencyList.keySet()){
            adjacencyList.get(n).remove(node);
            adjacencyList.remove(node);
            graphNodes.remove(node);
        }
    }
    public void addEdge(String to,String from) {
        var fromNode = graphNodes.get(from);
        var toNode = graphNodes.get(to);
        if(fromNode==null||toNode==null){
            throw new IllegalArgumentException();
        }
        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeEdge(String to,String from) {
        var fromNode = graphNodes.get(from);
        var toNode = graphNodes.get(to);
        if(fromNode==null||toNode==null){
            throw new IllegalArgumentException();
        }
        adjacencyList.get(fromNode).remove(toNode);
    }


    public void printGraph(){
        for(var source:adjacencyList.keySet()){
            var target = adjacencyList.get(source);
            System.out.println(source+ " is connected to " + target);
        }

    }

    public void dfs(String label){
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        var node = graphNodes.get(label);
        if(node==null)return;
        stack.push(node);
        while(!stack.isEmpty()) {
            var currentNode = stack.pop();
            var neighbours = adjacencyList.get(currentNode);

            if(!visited.contains(currentNode)){
                System.out.println(currentNode);
                visited.add(currentNode);
            }
            else {
                continue;
            }
            for (var neighbour : neighbours) {
                if (!visited.contains(neighbour))
                    stack.add(neighbour);
            }
        }
    }

    public void bfs(String label){
        Queue<Node> graphQueue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        var node = graphNodes.get(label);
        if(node==null)return;
        graphQueue.add(node);
        while(!graphQueue.isEmpty()){
            Node currentNode = graphQueue.remove();
            var neighbours = adjacencyList.get(currentNode);
            //add to visited if not visited
            if(!visited.contains(currentNode)){
                visited.add(currentNode);
            }
            else {
                continue;
            }
            for(var neighbour:neighbours){
                if(!visited.contains(neighbour))
                graphQueue.add(neighbour);
            }
        }
    }


    public List<String> topologicalSort(){
        Set <Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        List<String> sorted = new ArrayList<>();

        for(var node:graphNodes.values())
            topologicalSort(node,visited, stack);

        while (!stack.isEmpty())
            sorted.add(stack.pop().getLabel());
        return sorted;


    }

    private void topologicalSort(Node node, Set<Node>visited, Stack<Node>stack){
        if(visited.contains(node))return;
        visited.add(node);

        for(var neighbour:adjacencyList.get(node))
           topologicalSort(neighbour,visited,stack);
        stack.push(node);
    }




    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addEdge("a","b");
        graph.addEdge("b","c");
            graph.printGraph();
            System.out.println(graph);

}
}
