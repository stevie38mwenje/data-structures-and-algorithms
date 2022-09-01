package arrays;

import java.util.*;

public class TopologicalSort {
    static class Node{
        public String label;

        public Node(String label){
            this.label=label;
        }

    }
    public Map<String,Node> graphNodes = new HashMap<>();
    public Map<Node, List<Node>> adjacencyList = new HashMap<>();
//    var neighbours = graphNodes


    public List<String> topologicalSort(){
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        List<String> sorted = new ArrayList<>();

        for(var node:graphNodes.values()){
            topologialSort(node,visited,stack);
        }
        while(!stack.isEmpty()){
            sorted.add(stack.pop().label);
        }
        return sorted;
    }

    private void topologialSort(Node node, Set<Node>visited, Stack<Node>stack){
        if(visited.contains(node))return;
        visited.add(node);

        for(var neighbour:adjacencyList.get(node)){
            topologialSort(neighbour,visited,stack);
            stack.push(node);
        }
    }


    //Khans Algo(Course schedule)

    public boolean canFinish(int numCourses, int [][] prerequisites){
        int [] indegree  = new int [numCourses];
        Map<Integer,List<Integer>>adjacencyList = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        var count = 0;
        //create a graph
        for(int i = 0; i< numCourses; i++){
            adjacencyList.put(i,new ArrayList<>());
        }
        for(int[] p :prerequisites){
            int u = p[0];
            int v = p[1];
            adjacencyList.get(v).add(u);
            indegree[u]++;

        }
        //get all nodes where indegree is zero

        //add to queue
        for(var i = 0; i< numCourses; i++){
            if(indegree[i]==0) {
                queue.add(i);
            }
        }
        //process from queue(count++,check adjacency list,reduce indegree value by one
        while (queue.size()>0){
            int current = queue.poll();
            var neighbours = adjacencyList.get(current);
            for(var neighbour:neighbours){
                if(--indegree[neighbour]==0){
                    queue.add(neighbour);
                }
                count++;
            }
            return count== numCourses;
        }
       return false;
    }





}
