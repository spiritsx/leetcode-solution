package solution1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * created at 2019/12/27
 *
 * @author shixi
 */
public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        helper(results, n, n, new char[2 * n]);
        return results;
    }

    private void helper(List<String> results, int leftNum, int rightNum, char[] chars) {
        if (leftNum == 0 && rightNum == 0) {
            results.add(new String(chars));
            return;
        }
        if (leftNum > rightNum) {
            return;
        }

        if (leftNum > 0) {
            chars[chars.length - leftNum - rightNum] = '(';
            helper(results, leftNum - 1, rightNum, chars);
        }

        if (rightNum > 0) {
            chars[chars.length - leftNum - rightNum] = ')';
            helper(results, leftNum, rightNum - 1, chars);
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> strings = solution22.generateParenthesis(0);
        System.out.println(strings);
    }
}
