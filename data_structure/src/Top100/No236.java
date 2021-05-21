package Top100;

import entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 *
 *
 */
public class No236 {
    List<TreeNode> pPath = new ArrayList<>();
    /**
     * 先找到p节点，判断q节点是不是p节点的子节点，不是则判断q节点是不是p节点的父节点的直接点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        dfs(node,p);
        pPath.add(p);
        for (int i = pPath.size()-1; i >= 0; i--) {
            if(containNode(pPath.get(i),q)){
                return pPath.get(i);
            }
        }
        return null;
    }

    /**
     * 寻找p节点，并保存p节点的所有父节点
     */
    public void dfs(TreeNode root,TreeNode p){
        if(root==null){
            return;
        }
        if(root.left == p || root.right == p){
            pPath.add(root);
            return;
        }
        pPath.add(root);
        dfs(root.left,p);
        dfs(root.right,p);

    }

    /**
     * 判断root节点下是否有node子节点
     * @param root
     * @param node
     * @return
     */
    public boolean containNode(TreeNode root,TreeNode node){
        if(root==null){
            return false;
        } else if(root==node){
            return true;
        }else{
            return containNode(root.left,node)||containNode(root.right,node);
        }
    }

    @Test
    public void test(){
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(0);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(7);
        TreeNode j = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = h;
        e.right = j;
        c.left = f;
        c.right = g;
        System.out.println(lowestCommonAncestor(a,h,j).val);
    }
}
