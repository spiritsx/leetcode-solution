package solution101_150;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * created at 2019/12/14
 *
 * @author shixi
 */
public class Solution105 {


    Map<Integer, Integer> inMap = new HashMap<>();
    int[] preorder;
    int[] inorder;
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }


        return helper(0, inorder.length);
    }

    private TreeNode helper(int inLeft, int inRight) {
        if (inLeft == inRight) {
            return null;
        }

        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        int index = inMap.get(rootVal);
        preIndex++;
        root.left = helper(inLeft, index);
        root.right = helper(index + 1, inRight);
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 11, 20, 15, 7};
        int[] inorder = new int[]{9, 11, 3, 15, 20, 7};
        Solution105 solution105 = new Solution105();
        TreeNode treeNode = solution105.buildTree(preorder, inorder);
        treeNode.show();
    }
}
