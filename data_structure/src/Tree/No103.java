package Tree;

import entity.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class No103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans =  new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        boolean flag = true;
        while(!stack.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < stack.size(); i++) {
                TreeNode pop = stack.poll();
                if(flag){
                    list.addLast(pop.val);
                }else{
                    list.addFirst(pop.val);
                }
                if(pop.left!=null){
                    stack.offer(pop.left);
                }
                if( pop.right!=null){
                    stack.offer( pop.right);
                }
            }
            ans.add(list);
            flag = !flag;
        }
        return ans;
    }

}
