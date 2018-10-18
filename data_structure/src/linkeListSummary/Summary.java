package linkeListSummary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Summary {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		public Node() {
		}

		public Node(int _val, Node _prev, Node _next, Node _child) {
			val = _val;
			prev = _prev;
			next = _next;
			child = _child;
		}
	}
	
	
	class RandomListNode {
		     int label;
		     RandomListNode next, random;
		     RandomListNode(int x) { this.label = x; }
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
	 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储， 它们的每个节点只存储单个数字。将两数相加返回一个新的链表。 你可以假设除了数字 0
	 * 之外，这两个数字都不会以零开头。
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode temp = null;
		int j = 0;
		while (l1 != null || l2 != null) {
			int x = 0;
			if (l1 != null && l2 != null) {
				x = l1.val + l2.val + j;
			} else if (l1 != null && l2 == null) {
				x = l1.val + j;
			} else {
				x = l2.val + j;
			}
			if (x >= 10) {
				x = x - 10;
				j = 1;
			} else {
				j = 0;
			}
			ListNode temp2 = new ListNode(x);
			if (result == null) {
				result = temp2;
			} else {
				temp.next = temp2;
			}
			temp = temp2;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (j != 0) {
			ListNode temp2 = new ListNode(1);
			temp.next = temp2;
		}
		return result;
	}
	/**
	 * 将多级数组扁平化
	 * @param head
	 * @return
	 */
	public Node flatten(Node head) {
		Node result = head;
		while(head!=null) {   //3   //7    //8   //11
			Node child = head.child;   //7  //null   //11   //null
			Node masterNext = head.next;  //4   //8  //9 
			if(child!=null) {    //true   //false   //true  //false
				head.next = child;  // 3 -> 7  //8 -> 11
				child.prev = head;  // 3 <- 7  //8 <- 11
				head.child = null;
				while(true) {
					flatten(child);   //7  //11  
					if(child.next != null) {  // 8 != null   //true
						child = child.next;
					}else {
						break;
					}
				}
				if(masterNext!=null) {
					masterNext.prev = child;;
					child.next = masterNext;
				}
			}
			head = masterNext;   //   //8  //12
		}
		return result;
	}
	/**
	 * 给定一个链表，每个节点包含一个额外增加的随机指针，
	 * 该指针可以指向链表中的任何节点或空节点。要求返回这个链表的深度拷贝。
	 * @param head
	 * @return
	 */
	 public RandomListNode copyRandomList(RandomListNode head) {
		 RandomListNode temp = head;
		 RandomListNode temp1 = null;
		 while(temp!=null) {
			 temp1 = temp;
			 temp = temp.next;
			 RandomListNode copy_node = new RandomListNode(temp1.label);
			 copy_node.next = temp1.next;
			 temp1.next = copy_node;
		 }
		 //复制随机指针
		 temp = head;
		 while(temp!=null) {
			 RandomListNode random = temp.random;
			 temp.next.random = random;
			 temp = temp.next.next;
		 }
		 //拆分链表
		 temp = head;
		 RandomListNode result = head.next;
		 while(temp != null) {
			 RandomListNode temp_next = temp.next;
			 if(temp_next.next!=null) {
				 temp_next.next = temp_next.next.next;
			 }else {
				 temp_next.next  = null;
			 }
		 }
		 
		 return result;
     }

}
