package solution51_100;

import org.junit.jupiter.api.Assertions;

/**
 * 69. x 的平方根
 * created at 2020/1/8
 *
 * @author shixi
 */
public class Solution69 {

    public int mySqrt(int x) {
        if (x < 0) {
            throw new RuntimeException();
        }

        if (x == 0) {
            return 0;
        }

        int left = 0, right = (x >> 1) + 1;
        int result = 0;
        while (left < right) {
            int middle = ((right - left) >> 1) + left + 1;
            if (middle == x / middle) {
                return middle;
            } else if (middle > x / middle) {
                right = middle - 1;
            } else {
                left = middle;
                result = middle;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        int i1 = solution69.mySqrt(2147395599);
        System.out.println(i1);
        Assertions.assertEquals(i1, 2);
        int i2 = solution69.mySqrt(5);
        System.out.println(i2);
        Assertions.assertEquals(i2, 2);
    }
}
