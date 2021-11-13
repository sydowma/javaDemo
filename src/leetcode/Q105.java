package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * @author mark
 */
public class Q105 {

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
                       Map<Integer, Integer> inMap) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 前序
        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inMap.getOrDefault(root.val, 0);
        int numsLeft = inRoot - inStart;
        //

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inEnd, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inStart, inEnd, inMap);

        return root;
    }

    public static void main(String[] args) {
        Q105 q = new Q105();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Map<Integer, Integer> map = new HashMap<>();

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1,
                map);

        traverse(root);

    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
