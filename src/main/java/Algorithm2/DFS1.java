package Algorithm2;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Abdusalam on 18/10/17.
 */
public class DFS1 {
   private int Max;
   private int[] A;
   private  int k;
   private int[] B;
   public DFS1(){
       Scanner scanner=new Scanner(System.in);

       Random random=new Random();
       Max=30;
       k=50;
       A=new int[Max];
       B=new int[Max];
       for (int i = 0; i <Max ; i++) {
           A[i]=random.nextInt(Max);
           System.out.print(A[i]+" ");
       }
   }
          private boolean dfs(int i, int sum){
                if(i==Max) return sum==k;//结果相同返回true完成，否则false失败
                if (dfs(i+1,sum)) return  true; //不加A[i]的情况
                if (dfs(i + 1, sum + A[i])) {B[i]=A[i]; return true;}  //加A[i]的情况
              return false;
          }
          private void solve(){
                if (dfs(0,0)) System.out.println("成功");
                   else {
                     System.out.println("失败");
                   }
          }

    public static void main(String[] args) {
        DFS1 dfs1=new DFS1();
        dfs1.solve();
        for (int num:dfs1.B
             ) {
            if (num!=0){
                System.out.println(num);
            }
        }
    }
}
