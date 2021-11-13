package leetcode;

/**
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 *
 * 中序遍历：左子树---> 根结点 ---> 右子树
 *
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 *
 * 层次遍历：只需按层次遍历即可
 *
 * 二叉树遍历
 *
 */
public class BinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode();
        root.left.val = 2;
        root.right = new TreeNode();
        root.right.val = 3;
        root.left.left = new TreeNode();
        root.left.left.val = 4;
        root.left.right = new TreeNode();
        root.left.right.val = 5;
        root.right.left = new TreeNode();
        root.right.left.val = 6;
        root.right.right = new TreeNode();
        root.right.right.val = 7;
        bt.traverse(root);
    }
}
