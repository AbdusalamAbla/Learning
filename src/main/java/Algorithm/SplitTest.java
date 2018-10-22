package Algorithm;
import java.util.Scanner;

/**
 * 对面一串数字的split实例
 * Created by 34784 on 17/10/15.
 */
public class SplitTest {

  private void  Split(int n){
        String i ="" + n;
        String[] a = i.split("2");
      for (String anA : a) {
          System.out.print(" "+anA);
      }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
    SplitTest i=new SplitTest();
    int importNum= scanner.nextInt();
    i.Split(importNum);
    }
}
