package singlyLinkedList;

public class MyLinkedList {
	
	private Node first;
	
	private Node last;
	
	private int size;
	
    public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/** Initialize your data structure here. */
    public MyLinkedList() {
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	Node node = getNode(index);
    	if(node == null) {
    		return -1;
    	}
    	return node.getValue();
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = this.first;
        if(this.first == null) {
        	this.last = node;
        }
        this.first = node;
        this.size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	 Node node = new Node(val);
    	 this.size++;
    	 if(this.last == null) {
    		 this.last = node;
    		 if(this.first == null) {
    			 this.first = node;
    		 }
    		 return;
    	 }
         this.last.next = node;
         this.last = node;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	if(index<0||index>this.size) {
    		return;
    	}
    	if(index == this.size) {
    		addAtTail(val);
    		return;
    	}
    	Node current_pre = getNode(index - 1);
    	Node current = getNode(index);
    	Node add = new Node(val);
    	if(current_pre == null) {
    		addAtHead(val);
    		return;
    	}
    	current_pre.next = add;
    	add.next = current;
    	this.size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
       if(index<0||index>=this.size) {
    	   return;
       }
       Node current = getNode(index);
       Node current_pre = getNode(index-1);
       if(current == null) {
    	   return;
       }
       Node current_next = getNode(index+1);
       if(current_next==null&&current_pre!=null) {
    	   this.last = current_pre;
    	   current_pre.next = null;
       }else if(current_pre==null&&current_next!=null){
    	   this.first = current_next;
    	   current.next = null;
       }else if(current_pre==null&&current_next==null){
    	   this.first = null;
    	   this.last = null;
       }else{
    	   current_pre.next = current_next;
    	   current.next = null;
       }
       this.size--;
    }
    
    private Node getNode(int index) {
    	if(index < 0 || index >= this.size) {
    		return null;
    	}
    	if(index == 0) {
    		return this.first;
    	}
    	if(index == (this.size - 1)) {
    		return this.last;
    	}
    	int i = 0;
    	Node node = this.first;
    	while(i<index) {
    		node = node.next;
    		i++;
    	}
    	return node;
    }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("MyLinkedList [");
		if(this.first == null) {
			return "null";
		}
		Node node = first;
		while(node!=null) {
			sb.append(node.getValue()+" ,");
			node = node.next;
		}
		String substring = sb.substring(0, sb.length()-1).trim();
		return substring.concat("]");
	}
    
    
    
}