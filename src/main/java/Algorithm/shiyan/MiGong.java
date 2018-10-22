package Algorithm.shiyan;
import java.util.Scanner;

/**
 * 迷宫算法
 * Created by Abdusalam on 17/11/29.
 */
public class MiGong {
    private int max(int a, int b){return a>=b?a:b; }
    private void ZouMigong(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入 n,m");
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int migong[][]=new int[n][m];
        System.out.println("请输入迷宫中的奖励值");
        int a,b,c,d;
        for (a = 0; a <n ; a++) {
            for (b = 0; b <m ; b++) {
                migong[a][b]=scanner.nextInt();
            }
        }
        StringBuilder x1=new StringBuilder("(1,1)");
        StringBuilder x2=new StringBuilder("->(1,1)");
        int dp[][][][][]=new int[n+1][m+1][n+1][m+1][2];
        for (a =n-1;  a>=0 ; a--) {
            for (b =m-1; b >=0 ; b--) {
                for (c = n-1;c>=0 ; c--) {
                    for (d = m-1;d>=0 ; d--) {
                        if(a+b==c+d){
                            int max = max(max(dp[a + 1][b][c][d + 1][0], dp[a + 1][d][c + 1][d][0]),
                                    max(dp[a][b + 1][c][d + 1][0], dp[a][b + 1][c][d + 1][0]));
                            int sum = migong[a][b] + max;
                            if (a==c&&b==d){
                                dp[a][b][c][d][0]+= sum;
                            }else {
                                dp[a][b][c][d][0]+=(sum +migong[c][d]);
                            }
                            if (max ==dp[a+1][b][c+1][d][0]){
                                dp[a][b][c][d][1]=1;
                            }else if (max ==dp[a+1][b][c][d+1][0]){
                                dp[a][b][c][d][1]=2;
                            }else if (max ==dp[a][b+1][c+1][d][0]){
                                dp[a][b][c][d][1]=3;
                            }else{
                                dp[a][b][c][d][1]=4;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[0][0][0][0][0]);
        a=b=c=d=0;
        int _a,_b,_c,_d;
        while(!(a==n-1&&b==m-1&&c==n-1&&d==m-1)){
            if (dp[a][b][c][d][1]==1){
                a+=1;c+=1;
            }else if (dp[a][b][c][d][1]==2){
                a+=1;d+=1;
            }else if (dp[a][b][c][d][1]==3){
                b+=1;c+=1;
            }else{
                b+=1;d+=1;
            }
            _a=a+1;_b=b+1;_c=c+1;_d=d+1;
            if (!(a==n-1&&b==m-1&&c==n-1&&d==m-1)){
                x1.append("->(").append(_a).append(",").append(_b).append(")");
                x2.insert(0,"->("+_c+","+_d+")");
            }
        }
        System.out.println(x1+"->("+n+","+m+")"+x2);
    }

    public static void main(String[] args) {
        MiGong hi=new MiGong();
        hi.ZouMigong();
    }
}
