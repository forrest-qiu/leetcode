package Top100;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

 提醒一下，二叉搜索树满足下列约束条件：

 节点的左子树仅包含键 小于 节点键的节点。
 节点的右子树仅包含键 大于 节点键的节点。
 左右子树也必须是二叉搜索树。
 */
public class No538 {

    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        int ans = 0;
        while(!stack.isEmpty()||curr!=null){
            if(curr!=null){
                stack.push(curr);
                curr = curr.right;
            }else{
                TreeNode pop = stack.pop();
                ans += pop.val;
                pop.val = ans;
                curr = pop.left;
            }
        }
        return root;
    }

    int sum = 0;
    public TreeNode convertBST2(TreeNode root) {
        inOrder(root);
        return root;
    }

    public void inOrder(TreeNode node){
        if(node==null) return;
        inOrder(node.right);
        node.val = sum + node.val;
        sum = node.val;
        inOrder(node.left);
    }
}
