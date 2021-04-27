package Tree;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 */
public class No897 {

    public TreeNode increasingBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode ans = null;
        TreeNode curr = null;
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(ans == null){
                ans = new TreeNode(root.val);
                curr = ans;
            }else{
                curr.right = new TreeNode(root.val);
                curr = curr.right;
            }
            root = root.right;
        }
        return ans;
    }


}
