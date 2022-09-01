package arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MostFrequent {
    public static int mostFrequent(int [] nums){
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int num:nums){
            if(!frequencyMap.containsKey(num)){
                frequencyMap.put(num,1);
            }
            else {
                frequencyMap.put(num,frequencyMap.get(num)+1);
            }
        }
        var max = Collections.max(frequencyMap.values());

//
//        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        for (Map.Entry<String, Integer> entry : productList.entrySet()) {
//            list.add(entry.getValue());
//        }
//        Collections.sort(list);
//        for (int num : list) {
//            for (Entry<String, Integer> entry : map.entrySet()) {
//                if (entry.getValue().equals(num)) {
//                    sortedMap.put(entry.getKey(), num);
//                }
//            }
//        }


        for(int key:frequencyMap.keySet()){
            if(frequencyMap.get(key).equals(max)){
//                System.out.println("===");
//                System.out.println(key);
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums [] = {5,50,60,4,1,1,5,5};

        System.out.println(mostFrequent(nums));

    }
}
