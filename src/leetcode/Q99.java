package leetcode;

public class Q99 {

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);

        // 中序

        if (root.val < root.left.val) {

        }
        traverse(root.right);
        System.out.println(root.val);
    }
}
