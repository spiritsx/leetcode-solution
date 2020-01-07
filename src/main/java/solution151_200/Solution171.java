package solution151_200;

import org.junit.jupiter.api.Assertions;

/**
 * 171. Excel表列序号
 * created at 2020/1/7
 *
 * @author shixi
 */
public class Solution171 {

    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int num = aChar - 'A' + 1;
            result = result * 26 + num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution171 solution171 = new Solution171();
        int ab = solution171.titleToNumber("AB");
        System.out.println(ab);
        Assertions.assertEquals(ab, 28);
        int zy = solution171.titleToNumber("ZY");
        System.out.println(zy);
        Assertions.assertEquals(zy, 701);
    }
}
