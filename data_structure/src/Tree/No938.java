package Tree;

import entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class No938 {

    int result = 0;

    /**
     * 常规套路，使用中序遍历二叉搜索数获取和
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        if(root == null){
            return 0;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while(curr!=null||!stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode pop = stack.pop();
            if(pop.val>high){
                break;
            }
            if(pop.val>=low&&pop.val<=high){
                ans += pop.val;
            }
            curr = pop.right;
        }
        return ans;
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        fun(root,low,high);
        return result;
    }


    public void fun(TreeNode root,int low, int high){
        if(root==null||(root.val<low||root.val>high)){
            return;
        }
        if(root.val>=low && root.val <= high){
            result += root.val;
        }
        if(root.left!=null&&root.left.val>=low){
            fun(root.left,low,high);
        }
        if(root.right!=null&&root.right.val<=high){
            fun(root.right,low,high);
        }

    }

    public int rangeSumBST3(TreeNode root, int low, int high) {
       if(root==null){
           return 0;
       }
       if(root.val<low){
           return rangeSumBST3(root.right,low,high);
       }else if(root.val>=low && root.val <= high){
           return root.val + rangeSumBST3(root.left,low,high) + rangeSumBST3(root.right,low,high);
       }else{
           return rangeSumBST3(root.left,low,high);
       }
    }

}
