package tree;

/**
 * created at 2019/12/15
 *
 * @author shixi
 */
public class Solution116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {

    }
}
