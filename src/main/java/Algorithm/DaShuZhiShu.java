package Algorithm;

import java.math.BigInteger;
import java.util.Scanner;
/**
 * 对极大数进行指数函数求解
 * Created by AbduSalam on 17/11/21.
 */
public class DaShuZhiShu {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String n = sc.next();
    String m = sc.next();
    BigInteger bigN = new BigInteger(n);
    BigInteger bigM = new BigInteger(m);
    BigInteger result = BigInteger.ONE;
    for (BigInteger i = BigInteger.ONE; i.compareTo(bigM) <= 0; i = i.add(BigInteger.ONE)) {
        result = result.multiply(bigN);
    }
    System.out.println(result.toString());
}
}
