package singlyLinkedList;

/**
 * 找到有环入口的元素，否则返回null
 */
public class Solution {

    public Node detectCycle(Node head) {
        Node faster = head;
        Node slower = head;
        while(faster!=null&&faster.next!=null){
            faster = faster.next.next;
            slower = slower.next;
            if(faster == slower){
                slower = head;
                while(true){
                    slower = slower.next;
                    faster = faster.next;
                    if(slower == faster){
                        return slower;
                    }
                }
            }
        }
        return null;
    }

}
