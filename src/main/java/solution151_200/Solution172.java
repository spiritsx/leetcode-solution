package solution151_200;

import org.junit.jupiter.api.Assertions;

/**
 * 172. 阶乘后的零
 */
public class Solution172 {

    public int trailingZeroes(int n) {
        int num = 0;
        while (n > 0) {
            num += n /5;
            n /= 5;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution172 solution172 = new Solution172();
        int zeroNum = solution172.trailingZeroes(5);
        System.out.println(zeroNum);
        Assertions.assertEquals(zeroNum, 1);
    }
}
