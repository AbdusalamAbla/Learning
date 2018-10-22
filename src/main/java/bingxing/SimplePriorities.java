package bingxing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Abdusalam on 18/10/19.
 */
public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return Thread.currentThread() + ":" + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 1000000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }

            }
            System.out.println(this);

        }

    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        service.execute(new SimplePriorities(Thread.MIN_PRIORITY));


        service.shutdown();
    }
}
