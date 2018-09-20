package singlyLinkedList;
/**
 * 单向链表反转
 * @author admin
 *
 */
public class LinkedReverse {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode temp1 = null;
		ListNode temp2 = null;
		ListNode result = head;
		while(head!=null&&head.next!=null) {
			temp1 = head.next;
			temp2 = head.next.next;
			temp1.next = result;
			head.next = temp2;
			result = temp1;
		}
		return result;
	}

}
