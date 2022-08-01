package sorting;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int [] arr){
        // divide an array into sub arrays
        //[3,9,2,5,1,7]

        if(arr.length<2)return;

        int mid = arr.length/2;

        int [] left = new int[mid];
        int [] right = new int[arr.length-mid];

        for(int i=0;i<mid;i++){
            left[i]=arr[i];
        }

        for(int i=mid;i<arr.length;i++){
            right[i-mid]=arr[i];
        }
        //sort the two subarrays
        mergeSort(left);
        mergeSort(right);
        //merge the results
        merge(left,right,arr);
    }
    public void merge(int []left,int [] right,int [] result){
        int i=0;int j=0;int k=0;
        while(i<left.length&&j<right.length) {
            if (left[i] < right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

            while(i<left.length){
                result[k++] = left[i++];
        }
        while(j<right.length){
            result[k++] = right[j++];
        }


    }


    static class Demo {
        public static void main(String[] args) {
            MergeSort sorter = new MergeSort();
            int[] numbers = {10, 8, 5, 2, 1, 7};
            sorter.mergeSort(numbers);
            System.out.println(Arrays.toString(numbers));

        }
    }
}
