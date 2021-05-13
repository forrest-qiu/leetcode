package Top100;

import entity.TreeNode;
import org.junit.Test;

public class No129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
//        TreeNode root = new TreeNode(4);
//        TreeNode a = new TreeNode(9);
//        TreeNode b = new TreeNode(0);
//        TreeNode c = new TreeNode(5);
//        TreeNode d = new TreeNode(1);
//        root.left = a;
//        root.right = b;
//        a.left = c;
//        a.right = d;
        System.out.println(sumNumbers(root));
    }


}
