package No18;

import entity.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class No94 {

    TreeMap<Integer,List<Integer>> map = new TreeMap<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        map.put(0,new ArrayList<Integer>(){{add(root.val);}});
        dfs(root,0,0);
        List<Integer> result = new ArrayList<>();
        for (Integer key : map.keySet()) {
            result.addAll(map.get(key));
        }
        return result;
    }

    public void dfs(TreeNode node,int left,int right){
        if(node == null){
            return;
        }
        TreeNode left_node = node.left;
        TreeNode right_node = node.right;
        if(left_node!=null){
            List<Integer> a = map.get(left - 1);
            if(a != null){
                a.add(left_node.val);
            }else{
                map.put(left-1,new ArrayList<Integer>(){{add(left_node.val);}});
            }
        }
        dfs(left_node,left-1,right-1);
        if(right_node!=null){
            List<Integer> b = map.get(right + 1);
            if(b!=null){
                b.add(right_node.val);
            }else{
                map.put(right+1,new ArrayList<Integer>(){{add(right_node.val);}});
            }
        }
        dfs(right_node,left+1,right+1);
    }

    //中序遍历使用栈结构
    public List<Integer> inorderTraversal2(TreeNode root) {
       List<Integer> list = new ArrayList<>();
       TreeNode curr = root;
       Deque<TreeNode> stack = new ArrayDeque<>();
       while(!stack.isEmpty()||curr!=null){
           if(curr!=null){
               stack.push(curr);
               curr = curr.left;
           }else{
               curr = stack.pop();
               list.add(curr.val);
               curr = curr.right;
           }
       }
       return list;
    }
}
