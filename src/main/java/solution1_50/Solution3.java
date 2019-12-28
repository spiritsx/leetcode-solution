package solution1_50;

import java.util.HashMap;
import java.util.Map;

/**
 * created at 2019/12/7
 *
 * @author shixi
 */
public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            char key = s.charAt(j);
            if (map.containsKey(key)) {
                Integer a = map.get(key);
                i = Math.max(a, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(key, j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aubdubaef";
//        String s = " ";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}