package Tree;

import entity.TreeNode;

/**
 * 二叉树最小深度
 */
public class No111 {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left!=null&&root.right!=null){
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }else if(root.left != null){
            return minDepth(root.left)+1;
        }else if(root.right != null){
            return minDepth(root.right)+1;
        }
        return 1;
    }
}
