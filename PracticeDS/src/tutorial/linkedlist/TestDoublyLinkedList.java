package tutorial.linkedlist;

class DoublyLinkedList{
	class Node{
		int data;
		Node next;
		Node prev;
		
		Node(int data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	Node head;
	
	private Node createNewNode(int data){
		return new Node(data);
	}
	
	private Node getLastNode(){
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		return temp;
	}
	
	public void insert(int data){
		Node curr = null;
		Node newNode = createNewNode(data);
		if(head == null){
			head = newNode;
		} else{
			curr = getLastNode();
			curr.next = newNode;
			newNode.prev = curr;
			curr = newNode;
		}
	}
	public void print(){
		Node curr = head;
		while(curr != null){
			System.out.print(curr.data+"-->");
			curr = curr.next;
		}
		System.out.print("NULL");
		System.out.println();
	}
	
	public void printReverse(){
		Node last = getLastNode();
		while(last != null){
			System.out.print(last.data+"-->");
			last = last.prev;
		}
		System.out.print("NULL");
		System.out.println();
				
	}
	
	public void insertAtFront(int data){
		Node newNode = createNewNode(data);
		newNode.next = head;
		newNode.prev = null;
		if(head != null){			
			head.prev = newNode;
		} 
		head = newNode;
	}
	
	public void addAfterGivenNode(int data, int key){
		Node newNode = createNewNode(data);
		Node curr = head;
		Node previous = null;
		while(curr != null && curr.data != key){
			previous = curr;
			curr = curr.next;
		}
		previous = curr;
		curr = curr.next;
		previous.next = newNode;
		newNode.next = curr;
		newNode.prev = previous;
		curr.prev = newNode;
		
	}
}


public class TestDoublyLinkedList {
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insert(10);
		dll.insert(11);
		dll.insert(12);
		dll.insert(13);
		dll.insert(14);
		dll.insert(15);
		
		dll.print();
		dll.printReverse();
		
		dll.insertAtFront(9);
		dll.print();
		
		dll.addAfterGivenNode(20, 13);
		dll.print();
	}
}
