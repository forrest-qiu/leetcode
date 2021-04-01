package No18;

import entity.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No24 {

    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            ListNode a = temp;
            ListNode b = temp.next;
            if(a!=null&&b!=null){
                if(b.next!=null){
                    a.next = b.next;
                }else{
                    a.next = null;
                }
                b.next = a;
            }
            temp = temp.next;
            if(temp == null){
                break;
            }
        }
        return head.next;
    }


    @Test
    public void test(){
        //head = [1,2,3,4]
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(swapPairs(a));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode node : lists) {
            ListNode temp = node;
            while(temp!=null){
                list.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(list);
        if(list.size()==0){
            return null;
        }
        ListNode result = new ListNode(list.get(0));
        ListNode current = result;
        for (int i = 1; i < list.size(); i++) {
            ListNode temp = new ListNode(list.get(i));
            current.next = temp;
            current = temp;
        }
        return result;
    }

    @Test
    public void test2(){
        String x = "  test  aaa  ";
        System.out.println(x.trim());
    }

}
