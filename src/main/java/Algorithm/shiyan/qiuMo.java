package Algorithm.shiyan;
import java.util.Scanner;
/**
 * Created by Abdusalam on 17/11/21.
 */
public class qiuMo {
  private void mul(int a,int b,int c){
      int res=1;
      while(b>0){
          if (b%2==1){
              res=(res*a)%c;
          }
          b=b/2;
          a=(a*a)%c;
      }
      System.out.println("余"+res);

  }

    public static void main(String[] args) {
        qiuMo i=new qiuMo();
        Scanner shuru=new Scanner(System.in);
        System.out.println("输入三个数，以空格隔开");
        int a=shuru.nextInt();
        int b=shuru.nextInt();
        int c=shuru.nextInt();
        i.mul(a,b,c);
    }
}
