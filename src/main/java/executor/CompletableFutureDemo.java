package executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

public class CompletableFutureDemo {
    public static void show(){
        //ForkJoinPool.commonPool()
        //Runtime.getRuntime().availableProcessors();
        Supplier<String> task = ()-> ("hello");
        var future = CompletableFuture.supplyAsync(task);
        try {
            var result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        show();
    }
}
