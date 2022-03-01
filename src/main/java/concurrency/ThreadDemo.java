package concurrency;

public class ThreadDemo {


    public static void show() {

        System.out.println(Thread.currentThread().getName());

            Thread thread = new Thread(new DownloadFileTask());
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("File ready to be scanned");
    }
    public static void main(String[] args) {
        show();
    }

}
