package Algorithm.practice.Array;

/**
 * Created by Abdusalam on 18/09/15.
 */
public class RemoveDuplicate2 {

    public static int Solute(int[] nums){

        int repeat=2;
        if(nums.length<=repeat)return nums.length;

        int len2=1;
        int cnt=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[len2-1]){
                cnt=1;nums[len2++]=nums[i];
            }
            else{
                cnt++;
                if(cnt<=repeat){
                    nums[len2++]=nums[i];
                }

            }
        }
        return len2;
        }
    public int removeDuplicates(int[] nums) {
        int start = 1;
        int cnt = 1;
        int i = 1;
        while (i < nums.length)
        {
            if (nums[i] == nums[i-1])
            {
                if (cnt < 2)
                {
                    nums[start++] = nums[i++];
                    cnt++;
                }
                else
                {
                    i++;
                }
            }
            else
            {
                nums[start++] = nums[i++];
                cnt = 1;
            }
        }
        return start;
    }
    public static void main(String[] args) {

        System.out.println(Solute(new int[]{1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,3,3}));
    }
}
