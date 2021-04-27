package Tree;

import entity.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class No105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return build(preorder,0,preorder.length-1,0,preorder.length-1);
    }

    public TreeNode build(int[] preorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if(preorder_left>preorder_right){
            return null;
        }
        int root_index = map.get(preorder[preorder_left]);
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int left_size = root_index - inorder_left;
        root.left = build(preorder,preorder_left+1,preorder_left+left_size,inorder_left,root_index-1);
        root.right = build(preorder,preorder_left+left_size+1,preorder_right,root_index+1,inorder_right);
        return root;

    }

}
