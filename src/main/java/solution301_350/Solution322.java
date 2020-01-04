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
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int result = amount + 1;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] < 0) {
                continue;
            }
            int subResult = coinChange2(coins, amount - coins[i]);
            if (subResult == -1) {
                continue;
            }
            result = Math.min(result, subResult + 1);
        }
        return result == amount + 1 ? -1 : result;
    }

    public int coinChange3(int[] coins, int amount) {
        int[] memory = new int[amount + 1];
        Arrays.fill(memory, -2);
        return helper(coins, amount, memory);
    }

    private int helper(int[] coins, int amount, int[] memory) {
        if (amount == 0) {
            return 0;
        }
        if (memory[amount] != -2) {
            return memory[amount];
        }
        int result = amount + 1;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] < 0) {
                continue;
            }
            int subResult = coinChange3(coins, amount - coins[i]);
            if (subResult == -1) {
                continue;
            }
            result = Math.min(result, subResult + 1);
        }
        memory[amount] = result == amount + 1 ? -1 : result;
        return memory[amount];
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int[] coins = new int[]{1, 2, 5};
        int i = solution322.coinChange3(coins, 11);
        System.out.println(i);
        Assertions.assertEquals(i, 3);
    }
}
