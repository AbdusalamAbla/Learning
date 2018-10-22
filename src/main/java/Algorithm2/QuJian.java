package Algorithm2;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Abdusalam on 18/10/18.
 */
class Tag{
    int begin;
    int finish;
       Tag(int begin,int finish){
           this.begin=begin;
       this.finish=finish;
       }

}
public class QuJian {
    private Tag[] works;
    int n;
    private QuJian(){
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
         n = scanner.nextInt();
          works=new Tag[n];
        for (int i = 0; i <n ; i++) {
            int k=random.nextInt(30);
           works[i]=new Tag(k,k+2);
        }

    }

      private Tag[] SortWorks(Tag[] works){
        for(int i=0;i<n;i++){
            Tag buffer=works[i];
            int locate=i;
            for (int j = i+1; j <n ; j++) {
                if (buffer.finish>works[j].finish){
                    buffer=works[j];
                    locate=j;
                }
            }
            if (locate!=i){
                works[locate]=works[i];
                works[i]=buffer;
            }
        }
          for (Tag hi:works
               ) {
              System.out.println(hi.begin+"  "+hi.finish);
          }
        return works;
    }

    private void solve(Tag[] works){
        int ans=0,t=0;
        for (int i = 0; i <n; i++) {
          if (t<works[i].begin){
              ans++;
              t=works[i].finish;
          }
        }
        System.out.println(t+"  "+ans);
    }

    public static void main(String[] args) {
            QuJian quJian=new QuJian();
            quJian.solve(quJian.SortWorks(quJian.works));
    }
}
