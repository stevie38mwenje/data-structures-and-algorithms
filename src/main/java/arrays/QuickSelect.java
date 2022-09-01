package arrays;

import java.util.Random;

public class QuickSelect {

    public static int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        int rank = nums.length - k;

        while (true) {
            int idx = partition(nums, start, end);
            if (idx == rank) {
                System.out.println(nums[idx]);
                return nums[idx];
            } else if (idx > rank) {
                end = idx - 1;
            } else {
                start = idx + 1;
            }
        }
    }

    public static int partition(int[] nums, int start, int end) {
        int left = start, right = end;

        Random random = new Random();
        int rand = start + random.nextInt(end - start + 1);
        swap(nums, rand, end);

        while (left < right) {
            int pivot = nums[end];
            while (nums[left] < pivot && left < right) {
                left++;
            }

            while (nums[right] >= pivot && left < right) {
                right--;
            }

            if (left < right) {
                swap(nums, left, right);
            }
        }

        swap(nums, left, end);

        return left;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        //int nums [] = {5};
        int nums [] = {5,50,60,4,1};

//        System.out.println(partition(nums,low,high));
        int k = 1;
        findKthLargest(nums,k);

    }


}
