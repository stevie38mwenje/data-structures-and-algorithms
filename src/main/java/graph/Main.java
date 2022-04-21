package graph;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");

        graph.addEdge("a","b");
        graph.addEdge("a","c");
        graph.addEdge("c","d");
        graph.addEdge("c","b");
        graph.addEdge("b","c");

       graph.print();

       //graph.graphbfs("d");
        System.out.println("======DFS======");
        graph.graphdfs("c");

        System.out.println("======DFS ITERATIVE======");
        graph.graphdfsIteravive("c");


        //System.out.println(graph.toString());
    }
}
