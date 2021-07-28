package preday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        List<Node> list = new ArrayList<>();
        List<Node> copy = new ArrayList<>();
        Node n = head;
        if(n!=null){
            list.add(n);
            copy.add(new Node(n.val));
            n = n.next;
        }
        for (int i = 0; i < copy.size(); i++) {
            if(i == copy.size()-1){
                copy.get(i).next = null;
            }else{
                copy.get(i).next = copy.get(i+1);
            }
            int randomIndex = getRandomIndex(list, list.get(i).random);
            if(randomIndex == -1){
                copy.get(i).random = null;
            }else{
                copy.get(i).random = copy.get(randomIndex);
            }
        }
        return copy.get(0);
    }

    public int getRandomIndex(List<Node> list,Node node){
        if(node == null){
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if(node == list.get(i)){
                return i;
            }
        }
        return -1;
    }

}
