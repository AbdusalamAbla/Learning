package bingxing;

import java.util.concurrent.TimeUnit;

/**
 * Created by Abdusalam on 18/09/11.
 */
public class ListOff implements Runnable{
    private int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;
    ListOff(){}

    public ListOff(int countDown){
        this.countDown=countDown;
    }
    private void status(){
        System.out.println("第"+id+"("+(countDown>0?countDown:"结束")+"),");

    }
    @Override
    public void run() {
        while(countDown-->0){
           status();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ListOff listOff=new ListOff();
        listOff.run();
    }

}
