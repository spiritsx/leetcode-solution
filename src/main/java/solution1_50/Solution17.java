package solution1_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * created at 2019/12/27
 *
 * @author shixi
 */
public class Solution17 {

    private Map<Character, String> numLetterMap = new HashMap<>();

    public Solution17() {
        numLetterMap.put('2', "abc");
        numLetterMap.put('3', "def");
        numLetterMap.put('4', "ghi");
        numLetterMap.put('5', "jkl");
        numLetterMap.put('6', "mno");
        numLetterMap.put('7', "pqrs");
        numLetterMap.put('8', "tuv");
        numLetterMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        helper(digits, results, 0, new char[digits.length()]);
        return results;
    }

    private void helper(String digits, List<String> results, int i, char[] chars) {
        if (i == digits.length()) {
            String result = new String(chars);
            results.add(result);
            return;
        }
        char digit = digits.charAt(i);
        String letter = numLetterMap.get(digit);
        for (int j = 0; j < letter.length(); j++) {
            chars[i] = letter.charAt(j);
            helper(digits, results, i + 1, chars);
        }
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<String> strings = solution17.letterCombinations("");
        System.out.println(strings);
    }
}
