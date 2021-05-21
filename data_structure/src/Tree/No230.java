package Tree;

import entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class No230 {

    public int kthSmallest(TreeNode root, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        addVal(root,set);
        int i = 1;
        for (Integer num : set) {
            if(i==k){
                return num;
            }
            i++;
        }
        return 0;
    }

    public void addVal(TreeNode node,TreeSet<Integer> set){
        if(node==null){
            return;
        }
        set.add(node.val);
        addVal(node.left,set);
        addVal(node.right,set);
    }


    public int kthSmallest2(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        int count = 1;
        while(node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            if(count==k){
                return pop.val;
            }else{
                count++;
            }
            node = pop.right;
        }
        return 0;
    }



}
