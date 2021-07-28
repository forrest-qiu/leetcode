package preday;

import entity.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 */
public class No863 {
    //子节点---------->父节点
    private Map<TreeNode,TreeNode> parents = new HashMap<>();

    private Set<TreeNode> used = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dp(root,null,target);
        List<Integer> ans = new ArrayList<>();
        dfs(target,ans,k);
        return ans;
    }

    public void dp(TreeNode node, TreeNode parent, TreeNode target){
        if(node==null){
            return;
        }
        parents.put(node,parent);
        dp(node.left,node,target);
        dp(node.right,node,target);
    }

    public void dfs(TreeNode node,List<Integer> ans,int distance){
        if(node!=null&&!used.contains(node)){
            used.add(node);
            if(distance==0){
                ans.add(node.val);
                return;
            }
            dfs(node.left,ans,distance-1);
            dfs(node.right,ans,distance-1);
            dfs(parents.get(node),ans,distance-1);
        }
    }


}
