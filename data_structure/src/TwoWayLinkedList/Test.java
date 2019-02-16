package TwoWayLinkedList;

public class Test {
	
	public static void main(String[] args) {
		TowWayLinkedList list = new TowWayLinkedList();
		System.out.println(list+"\t this size:"+list.size);
		list.addAtHead(1);
		System.out.println(list+"\t this size:"+list.size);
		list.addAtTail(3);
		System.out.println(list+"\t this size:"+list.size);
		
		list.addAtIndex(1,2);
		System.out.println(list+"\t this size:"+list.size);
		list.get(1);
		System.out.println(list+"\t this size:"+list.size+",value="+list.get(1));
		
		list.deleteAtIndex(1);
		System.out.println(list+"\t this size:"+list.size+",value="+list.get(1));
		
		list.addAtIndex(2,4);
		System.out.println(list+"\t this size:"+list.size+",value="+list.get(1));
		
		list.deleteAtIndex(1);
		System.out.println(list+"\t this size:"+list.size);
		list.deleteAtIndex(1);
		list.deleteAtIndex(1);
		System.out.println(list+"\t this size:"+list.size);
		hfdsjfklsd
	}
	
}
