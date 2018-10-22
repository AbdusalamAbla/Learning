package bingxing;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Abdusalam on 18/10/20.
 */
public class SimpleDaemons implements Runnable {
    private static int count=0;
    private final  int id=count++;
    @Override
    public void run() {
        Thread.currentThread().setName("DaemonThread"+id);
        try{
            while (true){

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread()+"  "+this+" "+id);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <10 ; i++) {
            Thread daemon=new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("所有的Daemon都活动起来了");
        System.out.println("输入结束字"+ new Scanner(System.in).nextInt());
    }
}
