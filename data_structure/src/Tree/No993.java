package Tree;

import entity.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 */
public class No993 {

    /**
     * 利用前序遍历的特性，当前遍历的队列都在同一深度的特性
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode[] nodes = new TreeNode[2];
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(curr.left!=null){
                    queue.offer(curr.left);
                    if(curr.left.val == x){
                        nodes[0] = curr;
                    }else if(curr.left.val == y){
                        nodes[1] = curr;
                    }
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                    if(curr.right.val==x){
                        nodes[0] = curr;
                    }else if(curr.right.val == y){
                        nodes[1] = curr;
                    }
                }
            }
            if(nodes[0]!=null&&nodes[1]!=null&&nodes[0]!=nodes[1]){
                return true;
            }
            if((nodes[0]!=null&&nodes[1]==null)||(nodes[0]==null&&nodes[1]!=null)){
                return false;
            }
            Arrays.fill(nodes,null);
        }
        return false;
    }
}
