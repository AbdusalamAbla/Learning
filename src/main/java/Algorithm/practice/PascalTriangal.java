package Algorithm.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 杨辉三角   输入行数获得该行
 * Created by Abdusalam on 18/09/15.
 */
 public class PascalTriangal {
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>() ;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> cal_temp = new ArrayList<>();
            long num = 1;
            cal_temp.add(1);
            for (int j = 1; j < i; j++) {
                num = num * (i - j)/j;
                cal_temp.add((int)num);
            }
            result.add(cal_temp);
        }
        return result;
    }
    public List<Integer> generate(int numRows) {
        List<Integer> temp=new LinkedList<>();
        List<List<Integer>> result=new LinkedList<>();
        if (numRows==0){

            return temp;
        }
        temp.add(1);
        if (numRows==1){
            return temp;
        }
        temp.add(1);
        result.add(temp);
        if (numRows==2){
            return temp ;
        }
        int i=0;
        while(i<numRows-2){
            temp=getList(temp);
            i++;
        }
        return temp;
    }
    public static List<Integer> getList(List<Integer> nums){
        List<Integer> result=new LinkedList<>();
        result.add(1);
        for (int i = 0; i <nums.size()-1 ; i++) {
            result.add((nums.get(i)+nums.get(i+1)));
        }
        result.add(1);
        return result;
    }

    public static void main(String[] args) {
        PascalTriangal pascalTriangal=new PascalTriangal();
       List<Integer> result=pascalTriangal.generate(9);
        for (Integer aResult : result) {
                System.out.print(aResult + "  ");
        }
    }
}
