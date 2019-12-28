package solution51_100;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created at 2019/12/13
 *
 * @author shixi
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            helper(root.left, list);
        }

        list.add(root.val);
        helper(root.right, list);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            list.add(treeNode.val);
            treeNode = treeNode.right;
        }

        return list;
    }

    public static void main(String[] args) {
        Solution94 solution94 = new Solution94();
        Integer[] nums = new Integer[]{2, 1, 4, null, null ,3};
        TreeNode root = TreeNode.constructTree(nums);
        root.show();
        List<Integer> list = solution94.inorderTraversal2(root);
        System.out.println(list);
    }
}
