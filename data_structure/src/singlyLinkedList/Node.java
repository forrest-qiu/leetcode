package singlyLinkedList;
/**
 * 链表节点
 * @author admin
 *
 */

public class Node {
	
	int value;  //节点值
	
	Node next;  //节点下一个对象
	
	Node(int x){this.value = x;}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}  
	
	
}
