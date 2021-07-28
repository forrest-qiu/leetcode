package preday;

import entity.TreeNode;

public class No671 {

    public int findSecondMinimumValue(TreeNode root) {

        return minVal(root,root.val);
    }

    public int minVal(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }
        if (root.val > val) {
            return root.val;
        }
        int l = minVal(root.left, val);
        int r = minVal(root.right, val);
        if (l > val && r > val) {
            return Math.min(l,r);
        }
        return Math.max(l,r);
    }
}
