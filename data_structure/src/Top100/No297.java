package Top100;

import entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No297 {

    public String serialize(TreeNode root) {
        if(root==null){
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> list  = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll);
                if(poll!=null){
                    queue.offer(poll.left);
                    if(poll.left==null){
                        count++;
                    }
                    queue.offer(poll.right);
                    if(poll.right==null){
                        count++;
                    }
                }
            }
            if(count == queue.size()){
                break;
            }
        }
        StringBuffer sb = new StringBuffer("[");
        for (TreeNode treeNode : list) {
            if(treeNode==null){
                sb.append("null");
            }else{
                sb.append(treeNode.val);
            }
            sb.append(",");
        }
        return sb.substring(0,sb.length()-1)+"]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==2){
            return null;
        }
        String[] nodes = data.substring(1,data.length()-1).split(",");
        Queue<TreeNode> curr = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        curr.offer(root);
        int i = 1;
        while(!curr.isEmpty()&&i<nodes.length){
            int size = curr.size();
            for (int j = 0; j < size; j++) {
                TreeNode poll = curr.poll();
                if(poll!=null){
                    if(i>=nodes.length){
                        break;
                    }
                    if("null".equals(nodes[i])){
                        poll.left = null;
                    }else{
                        poll.left = new TreeNode(Integer.valueOf(nodes[i]));
                    }
                    curr.offer(poll.left);
                    i++;
                    if(i>=nodes.length){
                        break;
                    }
                    if("null".equals(nodes[i])){
                        poll.right = null;
                    }else{
                        poll.right = new TreeNode(Integer.valueOf(nodes[i]));
                    }
                    curr.offer(poll.right);
                    i++;
                }
            }
        }
        return root;
    }

    @Test
    public void test(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = f;
//        String serialize = serialize(a);
//        System.out.println(serialize);
        System.out.println(deserialize("[1,2,3,null,null,4,5,6,7]"));
    }


}
