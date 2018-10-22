package bingxing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Abdusalam on 18/09/11.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();
        for (int i = 0; i <5 ; i++) {
            exec.execute(new ListOff());

        }
        exec.shutdown();
    }
}
