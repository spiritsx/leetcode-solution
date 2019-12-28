package solution51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * created at 2019/12/28
 *
 * @author shixi
 */
public class Solution78 {
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return results;
        }

        helper(nums, 0, new ArrayList<>());
        return results;
    }

    private void helper(int[] nums, int i, List<Integer> result) {
        results.add(new ArrayList<>(result));

        for (int j = i; j < nums.length; j++) {
            int num = nums[j];
            result.add(num);

            helper(nums, j + 1, result);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = solution78.subsets(nums);
        System.out.println(subsets);
    }
}
