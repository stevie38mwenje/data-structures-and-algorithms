package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {

        //[[1, 4], [4, 5]]
        if(intervals.length<2)return intervals;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for(int [] interval:intervals){
            if(merged.isEmpty()||merged.getLast()[1]<interval[0]){
                merged.add(interval);
            }
            else{
                merged.getLast()[1] = Math.max(merged.getLast()[1],interval[1]);
            }
        }
        var res = merged.toArray(new int[merged.size()][]);
        System.out.println(Arrays.deepToString(res));
        return res;
    }


    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));
    }

}
