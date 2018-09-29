package singlyLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 单向链表反转
 * 
 * @author admin
 *
 */
public class LinkedReverse {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 反转链表
	 * 
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
	 * 
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
		ListNode t1 = head;
		ListNode pre = null;
		ListNode result = head;
		while (t1 != null) {
			if (pre == null && t1.val == val) {
				result = t1.next;
				t1.next = null;
				t1 = result;
			} else if (pre != null && t1.val == val) {
				pre.next = t1.next;
				t1.next = null;
				t1 = pre.next;
			} else {
				pre = t1;
				t1 = t1.next;
			}
		}
		return result;
	}

	/**
	 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，
	 * 而不是节点的值的奇偶性。
	 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList(ListNode head) {
		
		if(head.next!=null&&head.next.next!=null) {
			ListNode temp1 = head;
			ListNode temp = null;
			while(temp1.next!=null&&temp1.next.next!=null) {
				ListNode pre = temp1.next;
				ListNode tempj = temp1.next.next;
				pre.next = tempj.next;
				temp = tempj.next;
				tempj.next = pre;
				temp1.next = tempj;
				temp1 = temp;
			}
		}
		return head;
	}

	/**
	 * 回文判断
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode head) {
		List<ListNode> list = new ArrayList<>();
		while(head!=null){
			list.add(head);
			head = head.next;
		}
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) != list.get(list.size()-1-i)){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(2);
		node1.next = node2;
		node2.next = node3;
		System.out.println(isPalindrome(node1));
	}

}
