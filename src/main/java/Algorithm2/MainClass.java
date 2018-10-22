package Algorithm2;

/**
 * Created by Abdusalam on 18/10/21.
 */
class Solution {
    private int sum=0;
    private boolean checkNeedTurn(int[][] A, int i){
        boolean retBoolean = false;
        int zeroCount = 0;
        for(int j=0; j<A.length; j++){
            if(zeroCount > A.length/2){
                retBoolean = true;
                return retBoolean;
            }
            if(A[j][i] == 0){
                zeroCount++;
            }

        }
        if(zeroCount > A.length/2){
            retBoolean = true;
        }
        return retBoolean;
    }

    public int matrixScore(int[][] A) {
        int retData = 0;
        int count = A[0].length - 1;

        // 先横向反转，然后再纵向反转
        for(int k=0; k<A.length; k++){
            if(A[k][0] == 0){
                for(int m=0; m<A[0].length;m++){
                    A[k][m] = (A[k][m] + 1)%2;
                }
            }

        }
        // 竖向反转
        for(int i=0; i<A[0].length; i++){
            if(!checkNeedTurn(A,i)){
                continue;
            }
            for(int j=0; j<A.length;j++){
                A[j][i] = (A[j][i] + 1)%2;
            }
        }

        for(int k=0; k<A.length; k++){
            for(int m=0; m<A[0].length;m++){
                retData += Math.pow(2,count - m) * A[k][m];
            }

        }
        return retData;
    }
}

public class MainClass {


    public static void main(String[] args)  {
        int[][] num=new int[][]{{1,2,3},{2,3,4}};
        Solution solution=new Solution();
        System.out.println(solution.matrixScore(num));

    }
}
