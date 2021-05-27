package Top100;

import entity.TreeNode;
import org.junit.Test;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数
 */
public class No437 {

    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        fun(root, targetSum);
        return ans;
    }

    public void fun(TreeNode node, int targetSum) {
        if (node != null) {
            dfs(node, targetSum);
            if (node.left != null) {
                fun(node.left, targetSum);
            }
            if (node.right != null) {
                fun(node.right, targetSum);
            }
        }
    }

    public void dfs(TreeNode curr, int targetSum) {
        if (curr == null) {
            return;
        }
        int less = targetSum - curr.val;
        if(less==0){
            ans++;
        }
        dfs(curr.left, less);
        dfs(curr.right, less);
    }


    @Test
    public void test(){
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(11);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(-2);
        TreeNode i = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        d.left = g;
        d.right = h;
        e.right = i;
        System.out.println(pathSum(a,8));
    }


}
