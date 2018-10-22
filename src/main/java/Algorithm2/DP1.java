package Algorithm2;

import java.util.Scanner;

/**
 * Created by Abdusalam on 18/10/18.
 */
class Thing{
    int w,v;
    Thing(int w,int v){
        this.w=w;
        this.v=v;
    }
        }

public class DP1 {
    private int n,W;
    private Thing[] Things;
    private DP1(){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        Things=new Thing[n];
        for (int i = 0; i <n ; i++) {
            Things[i]=new Thing(scanner.nextInt(),scanner.nextInt());
        }
        W=scanner.nextInt();
    }

    private int rec(int index, int heavy){
        int res;
        if(index==n){
            res=0;
        }else if (heavy<Things[index].w){
            res=rec(index+1,heavy);
        }else {
            res=Math.max(rec(index+1,heavy),rec(index+1,heavy-Things[index].w)+Things[index].v);
        }
        return res;
    }

    public static void main(String[] args) {
        DP1 dp1=new DP1();
        System.out.println(dp1.rec(0,5));
    }
}
