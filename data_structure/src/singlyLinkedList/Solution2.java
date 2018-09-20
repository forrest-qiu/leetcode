package singlyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public Node  removeNthFromEnd(Node head,int n){
        List<Node> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        int nodeIndex = list.size()-n;
        Node node = list.get(nodeIndex);
        Node preNode = null;
        if(nodeIndex - 1>=0){
            preNode = list.get(nodeIndex-1);
        }
        Node nextNode = null;
        if(n>1){
            nextNode = list.get(nodeIndex+1);
        }
        if(preNode!=null){
            preNode.next = nextNode;
        }
        list.remove(nodeIndex);
        node.next = null;
        return list.get(0);
    }
}
