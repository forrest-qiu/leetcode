package Tree;

import entity.ListNode;
import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 */
public class No109 {
    //常规套路，转数组再构造二叉树
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        return fun(list,0,list.size()-1);
    }

    public TreeNode fun(List<Integer> list,int left ,int right){
        if(right<left){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = fun(list,left,mid-1);
        root.right = fun(list,mid+1,right);
        return  root;
    }


    public TreeNode sortedListToBST2(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return new TreeNode(head.val);
        }
        return fun2(head,null);
    }

    public TreeNode fun2(ListNode start,ListNode end){
        if(start==null||start == end){
            return null;
        }
        ListNode s = start;
        ListNode q = start;
        while (q!=end&&q.next!=end){
            s = s.next;
            q = q.next.next;
        }
        TreeNode root = new TreeNode(s.val);
        root.left = fun2(start,s);
        root.right = fun2(s.next,end);
        return root;
    }
}
