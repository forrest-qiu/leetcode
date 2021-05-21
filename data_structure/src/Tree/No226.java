package Tree;

import entity.TreeNode;

/**
 * 翻转一棵二叉树。
 */
public class No226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }
}
