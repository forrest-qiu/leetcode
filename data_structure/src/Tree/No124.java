package Tree;

import entity.TreeNode;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 */
public class No124 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sum(root);
        return ans;
    }
    public int sum(TreeNode node){
        if(node==null){
            return 0;
        }
        int left_sum = Math.max(sum(node.left),0);
        int right_sum = Math.max(sum(node.right),0);
        int curr = left_sum + right_sum +node.val;
        ans = Math.max(curr,ans);
        return node.val + Math.max(left_sum,right_sum);
    }
}
