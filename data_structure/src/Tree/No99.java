package Tree;

import entity.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 *
 */
public class No99 {
    //中序遍历，找到位置不对的两个节点
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode x = null,y = null,pre = null;
        while(curr!=null||!stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(pre!=null&& curr.val<pre.val){
                y = curr;
                if(x == null){
                    x = pre;
                }else{
                    break;
                }
            }
            pre = curr;
            curr = curr.right;
        }

        swap(x,y);
    }

    public void swap(TreeNode x,TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }


    @Test
    public void fun(){

    }
}
