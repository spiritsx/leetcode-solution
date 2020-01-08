package solution1_50;

import org.junit.jupiter.api.Assertions;

/**
 * 29. 两数相除
 * created at 2020/1/8
 *
 * @author shixi
 */
public class Solution29 {

    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }

        boolean flag = false;
        if (dividend == Integer.MIN_VALUE) {
            dividend = dividend + 1;
            flag = true;
        }
        //异或，如果两个符号不同，异或之后最高位符号必定为1，即为负数
        boolean negative = (dividend ^ divisor) < 0;
        //将数字都变成正数，便于处理
        int dividend1 = dividend > 0 ? dividend : 0 - dividend;
        int divisor1 = divisor > 0 ? divisor : 0 - divisor;
        //存储结果，以及除的次数
        int res = 0, count = 1;
        while (dividend1 >= divisor1) {
            dividend1 = dividend1 - divisor1;
            res = res + count;
            if (dividend1 < Math.abs(divisor)) {
                if (!flag) {
                    return negative ? 0 - res : res;
                } else {//做了+1处理，判断最后的余数还能不能整除
                    if (dividend1 + 1 == Math.abs(divisor)) {
                        return negative ? 0 - res - 1 : res + 1;
                    } else {
                        return negative ? 0 - res : res;
                    }
                }
            }
            //无法倍增
            if (dividend1 - divisor1 < divisor1) {
                divisor1 = Math.abs(divisor);
                count = 1;
                continue;
            }
            //倍增
            divisor1 += divisor1;
            count += count;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        int divide = solution29.divide(1, 1);
        System.out.println(divide);
        Assertions.assertEquals(divide, 1);
        int divide1 = solution29.divide(7, -2);
        System.out.println(divide1);
        Assertions.assertEquals(divide1, -3);
    }
}
