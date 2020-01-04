package solution301_350;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * created at 2020/1/4
 *
 * @author shixi
 */
public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int maxValue = amount + 1;
        int[] dp = new int[maxValue];
        Arrays.fill(dp, maxValue);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 ) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int[] coins = new int[]{1, 2, 5};
        int i = solution322.coinChange(coins, 11);
        System.out.println(i);
        Assertions.assertEquals(i, 3);
    }
}
