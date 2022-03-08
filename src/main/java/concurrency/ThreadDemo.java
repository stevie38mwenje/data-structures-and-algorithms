package concurrency;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {


    public static void show() {
//
//        System.out.println(Thread.currentThread().getName());
//
//            Thread thread = new Thread(new DownloadFileTask());
//            thread.start();
//
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        System.out.println("File ready to be scanned");

        List<Thread> threads = new ArrayList<>();
        var status = new DownloadStatus();
        for(var i = 0;i<10;i++){
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for(var thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }
    public static void main(String[] args) {
        show();
    }


}
