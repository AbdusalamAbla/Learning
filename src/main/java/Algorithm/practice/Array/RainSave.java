package Algorithm.practice.Array;

/**
 * Created by Abdusalam on 18/09/13.
 */
public class RainSave {

    public static int solute(int[] A){
        if(A == null || A.length < 3)
            return 0;

        int localMax = A[0];
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        for(int i=0;i<A.length;i++) {
            if(A[i] <= localMax)
                left[i] = localMax;
            else {
                localMax = A[i];
                left[i] = localMax;
            }
        }

        localMax = A[A.length-1];
        for(int i=A.length-1;i>-1;i--) {
            if(A[i] <= localMax)
                right[i] = localMax;
            else {
                localMax = A[i];
                right[i] = localMax;
            }
        }

        int area = 0;
        for(int i=0;i<A.length;i++) {
            area += Math.min(left[i], right[i]) - A[i];
        }

        return area;

    }
    public static void main(String[] args) {
        System.out.println(solute(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
