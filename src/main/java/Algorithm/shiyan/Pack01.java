package Algorithm.shiyan;

import java.util.Scanner;

/**
 * 01背包问题，包含对存物品情况的模拟方法和
 * Created by Abdusalam on 17/11/24.
 */
public class Pack01 {
    /**
     *
     * @param room  背包容量
     * @param num   物品数量
     * @param heavy   存有物品质量的数组
     * @param value   存有物品价值的数组
     * @return  返回对符合总重量小于背包容量条件的情况，
     */
    private int [][] pack(int room, int num, int heavy[], int value[]){
        //c[i][v]表示前i件物品恰放入一个重量为room的背包可以获得的最大价值
        int c[][]= new int[num+1][room+1];
        for(int i = 0;i<num+1;i++)
            c[i][0]=0;
        for(int j = 0;j<room+1;j++){
            c[0][j]=0;
        }
        for(int i = 1;i<num+1;i++){
            for(int j = 1;j<room+1;j++){
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if(heavy[i-1]<=j){
                    if(c[i-1][j]<(c[i-1][j-heavy[i-1]]+value[i-1]))
                        c[i][j] = c[i-1][j-heavy[i-1]]+value[i-1];
                    else
                        c[i][j] = c[i-1][j];
                }else
                    c[i][j] = c[i-1][j];
            }
        }
        return c;
    }
    /**
     * 逆推法求出最优解
     * @param c  情况表
     * @param heavy  存有物品价值的数组
     * @param room 背包容量
     * @param num   物品数量
     * 完成后打印存物品情况
     */
    private void printPack(int[][] c, int[] heavy, int room, int num){

        int x[] = new int[num];
        //从最后一个状态记录c[n][m]开始逆推
        for(int i = num;i>0;i--){
            //如果c[i][m]大于c[i-1][m]，说明c[i][m]这个最优值中包含了heavy[i-1](注意这里是i-1，因为c数组长度是n+1)
            if(c[i][room]>c[i-1][room]){
                x[i-1] = 1;
                room-=heavy[i-1];
            }
        }
        for(int j = 0;j<num;j++)
            System.out.println(x[j]);
    }
    private void test(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入背包容量大小");
        int room = scanner.nextInt();
        System.out.println("请输入物品数量");
        int num = scanner.nextInt();
        int[] heavy,value;
        heavy=new int[num];
        value=new int[num];
        System.out.println("请依次输入每个物品的重量和价值，并以空格隔开");
        for (int i = 0; i <num ; i++) {
            heavy[i]=scanner.nextInt();
            value[i]=scanner.nextInt();
        }
        Pack01 pack = new Pack01();
        int c[][] = pack.pack(room, num, heavy, value);
        pack.printPack(c, heavy, room,num);
    }
    public static void main(String args[]){
        Pack01 test=new Pack01();
        test.test();
    }
}
