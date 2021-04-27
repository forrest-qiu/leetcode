package Tree;

import entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class No101 {
    boolean ans = true;
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> a = new ArrayList<>();
        a.add(root.left);
        a.add(root.right);
        if(!isMir(a)){
            return false;
        }
        list.add(a);
        fun(list);
        return ans;
    }

    public void fun(List<List<TreeNode>> list){
        List<TreeNode> nodes = list.get(list.size()-1);
        List<TreeNode> temp = new ArrayList<>();
        boolean allNullFlag = true;
        for (int i = 0; i < nodes.size(); i++) {
            temp.add(nodes.get(i) == null ? null:nodes.get(i).left);
            temp.add(nodes.get(i) == null ? null:nodes.get(i).right);
            if(nodes.get(i)!=null){
                allNullFlag = false;
            }
        }
        if(allNullFlag){
            return;
        }
        if(!isMir(temp)){
            ans = false;
            return;
        }
        list.add(temp);
        fun(list);
    }

    public boolean isMir(List<TreeNode> list){
        for (int i = 0; i < list.size() / 2; i++) {
            TreeNode a = list.get(list.size() - i - 1);
            TreeNode b = list.get(i);
            if(a==null&&b==null){
                continue;
            }else if(a==null||b==null){
                return false;
            }else if(a.val!=b.val){
                return false;
            }
        }
        return true;
    }


    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return false;
        }
        TreeNode p = root.left;
        TreeNode r = root.right;
        return check(p,r);
    }
    public boolean check(TreeNode a,TreeNode b){
        if(a == null && b == null){
            return true;
        }else if(a == null || b == null){
            return false;
        }else{
            return a.val == b.val && check(a.left,b.right) && check(a.right,b.left);
        }
    }



    @Test
    public void test(){
        //[1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(3);
        root.left = a1;
        a1.left = a3;
        a1.right = a4;
        root.right = a2;
        a2.left = a5;
        a2.right = a6;
        System.out.println(isSymmetric(root));
    }


}
