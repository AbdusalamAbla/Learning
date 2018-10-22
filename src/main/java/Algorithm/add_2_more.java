package Algorithm;

import java.util.Scanner;

/**
 * 2的合集算法：这是是对2,22,222,2222,22...求和
 * 输入n为求到第n位
 * Created by 34784 on 17/10/15.
 */
public class add_2_more {
        private int sum = 0;
        public void numbers(int n) {
            for (int t = 0; t < n + 1; t++) {
                int number = 1;
                int num = 0;
                for (int i = 0; i < t; i++) {
                    num = num + number;
                    number = number * 10;
                }
                sum += num;
            }
            System.out.println(sum * 2);
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        add_2_more i = new add_2_more();
        i.numbers(l);
    }
}
