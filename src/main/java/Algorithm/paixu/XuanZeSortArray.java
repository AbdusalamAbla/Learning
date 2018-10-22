package Algorithm.paixu;

import java.util.Random;

/**Task：这是对简单数组进行选择排列的方法
 * Created by Abdusalam on 17/10/30.
 */
public class XuanZeSortArray {
    /**
     *
     * @param a   给定一个简单数组
     * @param first   给定要排序的起始点位置
     * @param last     给定要排序的长度
     * @return          成功返回1
     */
    public static int[] selectSort(int[] a,int first,int last) {
        int min=a[first];//当前最小
        int minIdex=0;
        boolean isSuccessful = false;
        for (int i =first+1; i <last; i++) {
            if (min>a[i]){
                minIdex=i;
                isSuccessful=true;
                min=a[i];
            }
        }
        if (isSuccessful){
            a[first]=a[first]+a[minIdex];
            a[minIdex]=a[first]-a[minIdex];
            a[first]=a[first]-a[minIdex];
        }
         if (first+2<last){
             return selectSort(a,first+1,last);
         }
          return a;
    }

    public static void main(String[] args) {
        Random  rand=new Random();
        int[] a=new int[5];
        for (int i = 0; i <5 ; i++) {
            a[i]=rand.nextInt(50);
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for (int anA : selectSort(a,0,5)) {
            System.out.print(anA+" ");
        }
    }
}


