package linkeListSummary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Summary {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 合并有序（大小排序的）链表 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		List<ListNode> set = new ArrayList<>();
		while (true) {
			if (l1 != null) {
				set.add(l1);
				l1 = l1.next;
			}
			if (l2 != null) {
				set.add(l2);
				l2 = l2.next;
			}
			if (l1 == null && l2 == null) {
				break;
			}
		}
		Collections.sort(set, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		for (int j = 0; j < set.size() - 1; j++) {
			set.get(j).next = set.get(j + 1);
		}
		if (set.isEmpty()) {
			return null;
		}
		return set.get(0);
	}
	
	/**
	 * 
		给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，
		它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
		你可以假设除了数字 0 之外，这两个数字都不会以零开头。
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode temp  = null;
		int j = 0;
		while(l1!=null||l2!=null) {
			int x = 0;
			if(l1!=null&&l2!=null) {
				x = l1.val + l2.val + j;
			}else if(l1!=null&&l2 == null) {
				x = l1.val+j;
			}else {
				x = l2.val+j;
			}
			if(x>=10) {
				x = x - 10;
				j = 1;
			}else {
				j = 0;
			}
			ListNode temp2 = new ListNode(x);
			if(result == null) {
				result = temp2;
			}else {
				temp.next = temp2;
			}
			temp = temp2;
			if(l1!=null) {
				l1 = l1.next;
			}
			if(l2!=null) {
				l2 = l2.next;
			}
		}
		if(j!=0) {
			ListNode temp2 = new ListNode(1);
			temp.next = temp2;
		}
		return result;
	}

	public static void main(String[] args) {
		
	}

}
