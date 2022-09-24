package arrays;

import java.util.Arrays;

public class MeetingRooms {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int usedRooms = 0;

        int [] start = new int [intervals.length];
        int [] end = new int [intervals.length];

        for(int i = 0;i< intervals.length-1;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);


        int startptr=0;
        int endptr=0;

        while(startptr<intervals.length){
            if(start[startptr]<end[endptr]){
                usedRooms++;
                startptr++;
            }else {
                usedRooms--;
                endptr++;
            }

        }
        return usedRooms;

    }
    public static void main(String[] args) {
       int[][] intervals = {{0,30},{5,10},{15,20}};
//        int[][] intervals = {{7,10},{2,4}};
        System.out.println(minMeetingRooms(intervals));
    }
}
