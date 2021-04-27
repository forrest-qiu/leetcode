package Tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No102 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<TreeNode>> node_list = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        node_list.add(list);
        fun(node_list);
        return result;
    }

    public void fun(List<List<TreeNode>> nodes){
        List<Integer> val = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> nodes1 = nodes.get(nodes.size() - 1);
        for (int i = 0; i < nodes1.size(); i++) {
            TreeNode node = nodes1.get(i);
            if(node!=null){
                val.add(node.val);
                list.add(node.left);
                list.add(node.right);
            }
        }
        if(list.isEmpty()){
            return;
        }
        result.add(val);
        nodes.add(list);
        fun(nodes);
    }
}
