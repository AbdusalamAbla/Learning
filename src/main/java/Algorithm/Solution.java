package Algorithm;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    /**
     * 辅助类
     */
    private static class Node implements Comparable<Node> {
        int value;                                       // 值
        int index;                                       // 值对应的数组下标

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
                                                       // 比较方法
        @Override
        public int compareTo(Node o) {
            if (o == null) {
                return -1;
            }
            return this.value - o.value;
        }
    }
    /**
     * 001-Two Sum（求两个数的和）
     *
     * @param nums   输入数组
     * @param target 两个数相加的和
     * @return 两个数对应的下标
     **/
    private int[] twoSum(int[] nums, int target) {    // 用于保存返回结果
        int[] result = {0, 0};                       // 创建辅助数组
        Node[] tmp = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = new Node(nums[i], i);
        }
        Arrays.sort(tmp);                           // 对辅助数组进行排序
        int lo = 0;                                 // 记录辅助数组中左边一个值的下标
        int hi = nums.length - 1;                  // 记录辅助数组中右边一个值的下标
        while (lo < hi) {                         // 从两边向中间靠陇进行求解
                                                  // 如果找到结果就设置返回结果，并且退出循环
            if (tmp[lo].value + tmp[hi].value == target) {

                if (tmp[lo].index > tmp[hi].index) {
                    result[0] = tmp[hi].index + 1;
                    result[1] = tmp[lo].index + 1;
                } else {
                    result[0] = tmp[lo].index + 1;
                    result[1] = tmp[hi].index + 1;
                }
                break;
            }
                                                                 // 如果大于目标值，右边的下标向左移动
            else if (tmp[lo].value + tmp[hi].value > target) {
                hi--;
            }
                                                                 // 如果小于目标值，左边的下标向右移动
            else {
                lo++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Solution i=new Solution();
        int h=scanner.nextInt();
        int k[]=new int[5];
        for (int j = 0; j <5 ; j++) {
            k[j]=scanner.nextInt();
        }
        int[] j=i.twoSum(k,h);
        for (int o:j
             ) {
            System.out.println(o);
        }
    }
}