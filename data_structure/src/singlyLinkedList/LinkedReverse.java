package singlyLinkedList;

/**
 * 单向链表反转
 * 
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
	/**
	 * 反转链表
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		ListNode temp1 = null;
		ListNode temp2 = null;
		ListNode result = head;
		while (head != null && head.next != null) {
			temp1 = head.next;
			temp2 = head.next.next;
			temp1.next = result;
			head.next = temp2;
			result = temp1;
		}
		return result;
	}
	
	/**
	 * 移除链表中值为给定值的元素
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
		ListNode t1 = head;
		ListNode pre = null;
		ListNode result = head;
		while(t1!=null) {
			if(pre==null&&t1.val == val) {
				result = t1.next;
				t1.next = null;
				t1 = result;
			}else if(pre!=null&&t1.val == val){
				pre.next = t1.next;
				t1.next = null;
				t1 = pre.next;
			}else{
				pre = t1;
				t1 = t1.next;
			}
		}
		return result;
	}

}
