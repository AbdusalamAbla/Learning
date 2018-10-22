package Algorithm.practice;

/**
 *
 * 反转整数
 * Created by Abdusalam on 18/09/15.
 */
public class ReverseInteger {
    public static int Solute(int x){
        if(x == 0)return x;
        if(x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) return 0;

        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        long sum = 0L;
        int remain;
        while (x >0)
        {
            remain = x %10;
            sum = sum*10 + remain;
            x = x/10;

        }
        if(sum > Integer.MAX_VALUE)return 0;
        return sign*(int)sum;
    }

    public static void main(String[] args) {
        System.out.println(Solute(-12141241));
    }
}
