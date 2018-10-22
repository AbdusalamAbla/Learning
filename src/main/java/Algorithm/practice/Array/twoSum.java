package Algorithm.practice.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Abdusalam on 18/09/12.
 */
public class twoSum {
    private static int[] processing(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                result[0] = index ;
                result[1] = i;
                break;
            } else {
                map.put(target - nums[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("数组长度:");
        int length=scanner.nextInt();
        System.out.println("输入要找的数组:");
        int[] numbers=new int[length];
        for (int i = 0; i <length ; i++) {
            numbers[i]=scanner.nextInt();
        }
        System.out.println("输入条件");
        int num=scanner.nextInt();
        System.out.println(Arrays.toString(processing(numbers, num)));
    }
}
