package arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargest {
    public static int kthLargest(int [] nums, int k){
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>( Collections.reverseOrder());
        for(int num:nums){
            pq.add(num);

           System.out.println(pq);
//         if(k>pq.size())throw new IllegalArgumentException("illegal");
//            if(pq.size()>k) {
//                pq.poll();
//            }
            for(int i =1;i<=k;i++){
                pq.poll();
            }

        }

//        System.out.println(pq.peek());
        return pq.peek();
    }

//using quick select.
    private static int kLargest(int[] nums, int k) {
            int targetIndex =  nums.length-k;
            int low = 0, high = nums.length - 1;
            while(true) {
                int partitionindex = partition(nums, low, high);
                if (low == high) {
                    System.out.println(nums[low]);
                    return nums[low];
                }

                if (partitionindex == targetIndex) {
                    var res = nums[partitionindex];
                    System.out.println(res);
                    return res;
                } else if (partitionindex > targetIndex) {
                    high = partitionindex;
                } else
                    low = partitionindex + 1;

            }
    }

    private static int partition(int [] arr, int low,int high){
        int i = low - 1;
        int pivot = arr[high];
        for(int j=low;j<=high-1;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }



    public static void swap(int [] array,int index1,int index2){
        int temp = array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }


    public static void main(String[] args) {
        //int nums [] = {5};
        int nums [] = {5,50,60,4,1};
        int low = 0;
        int high = nums.length-1;
//        System.out.println(partition(nums,low,high));
        int k = 4;
        kLargest(nums,k);

    }
}
