package sorting;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] array, int low, int high) {
        if(low>=high){
            return;
        }
        int pi = partition(array, low, high);
        sort(array, low, pi - 1);
        sort(array, pi + 1, high);

    }

    static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }

        }
        swap(array, i + 1, high);
        return (i + 1);
    }
        static void swap ( int[] array, int index1, int index2){
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }


        static class Demo {
            public static void main(String[] args) {
                QuickSort sorter = new QuickSort();
                int[] numbers = {10, 8, 5, 2, 1, 7};
                sorter.sort(numbers, 0, numbers.length - 1);
                System.out.println(Arrays.toString(numbers));

            }
        }

    }


