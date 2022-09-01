package arrays;

import java.util.Arrays;

public class MinHeap {
    private int size;
    private int capacity=10;
    private int [] items= new int[capacity];

    @Override
    public String toString() {
        return  Arrays.toString(items);
    }


//            0
//        1        2
//    3      4   5     6

    private int leftChildIndex(int parentIndex){
        return 2*parentIndex+1;
    }
    private int rightChildIndex(int parentIndex){
        return 2*parentIndex+2;
    }
    private int parentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    private int leftChildValue(int index){
        return items[leftChildIndex(index)];
    }
    private int rightChildValue(int index){
        return items[rightChildIndex(index)];
    }
    private int parentValue(int index){
        return items[parentIndex(index)];
    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index)<=size;
    }
    private boolean hasRightChild(int index){
        return rightChildIndex(index)<=size;
    }
    private boolean hasParent(int index){
        return parentIndex(index)>=0;
    }

    void swap(int index1,int index2){
        var temp = index1;
        index1 = index2;
        index2 = temp;
    }

    private void ensureExtraCapacity(){
        if(size==capacity){
            items = Arrays.copyOf(items,capacity*2);
            capacity *=2;
        }
    }

    private int peek(){
        if(size==0)throw new IllegalStateException();
        return items[0];
    }
    private int poll(){
        if(size==0)throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    private int insert(int item){
        if(size==0)items[0]=item;
        ensureExtraCapacity();
        items[size++]=item;
        heapifyUp();
        return item;
    }

    private void heapifyUp() {
        int index = size-1;
        while(hasParent(index)&&parentValue(index)>items[index]){
            swap(parentIndex(index),index);
            index=parentIndex(index);
        }
    }

    private int Kthsmallest(int []arr,int k){
        var heap = new MinHeap();
        for(int number:arr)
            heap.insert(number);
        System.out.println(heap);

        for(int i=0;i<k-1;i++)
            heap.poll();
            return heap.peek();


    }


    private void heapifyDown() {
        int index = 0;

//        var smallerChild=Math.min(leftChildIndex(index),rightChildIndex(index));

        while(hasLeftChild(index)){
            var smallerChildIndex=leftChildIndex(index);
            if(hasRightChild(index)&&rightChildValue(index)<leftChildValue(index)){
                smallerChildIndex = rightChildValue(index);
                if(items[index]<items[smallerChildIndex]){
                    break;
                }
                else {
                    swap(smallerChildIndex, index);
                }
                index = smallerChildIndex;
            }
    }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        System.out.println();
    }


}
