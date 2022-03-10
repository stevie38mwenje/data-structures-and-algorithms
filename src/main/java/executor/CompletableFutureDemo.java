package executor;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CompletableFutureDemo {
    public static void show(){
        //ForkJoinPool.commonPool()
        //Runtime.getRuntime().availableProcessors();
//
//        Supplier<String> task = ()-> ("hello");
//        var future = CompletableFuture.supplyAsync(task);
//        try {
//            var result = future.get();
//            System.out.println(result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


        var service = new FlightService();
        //service.getQuote("site1").thenAccept(System.out::println);
        var start = LocalTime.now();
        var futures = service.getQuotes()
                .map(future-> future.thenAccept(System.out::println))
                .collect(Collectors.toList());
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).thenRun(()->{
            var end = LocalTime.now();
            var duration = Duration.between(start,end);
            System.out.println("Completed task in " + duration.toMillis() + " seconds");

        });

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        show();
    }
}
