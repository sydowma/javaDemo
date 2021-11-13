package leetcode;

/**
 * 最大路径和
 * 后序遍历
 */
public class Q124 {

    int ans = Integer.MIN_VALUE;

    int oneSizeMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Integer.max(0, oneSizeMax(root.left));
        int right = Integer.max(0, oneSizeMax(root.right));

        ans = Integer.max(ans, left + right + root.val);
        return Integer.max(left, right)  + root.val;
    }

    public static void main(String[] args) {
        Q124 q = new Q124();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        q.oneSizeMax(root);
        System.out.println(q.ans);
    }
}
