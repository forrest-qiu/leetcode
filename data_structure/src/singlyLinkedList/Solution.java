package singlyLinkedList;

import java.util.HashSet;

/**
 * 找到有环入口的元素，否则返回null
 */
public class Solution {

    public Node detectCycle(Node head) {
        HashSet<Node> hs = new HashSet<>();
        while(head!=null){
            if(!hs.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }

}
