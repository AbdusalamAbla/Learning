package bingxing;

/**
 * Created by Abdusalam on 18/10/20.
 */
class SyncRunnable implements Runnable {
    private static int count;

    public SyncRunnable() {
        count = 0;
    }

    public  void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread() + ":" + (count++));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }
}
public class EvenGenerator extends IntGenerator {
    private  int currentEvenValue=0;
    @Override
    public synchronized int next()  {
        ++currentEvenValue;

        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        SyncRunnable syncThread = new SyncRunnable();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        Thread thread3 = new Thread(syncThread, "SyncThread3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
