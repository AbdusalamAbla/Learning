package bingxing;

/**
 * Created by Abdusalam on 18/09/11.
 */
public class MoreBasicThread{
    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            new Thread(new ListOff()).start();
        }
        System.out.println("等待ListOff完成");
    }
}
