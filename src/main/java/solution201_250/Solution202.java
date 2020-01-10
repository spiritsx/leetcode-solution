package solution201_250;

import org.junit.jupiter.api.Assertions;

/**
 * 202. 快乐数
 * created at 2020/1/6
 *
 * @author shixi
 */
public class Solution202 {
    public boolean isHappy(int n) {
        return helper(n,0);
    }

    public boolean helper(int n, int times) {
        if (times > 50) {
            return false;
        }
        String nStr = String.valueOf(n);
        int[] numArr = new int[nStr.length()];
        for(int i = 0; i< numArr.length; i++) {
            numArr[i] = n % 10;
            n /= 10;
        }
        int newNum = 0;
        for (int i = 0; i < numArr.length; i++) {
            int num = numArr[i]* numArr[i];
            newNum += num;
        }
        if (newNum == 1) {
            return true;
        } else if (helper(newNum , times + 1)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        boolean happy = solution202.isHappy(45);
        System.out.println(happy);
        Assertions.assertEquals(happy, true);
    }
}
