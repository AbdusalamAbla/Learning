package enumtest;

/**
 * Created by 34784 on 17/10/20.
 */
public class SuitDemo {
    public static void main(String[] args) {
        for (Suit next:Suit.values()
             ) {
            System.out.println(next+" are "+next.getColor()+" and have an ordinal value of "+next.ordinal());
        }
    }
}
