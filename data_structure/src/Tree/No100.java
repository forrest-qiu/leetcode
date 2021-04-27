package Tree;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class No100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> a  = new ArrayList<>();
        List<Integer> b  = new ArrayList<>();
        fun(p,a);
        fun(q,b);
        if(a.size()!=b.size()){
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i)!=null){
                if(!a.get(i).equals(b.get(i))){
                    return false;
                }
            }else{
                if(b.get(i)!=null){
                    return false;
                }
            }
        }
        return true;
    }

    public void fun(TreeNode node,List<Integer> list){
        list.add(node==null?null:node.val);
        if(node!=null){
            fun(node.left,list);
            fun(node.right,list);
        }
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }else if(p.val!=q.val){
            return false;
        }else{
            return isSameTree2(p.left,q.left)&&isSameTree2(p.right,q.right);
        }
    }

}
