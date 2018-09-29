package linkeListSummary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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
	 * 合并有序（大小排序的）链表
	 * 输入：1->2->4, 1->3->4
	 * 输出：1->1->2->3->4->4
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		List<ListNode> set = new ArrayList<>();
		while(true) {
			if(l1!=null) {
				set.add(l1);
				l1 = l1.next;
			}
			if(l2!=null) {
				set.add(l2);
				l2 = l2.next;
			}
			if(l1 == null && l2 == null) {
				break;
			}
		}
		Collections.sort(set, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		for (int j = 0; j < set.size() -1; j++) {
			set.get(j).next = set.get(j+1);
		}
		if(set.isEmpty()) {
			return null;
		}
		return set.get(0);
	}
	
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(1);
		set.add(4);
		set.add(5);
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}

}
