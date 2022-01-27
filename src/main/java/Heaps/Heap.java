package Heaps;

public class Heap {
    private int[] items = new int[10];
    private static final int divisor = 2;
    private int size;

//    public Heap(int size) {
//        this.size = size;
//    }


    public void insert(int value) {
        if(isFull()){
            throw new IllegalStateException();
        }
        items[size++] = value;
        //newItem > parent bubble up until it's in the right position
        bubbleUp();

    }

    private void swap(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;

    }

    private int parentIndex(int index) {
        return (index - 1) / divisor;
    }

    private int parent(int index) {
        return items[parentIndex(index)];
    }

    private int leftChildIndex(int index) {
        return (index * divisor) + 1;
    }
    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChildIndex(int index) {
        return (index * divisor) + 2;
    }
    private int rightChild(int i) {
        return items[rightChildIndex(i)];
    }

    public boolean isFull() {
        return size == items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void bubbleUp(){
        int index = size - 1;
        while(!(isEmpty()) && items[index]> items[parent(index)]){
            swap(index,parent(index));
            index = parent(index);
        }
}
    private void bubbleDown(){
        int index = size - 1;
        while(!(isEmpty()) && items[index]< items[parent(index)]){
            swap(index,parent(index));
            index = parent(index);
        }
    }
    private void printHeap() {
        System.out.print("nHeap = ");
        for (int i = 0; i < size; i++)
            System.out.print(items[i] +" ");
        System.out.println();
    }

    private void delete(int i) {
    }

    public static void main(String[] args){
        Heap maxHeap = new Heap();
        maxHeap.insert(10);
        maxHeap.insert(4);


        maxHeap.printHeap();
//        maxHeap.delete(5);
        //maxHeap.printHeap();

    }




}
