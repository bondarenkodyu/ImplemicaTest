package task3;
import java.math.BigInteger;

/**
 * Find the sum of the digits in the number 100! (i.e. 100 factorial)
 */
public class Factorial {

    public static void main(String [] args)
    {
        int result = 0;
        // array of digits
        String [] arr = String.valueOf(fact(100)).split("");
        for(String s : arr)
        {
            System.out.println(s);
            result += Integer.valueOf(s);
        }
        System.out.println(result);
    }
    // calculation number's factorial
    public static BigInteger fact(int n)
    {
        BigInteger bigInteger;
        if (n == 0) return BigInteger.ONE;
        bigInteger = BigInteger.valueOf(n).multiply(fact(n-1));
        return bigInteger;
    }
}


