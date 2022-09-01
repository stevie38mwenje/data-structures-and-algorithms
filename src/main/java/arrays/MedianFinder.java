package arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> maxHeap =new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num){
        if(maxHeap.isEmpty()||maxHeap.peek()>num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        //balance the two heaps
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.add(maxHeap.peek());
            maxHeap.poll();
        }
        else if(minHeap.size()>maxHeap.size()+1){
            maxHeap.add(minHeap.peek());
            minHeap.poll();
        }
    }


    public double findMedian(){
        //even
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        //odd
        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        else
            return minHeap.peek();

    }
}
