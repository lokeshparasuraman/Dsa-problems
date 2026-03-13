package Problems;

import java.math.BigInteger;

public class Miising_element_array {
    static void main() {
        int[]arr={1,2};
        System.out.println(total(arr));
    }
    private static BigInteger total(int [] a) {
        BigInteger n=BigInteger.valueOf(a.length);
        BigInteger actualSum = BigInteger.ZERO;
        BigInteger sum=n.multiply(n.add(BigInteger.ONE)).divide(BigInteger.valueOf(2));
        for(int num:a){
            actualSum=actualSum.add(BigInteger.valueOf(num));
        }
        return sum.subtract(actualSum);
    }
}
