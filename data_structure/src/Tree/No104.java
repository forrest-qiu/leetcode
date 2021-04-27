package Tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class No104 {

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
            ans += 1;
        }
        return ans;
    }

    public int maxDepth2(TreeNode root) {
        return fun(root,1);
    }

    public int fun(TreeNode a,int pre){
        if(a==null){
            return pre;
        }
        return Math.max(fun(a.left,pre+1),fun(a.right,pre+1));
    }

}
