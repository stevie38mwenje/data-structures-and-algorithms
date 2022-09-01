package arrays;

import java.util.*;

public class Microsoft {

    public static class Order{
        public static String name;
        public static String category;
        public static Integer price;

        public Order(String name, String category, Integer price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

//        @Override
//        public String toString() {
//            return name+category+price;
//        }
    }

    public List<Order> getMaxSum(List<Order> orders){
        Map<String, Integer> map =  new HashMap<>();
        for(Order order:orders){
            var currenCategory = order.category;
            var currenprice = order.price;

            if(!map.containsKey(currenCategory)){
                map.put(currenCategory,currenprice);
            }else{
                var categoryPriceSum = map.get(currenCategory)+ currenprice;
                map.put(currenCategory,categoryPriceSum);
            }

            List<Order> res = new ArrayList<>();
            var max= Collections.max(map.values());
            for(String key: map.keySet()) {
                if(map.get(key).equals(max)) {
                    System.out.println(key);
//                    res.add(new Order(key,max));
                }
            }


            for (Map.Entry entry : map.entrySet())
            {
                System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
            }
            return res;

        }
        return null;
    }


    public static void main(String[] args) {
        Order order = new Order("rice","household",300);
        Order order1 = new Order("beans","household",300);
        Order order2 = new Order("pen","household",300);
        Order order3 = new Order("tv","household",300);

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        for(int i=0;i<=orders.size();i++){
        System.out.println(orders);
    }
    }
//    orders =[
//            {"name":"rice","category":"household","price":300},
//            {"name":"rice","category":"furniture","price":300},
//            {"name":"rice","category":"household","price":300}
//    ]

}
