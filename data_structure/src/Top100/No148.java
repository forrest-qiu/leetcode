package Top100;

import entity.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 */
public class No148 {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while(node!=null){
            list.add(node.val);
            node = node.next;
        }
        Collections.sort(list);
        ListNode ans = new ListNode(list.get(0));
        ListNode temp = ans;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return ans;
    }

}
