package executor;

import java.util.concurrent.CompletableFuture;

public class MailService {
    public void send(){
        LongTask.simulate();
        System.out.println("Mail was sent.");
    }
    public void sendAsync(){
        CompletableFuture.runAsync(this::send);
    }
}
