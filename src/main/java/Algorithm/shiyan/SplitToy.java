package Algorithm.shiyan;
import java.util.Arrays;
import java.util.Scanner;

/**此类为分玩具类
 * Created by Abdusalam on 17/11/29.
 */
public class SplitToy {
    private int PersonNum;         //import person number
    private int[] value;
    private int sum;
    private int[] ShouHuo;

    private void getToys(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入玩具数目：");
        int toyNum = scanner.nextInt();
        value=new int[toyNum];
        System.out.println("请输入人数：");
        PersonNum=scanner.nextInt();
        ShouHuo=new int[PersonNum];
        for (int i = 0; i <PersonNum ; i++) {
            ShouHuo[i]=0;
        }
        System.out.println("请输入"+ toyNum +"个玩具的单价");
        for (int i = 0; i < toyNum; i++) {
            value[i]=scanner.nextInt();
        }

        Arrays.sort(value);    //对玩具的价值表进行排序
        for (int k:value         //此处对玩具价值进行求和得到总价值
             ) {
            sum+=k;
        }
    }

    /**
     * 该方法返回价值表中在i处的值
     * @param i   取值位置
     * @return  返回值
     */
    private int getLast(int i){ return value[i]; }
    /**
     * 集成解决方法，创建一个收获价值表，方法结尾返回时应用分配方法解决问题
     */
    private void Solution(){

        //创建一个存储每个人收获玩具价值的数组

        int average = sum / PersonNum;
        System.out.println("平均值为"+ average);
        int[] hi;

        hi=FenPei();
        for (int k:hi
             ) {
            System.out.println(k+" ");
        }
    }

    /**FenPei方法，对玩具进行分配
     * 依次对每个人进行玩具分配
     *   存有每个人收获玩具价值的数组
     * @return  返回ShouHuo
     */
   private int[] FenPei(){
        boolean success=true;
        int last=value.length-1;
        int[] value1=new int[PersonNum];
        for (int i = 0; i <PersonNum ; i++) {
            System.out.println("给第"+(i+1)+"个人分"+getLast(last));
            ShouHuo[i]+=getLast(last);
            last-=1;
        }
        while(success){
            if (last>=PersonNum){
               for (int i=0;i <PersonNum ; i++) {
                  value1[i]=value[last];
                  last-=1;
               }
            Arrays.sort(value1);
               for (int i = 0; i <PersonNum ; i++) {
                   System.out.println("给第"+(i+1)+"个人分"+value1[i]);
                    ShouHuo[i]+=value1[i];
               }
            }else{
                for (int i = last; i >-1; i--) {    //将剩下的玩具按价值分给分少的人
                    System.out.println("给第"+(i+1)+"个人分"+value[i]);
                    Arrays.sort(ShouHuo);
                    ShouHuo[0]+=value[i];
                    success=false;
                }
             }
        }
       Arrays.sort(ShouHuo);
        return ShouHuo;
    }
    /**
     * 控制面板
     *
     */
    public static void main(String[] args) {
        SplitToy disanti=new SplitToy();
        disanti.getToys();
        disanti.Solution();
    }
}
