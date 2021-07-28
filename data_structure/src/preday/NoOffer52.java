package preday;

import entity.ListNode;

import java.util.HashSet;
import java.util.Set;

public class NoOffer52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if(!set.add(headB)){
                return headB;
            }else{
                headB = headB.next;
            }
        }
        return null;
    }
}
