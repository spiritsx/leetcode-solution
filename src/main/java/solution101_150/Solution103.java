package solution101_150;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * created at 2019/12/14
 *
 * @author shixi
 */
public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode cur;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    cur = stack1.pop();
                    subList.add(cur.val);
                    if (cur.left != null) {
                        stack2.push(cur.left);
                    }
                    if (cur.right != null) {
                        stack2.push(cur.right);
                    }
                }

            } else if (!stack2.isEmpty()) {
                while (!stack2.isEmpty()) {
                    cur = stack2.pop();
                    subList.add(cur.val);
                    if (cur.right != null) {
                        stack1.push(cur.right);
                    }
                    if (cur.left != null) {
                        stack1.push(cur.left);
                    }
                }
            }
            lists.add(subList);


        }
        return lists;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        helper(root, 0, lists);
        return lists;
    }

    private void helper(TreeNode root, int length, List<List<Integer>> lists) {
        if (root == null) {
            return;
        }
        if (lists.size() < length + 1) {
            List<Integer> list = new ArrayList<>();
            lists.add(list);
        }

        if ((length & 1) == 0) {
            lists.get(length).add(root.val);
        } else {
            lists.get(length).add(0, root.val);
        }
        helper(root.left, length+1, lists);
        helper(root.right, length+1, lists);
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{3,9,20,null,11,15,7};
        TreeNode root = TreeNode.constructTree(integers);
        root.show();
        Solution103 solution103 = new Solution103();
        List<List<Integer>> lists = solution103.zigzagLevelOrder(root);
        System.out.println(lists);
    }
}
