package Algorithm.practice.Array;

/**
 * Created by Abdusalam on 18/09/13.
 */
public class RemoveElement {

   public static int removeElement (int[] nums,int target){
       int num=0;
        int j=0;
       for (int i = 0; i <nums.length ; i++) {
           if (nums[i]!=target){
               nums[j]=nums[i];
               j++;
           }
       }
       return j;
    }
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1,3,2,3,3,4,3,5,3,6,3,7},3));
    }
}
