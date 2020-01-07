package solution1_50;

import org.junit.jupiter.api.Assertions;

/**
 * 50. Pow(x, n)
 * created at 2020/1/7
 *
 * @author shixi
 */
public class Solution50 {

    public double myPow(double x, int n) {
        long longN = n;
        if (longN < 0) {
            x = 1 / x;
            longN = -longN;
        }
        return fastPow(x, longN);
    }

    double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        double v = solution50.myPow(2d, 10);
        System.out.println(v);
        Assertions.assertEquals(v, 1024d);
    }
}
