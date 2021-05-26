package Top100;

import entity.TreeNode;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 */
public class No337 {

    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans = 0;
        if(root.left!=null){
            ans += (rob(root.left.left)+rob(root.left.right));
        }
        if(root.right!=null){
            ans += (rob(root.right.left)+rob(root.right.right));
        }
        ans += root.val;
        int ans2 = rob(root.left) + rob(root.right);
        return Math.max(ans,ans2);
    }

    public int rob2(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }

    public int[] helper(TreeNode r){
        if(r == null) return new int[2];//边界条件，r为null时，跳出
        int[] left = helper(r.left);//对于以r.left为根的树，计算抢劫根节点(r.left)与不抢劫根节点可获得最大金额. left[0]则为不抢r.left可获得的最大金额,left[1]则为抢劫r.left可获得的最大金额  以下right[] 分析同理
        int[] right = helper(r.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);//计算不抢劫当前根节点可获得的最大金额(那么其左右子树可以随便抢)
        res[1] = r.val + left[0] + right[0];//计算若抢劫根节点可获得的最大金额(此时,其左右子树的根节点不能被抢)
        return res;
    }
}
