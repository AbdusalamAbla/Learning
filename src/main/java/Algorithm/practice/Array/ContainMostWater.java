package Algorithm.practice.Array;

/**
 * Created by Abdusalam on 18/09/13.
 */
public class ContainMostWater {
   public static int solute(int[] nums){
       int result=0,l=0,r=nums.length-1;
       while(l<r){
           if (nums[l]>nums[r]){
               result=Math.max(result,Math.min(nums[l],nums[r])*(r-l));
               r--;
           }else {
               result=Math.max(result,Math.min(nums[l],nums[r])*(r-l));
               l++;
           }
       }

       return result;
   }

    public static void main(String[] args) {
        System.out.println(solute(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
