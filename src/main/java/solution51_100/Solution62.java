package solution51_100;

import org.junit.jupiter.api.Assertions;

/**
 * 62. 不同路径
 * created at 2020/1/3
 *
 * @author shixi
 */
public class Solution62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i< m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        int i = solution62.uniquePaths(3, 2);
        System.out.println(i);
        Assertions.assertEquals(i, 3);
    }
}
