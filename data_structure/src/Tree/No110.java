package Tree;

import entity.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class No110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(getHeight(root.left)-getHeight(root.right))<=1){
            return true;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(getHeight(node.left),getHeight(node.right))+1;
    }

}
