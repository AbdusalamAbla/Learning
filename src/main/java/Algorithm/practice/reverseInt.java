package Algorithm.practice;

/**
 * Created by Abdusalam on 18/10/09.
 */
public class reverseInt {
  public static int Solve(int num){
      if (num==0) return num;
      if (num==Integer.MIN_VALUE||num==Integer.MAX_VALUE) return 0;
      int flag=num>0?1:-1;
      num=Math.abs(num);
      long sum=0L;
      int remain;
      while(num>0){
          remain=num%10;
          sum=sum*10+remain;
          num=num/10;
      }
      if (sum>Integer.MAX_VALUE)return 0;
return flag*(int)num;

  }
}
