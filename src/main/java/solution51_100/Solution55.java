package solution51_100;

import org.junit.jupiter.api.Assertions;

/**
 * 55. 跳跃游戏
 */
public class Solution55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        if (nums.length == 2 && nums[0] > 0) {
            return true;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] + i>= nums.length - 1) {
                return true;
            } else if (dp[i] == 0){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        Solution55 solution55 = new Solution55();
        boolean canJump = solution55.canJump(nums);
        System.out.println(canJump);
        Assertions.assertEquals(canJump, true);
    }
}
