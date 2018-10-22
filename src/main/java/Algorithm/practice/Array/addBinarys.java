package Algorithm.practice.Array;

/**
 * Created by Abdusalam on 18/09/14.
 */
public class addBinarys {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    private static String addBinary(String a, String b) {
        if(a.length() < b.length()){//长的换到左边
            String tmp = a;
            a = b;
            b = tmp;
        }

        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carries = 0;//进位
        String rst = "";//返回结果

        while(pb >= 0){
            int sum = (a.charAt(pa)- '0' ) + (b.charAt(pb) - '0') + carries;
            System.out.println(sum);
            rst = String.valueOf(sum % 2) + rst;//取当前位数
            carries = sum / 2;//取进位数
            pa --;
            pb --;
        }

        while(pa >= 0){
            int sum = (a.charAt(pa) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
        }

        if (carries == 1){
            rst = "1" + rst;
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("101011","101111"));
    }
}