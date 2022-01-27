package sorting;

import recursion.Factorial;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] array){
        for (int i = 0; i<array.length;i++){
            for(int j = 1;j<array.length;j++){
                if (array[j] < array[j-1]){
                swap(array,j,j-1);
            }
            }
        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    static class Demo {
        public static void main(String[] args) {
            BubbleSort sorter = new BubbleSort();
            int[] numbers = {5,2,1,7};
            sorter.sort(numbers);
            System.out.println(Arrays.toString(numbers));

        }
    }
}
