package Tree;

import entity.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 */
public class No106 {

    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return build(postorder,0,n-1,0,n-1);
    }

    public TreeNode build(int[] postorder,int postorder_left,int postorder_right,int inorder_left,int inorder_right){
        if(postorder_left>postorder_right){
            return null;
        }
        int root_val = postorder[postorder_right];
        int root_index = map.get(root_val);
        TreeNode root = new TreeNode(root_val);
        int left_len = root_index - inorder_left;
        root.left = build(postorder,postorder_left,postorder_left+left_len-1,inorder_left,root_index-1);
        root.right = build(postorder,postorder_left+left_len,postorder_right-1,root_index+1,inorder_right);
        return root;
    }


    @Test
    public void test(){
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder  = new int[]{9,15,7,20,3};
        System.out.println(buildTree(inorder,postorder));
    }

}
