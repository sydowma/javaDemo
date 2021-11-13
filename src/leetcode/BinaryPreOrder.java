package leetcode;

import java.util.LinkedList;
import java.util.List;


/**
 * 这就是用分解问题的思维模式写二叉树的前序遍历，如果写中序和后序遍历也是类似的。
 */
public class BinaryPreOrder {
    // 定义：输入一棵二叉树的根节点，返回这棵树的前序遍历结果

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // 前序遍历的结果，root.val 在第一个
        res.add(root.val);
        // 后面接着左子树的前序遍历结果
        res.addAll(preorder(root.left));
        // 最后接着右子树的前序遍历结果
        res.addAll(preorder(root.right));
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> res = preorder(root);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
