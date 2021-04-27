package Tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。叶子节点 是指没有子节点的节点。
 */
public class No113 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,new ArrayList<Integer>());
        return ans;
    }

    public void dfs(TreeNode node,int targetSum,List<Integer> path){
        if(node==null){
            return;
        }
        path.add(node.val);
        if(node.left == null && node.right == null && targetSum - node.val == 0){
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        dfs(node.left,targetSum - node.val,path);
        dfs(node.right,targetSum - node.val,path);
        path.remove(path.size()-1);
    }

}
