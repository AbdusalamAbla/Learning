package bingxing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Abdusalam on 18/10/19.
 */
public class BasicThread {


    public static void main(String[] args) throws InterruptedException {
//Thread t=new Thread(new ListOff());
//        t.start();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            service.execute(new ListOff());
        }
        service.shutdown();

    }
}
