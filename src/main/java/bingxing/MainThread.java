package bingxing;

/**
 * Created by Abdusalam on 18/09/11.
 */
public class MainThread {
    public static void main(String[] args) {
        Thread A=new Thread(new ListOff());
        A.start();
        System.out.println("等待ListOff完成");
    }
}
