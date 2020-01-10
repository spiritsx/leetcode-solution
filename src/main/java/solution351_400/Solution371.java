package solution351_400;

import org.junit.jupiter.api.Assertions;

/**
 * 371. 两整数之和
 * created at 2020/1/10
 *
 * @author shixi
 */
public class Solution371 {

    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution371 solution371 = new Solution371();
        int sum = solution371.getSum(1, 2);
        System.out.println(sum);
        Assertions.assertEquals(sum, 3);
    }
}
