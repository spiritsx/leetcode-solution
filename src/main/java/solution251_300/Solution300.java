package solution251_300;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 300. 最长上升子序列
 * created at 2020/1/4
 *
 * @author shixi
 */
public class Solution300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> tail = new ArrayList<>(nums.length + 1);
        tail.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int left = 0, right = tail.size() - 1;
            if (num > tail.get(right)) {
                tail.add(num);
            } else {
                while (left < right) {
                    int middle = (right - left) / 2 + left;
                    if (tail.get(middle) < num) {
                        left = middle + 1;
                    } else {
                        right = middle ;
                    }
                }
                tail.set(left, num);
            }
        }
        return tail.size();
    }

    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        int length = solution300.lengthOfLIS2(nums);
        System.out.println(length);
        Assertions.assertEquals(length, 6);
    }
}