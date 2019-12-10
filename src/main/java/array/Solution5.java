package array;

/**
 * created at 2019/12/8
 *
 * @author shixi
 */
public class Solution5 {

    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] p = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) {
                    break;
                }

                p[start][end] = (len == 1 || len == 2 || p[start + 1][end - 1])
                        && s.charAt(start) == s.charAt(end);
                if (p[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        }
        return maxPal;
    }


    // 马拉车算法
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String tStr = processOriginal(s);
        int maxLength = 0;
        int center = 0;
        int rightIndex = 0;
        int startIndex = 0;
        int length = tStr.length();
        int[] p = new int[length];
        p[0] = 0;
        p[1] = 0;
        for (int i = 1; i < length - 1; i++) {
            if (rightIndex > i) {
                int i_mirror = 2 * center - i;
                p[i] = Math.min(p[i_mirror], rightIndex - i);
            } else {
                p[i] = 0;
            }

            while (tStr.charAt(p[i] + 1 + i) == tStr.charAt(i - p[i] - 1)) {
                p[i]++;
            }

            if (p[i] + i > rightIndex) {
                center = i;
                rightIndex = p[i] + i;
            }

            if (maxLength < p[i]) {
                maxLength = p[i];
                startIndex = (i - p[i]) / 2;
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    private String processOriginal(String s) {
        if (s == null || s.length() == 0) {
            return "$^";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append('#').append(s.charAt(i));
        }

        stringBuilder.append('#').append('^');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String abacdfgdcaba = solution5.longestPalindrome2("ecbebcf");
        System.out.println(abacdfgdcaba);
    }
}
