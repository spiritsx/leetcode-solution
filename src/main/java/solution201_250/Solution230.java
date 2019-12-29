package solution201_250;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * created at 2019/12/23
 *
 * @author shixi
 */
public class Solution230 {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>(k);
        dfs(root, list);

        return list.get(k - 1);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
        TreeNode root = TreeNode.constructTree(nums);
        Solution230 solution230 = new Solution230();
        int i = solution230.kthSmallest(root, 3);
        System.out.println(i);
    }
}
