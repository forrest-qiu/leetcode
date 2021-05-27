package Tree;

import entity.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class No543 {
    int ans =  0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node){
        if(node.left==null&&node.right==null)return 0;
        int leftSize = node.left==null?0:dfs(node.left)+1;
        int rightSize = node.right==null?0:dfs(node.right)+1;
        ans = Math.max(ans,leftSize+rightSize);
        return Math.max(leftSize,rightSize);
    }
}
