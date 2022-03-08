package concurrency;

public class DownloadFileTask implements Runnable{


    private DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        //System.out.println("Downloading file" + Thread.currentThread().getName());

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for(var i=0;i<10_000;i++){
            if(Thread.currentThread().isInterrupted())return;
//            System.out.println("Downloading byte " + i);
            status.incrementTotalBytes();
        }

        System.out.println("Downloading complete: " + Thread.currentThread().getName());

    }
}
