package Tree;

import entity.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 */
public class No108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return  fun(nums,0,n-1);
    }

    public TreeNode fun(int[] nums,int left,int right){
        if(right<1){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = fun(nums,left,mid-1);
        node.right = fun(nums,mid+1,right);
        return node;
    }


}
