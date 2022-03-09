package executor;

public class LongTask {
    public static void simulate(){
        Thread task = new Thread();
        task.start();
        try {
            task.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
