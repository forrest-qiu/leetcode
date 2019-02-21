package TwoWayLinkedList;
/**
 * 双向链表
 * @author admin
 *
 */
public class TowWayLinkedList {
    class DoublyListNode {
        int val;
        DoublyListNode next, prev;
        DoublyListNode(int x) {val = x;}
    }
    DoublyListNode first;
    DoublyListNode last;
    int size;
    public TowWayLinkedList() {
    	
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        DoublyListNode indexNode = getIndexNode(index);
        if(indexNode == null) {
        	return -1;
        }else {
        	return indexNode.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	DoublyListNode oldFirst = this.first;
    	DoublyListNode node = new DoublyListNode(val);
    	this.first = node;
    	if(oldFirst == null) {
    		this.last = node;
    	}else {
    		node.next = oldFirst;
    		oldFirst.prev = node;
    	}
    	this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	DoublyListNode oldLast = this.last;
    	DoublyListNode node = new DoublyListNode(val);
    	this.last = node;
    	if(oldLast == null) {
    		this.first = node;
    	}else {
    		node.prev = oldLast;
    		oldLast.next = node;
    	}
    	this.size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	if(index>this.size||index<0) {
    		return;
    	}
    	if(index == this.size) {
    		addAtTail(val);
    		return;
    	}else if(index == 0) {
    		addAtHead(val);
    		return;
    	}else {
    		DoublyListNode indexNode = getIndexNode(index);
    		DoublyListNode prev = indexNode.prev;
    		DoublyListNode node = new DoublyListNode(val);
    		prev.next = node;
    		node.prev = prev;
    		node.next = indexNode;
    		indexNode.prev = node;
    		this.size++;
    	}
    }
    
    private DoublyListNode getIndexNode(int index) {
    	if(index>=this.size||index<0) {
    		return null;
    	}
    	if(index==0) {
    		return this.first;
    	}
    	if(index == (this.size -1)) {
    		return this.last;
    	}
    	DoublyListNode node = this.first;
    	int i = 0;
        while(i<index&&node!=null){
            node = node.next;
            i++;
        }
    	return node;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	if(index>=this.size||index<0) {
    		return;
    	}
    	DoublyListNode indexNode = getIndexNode(index);
    	DoublyListNode prev = indexNode.prev;
    	DoublyListNode next = indexNode.next;
    	indexNode.prev = null;
    	indexNode.next = null;
    	if(prev!=null&&next!=null) {
    		prev.next = next;
    		next.prev = prev;
    	}else if(prev == null&&next!=null) {
    		this.first = next;
    		next.prev = null;
    	}else if(prev!=null && next==null) {
    		this.last = prev;
    		prev.next = null;
    	}else {
    		this.first = null;
    		this.last = null;
    		this.size = 0;
    		return;
    	}
    	this.size --;
    	
    }

	@Override
	public String toString() {
		DoublyListNode node = this.first;
		StringBuilder sb = new  StringBuilder("(");
		while(node!=null) {
			sb.append(node.val).append(",");
			node = node.next;
		}
		CharSequence subSequence = sb.subSequence(0, sb.length()-1);
		return subSequence+")";
	}
    
    
    

}
