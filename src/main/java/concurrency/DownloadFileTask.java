package concurrency;

public class DownloadFileTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Downloading file" + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Downloading complete" + Thread.currentThread().getName());

    }
}
