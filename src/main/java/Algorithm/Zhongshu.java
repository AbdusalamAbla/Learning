package Algorithm;

/**
 * Created by Abdusalam on 17/10/22.
 */
class jishu {
    jishu() {
        int cishu = 0;        //出现次数
        int[] a = new int[10];  //定义要排列的数组
        int[] b = new int[10];//定义a数组中数字出现次数的数组b
        int s = 0;//用s取值得最高次数数字在a和b中的位置
        for (int i = 0; i < 10; i++) {      //随机给数组a加入0—9之间的数字
            a[i] = Math.round((long) (Math.random() * 10));
            System.out.println(" " + a[i]);
        }
        for (int i = 0; i < a.length; i++) {    //对A组的元素一一比对，若一个元素发现重复数字，相同位的B组元素+1
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j])
                    count++;
                b[i] = count;
            }
        }
        for (int i = 1; i < b.length; i++) {   //对b组中的次数进行比对，取出最大的数和他的编号
            if (b[s] >= b[i]) {
                cishu=b[s];
                continue;
            } else {
                s=i;
                cishu=b[i];
            }
        }
        System.out.println("是" + a[s] + "，出现次数为" + cishu);
    }
}

public class Zhongshu {
    public static void main(String[] args) {
        jishu o = new jishu();
    }
}
