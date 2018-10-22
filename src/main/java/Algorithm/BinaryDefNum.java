package Algorithm;

import java.util.Scanner;

/**
 * 检查两个整数转为二进制后的不同位数
 * Created by Abdusalam on 17/12/25.
 */
public class BinaryDefNum {
    private static int Binary(int x, int y){
        int num=0;
        StringBuilder a= new StringBuilder(Integer.toBinaryString(x));
        StringBuilder b= new StringBuilder(Integer.toBinaryString(y));
        if (a.length()!=b.length()){
            int  length1=a.length(),length2=b.length();
            if (a.length()>b.length()){
                for (int i = 0; i <length1-length2 ; i++) {
                    b.insert(0, "0");
                }
            }else {
                for (int i = 0; i <length2-length1 ; i++) {
                    a.insert(0, "0");
                }
            }
        }
        System.out.println(a+" "+b);
        String[] c= a.toString().split("");
        String[] d= b.toString().split("");

        for (int i = 0; i <a.length(); i++) {
            if (!c[i].contains(d[i])){
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println(Binary(scanner.nextInt(),scanner.nextInt()));
    }
}
