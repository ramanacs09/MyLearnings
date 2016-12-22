package tutorial.linkedlist;

class LinkedList {
	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	private Node headPtr;

	public Node createNewNode(int data) {
		return new Node(data);

	}

	public void insert(int data) {
		Node createdNode = createNewNode(data);
		createdNode.next = headPtr;
		headPtr = createdNode;
	}

	public void print() {
		Node currPtr = headPtr;
		while (currPtr != null) {
			System.out.print(currPtr.data + "-->");
			currPtr = currPtr.next;
		}
		System.out.print("NULL");
		System.out.println();
	}

	public Node getCurrPtrPosition() {
		return headPtr;
	}

	public void insertAfter(Node prevNode, int data) {
		if (prevNode == null) {
			System.out.println("Previous node cannot be null");
			return;
		}

		Node createdNode = createNewNode(data);
		createdNode.next = prevNode.next;
		prevNode.next = createdNode;
	}

	public void append(int data) {
		Node newNode = createNewNode(data);
		if (headPtr == null) {
			headPtr = newNode;
			return;
		}

		Node currPtr = headPtr;
		while (currPtr.next != null) {
			currPtr = currPtr.next;
		}
		currPtr.next = newNode;
		return;
	}

	public void deleteNode(int data) {
		Node currPtr = headPtr;
		Node prevNode = null;

		if (currPtr != null && currPtr.data == data) {
			headPtr = currPtr.next;
			return;
		}

		while (currPtr != null && currPtr.data != data) {
			prevNode = currPtr;
			currPtr = currPtr.next;
		}
		// This case occurs if the node to be deleted is headPtr
		if (currPtr == null){
			System.out.println("No key is present to delete");
			return;
		}
		// Delete the node in between the list
		prevNode.next = currPtr.next;

	}
	
	public void deleteNodeAtPosition(int pos){
		int count = 0;
		Node currPtr = headPtr;
		if(pos == 0){
			headPtr = currPtr.next;
			return;
		}
		while(currPtr != null && count < pos-1){
			count++;
			currPtr = currPtr.next;
		}
		
		currPtr.next = currPtr.next.next;
		return;
	}
	
	public int length(){
		int count = 0;
		Node currPtr = headPtr;
		while(currPtr != null){
			++count;
			currPtr = currPtr.next;
		}
		return count;
	}
	
	public void swapNodesWithoutSwappingData(int firstItem, int lastItem){
		Node currX = headPtr,currY = headPtr;
		Node prevX, prevY = null;
		if(firstItem == lastItem){
			System.out.println("Data to be swapped are same");
			return;
		}
		while(currX != null && currX.data != firstItem){
			prevX = currX;
			currX = currX.next;
		}
		
		if(currX == null){
			System.out.println("First item is not found in the list");
			return;
		}
		
		while(currY != null && currY.data != lastItem){
			prevY = currY;
			currY = currY.next;
		}
		
		if(currY == null){
			
		}
	}
}

public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(10);
		list.insert(11);
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);

		System.out.println(list.length());
		
		list.print();

		list.append(16);
		list.print();
		
		list.deleteNodeAtPosition(6);
		list.print();

		list.deleteNode(15);
		list.print();
	}
}
