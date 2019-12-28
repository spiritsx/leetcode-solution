package solution1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * created at 2019/12/28
 *
 * @author shixi
 */
public class Solution46 {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return results;
        }
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, new ArrayList<>());
        return results;
    }

    private void helper(int[] nums, boolean[] visited, List<Integer> ints) {
        if (ints.size() == nums.length) {
            results.add(new ArrayList<>(ints));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            ints.add(nums[i]);
            helper(nums, visited, ints);
            visited[i] = false;
            ints.remove(ints.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = solution46.permute(nums);
        System.out.println(permute);
    }
}
