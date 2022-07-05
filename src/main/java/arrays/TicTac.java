//package arrays;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//
//public class TicTac {
//    static int[] findDuplicates(int[] arr1, int[] arr2) {
//        // your code goes here
//        int m = arr1.length;
//        int n = arr2.length;
//        int index = 0;
//        int [] ans = new int[Math.min(m,n)];
//        int p1 = 0;
//        int p2 = 0;
//        while(p1<=m-1 && p2<=n-1){
//            if(arr1[p1]==arr2[p2]){
//                ans[index]=(arr1[p1]);
//                index++;
//                p1++;
//                p2++;
//            }else if(arr1[p1] < arr2[p2]){
//                p1++;
//            }else{
//                p2++;
//            }
//        }
//        int[] res = new int[index];
//        for(int i = 0; i < index; i++) {
//            res[i]=ans[i];
//
//
//        }
//        return res;
//
//
//
//
//
//
//    }
//
//        int coins [] = {5,50,60,4,1};
//        int coins2 [] = {1,2,5};
//
////       var  res = findDuplicates(coins,coins2);
////        System.out.println(Arrays.toString(res));
//    }
//}
//
