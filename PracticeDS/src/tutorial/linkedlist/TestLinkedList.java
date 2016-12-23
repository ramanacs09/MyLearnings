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

	Node headPtr;

	private Node createNewNode(int data) {
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

	public Node getHeadPtr() {
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
		if (currPtr == null) {
			System.out.println("No key is present to delete");
			return;
		}
		// Delete the node in between the list
		prevNode.next = currPtr.next;

	}

	public void deleteNodeAtPosition(int pos) {
		int count = 0;
		Node currPtr = headPtr;
		if (pos == 0) {
			headPtr = currPtr.next;
			return;
		}
		while (currPtr != null && count < pos - 1) {
			count++;
			currPtr = currPtr.next;
		}

		currPtr.next = currPtr.next.next;
		return;
	}

	public int length() {
		int count = 0;
		Node currPtr = headPtr;
		while (currPtr != null) {
			++count;
			currPtr = currPtr.next;
		}
		return count;
	}

	public void swapNodesWithoutSwappingData(int firstItem, int lastItem) {
		Node currX = headPtr, currY = headPtr;
		Node prevX = null, prevY = null;
		if (firstItem == lastItem) {
			System.out.println("Data to be swapped are same");
			return;
		}
		while (currX != null && currX.data != firstItem) {
			prevX = currX;
			currX = currX.next;
		}

		if (currX == null) {
			System.out.println("First item is not found in the list");
			return;
		}

		while (currY != null && currY.data != lastItem) {
			prevY = currY;
			currY = currY.next;
		}

		if (currY == null) {
			System.out.println("Last item is not found in the list");
			return;
		}

		if (prevX != null) {
			prevX.next = currY;
		} else {
			headPtr = currY;
		}

		if (prevY != null) {
			prevY.next = currX;
		} else {
			headPtr = currX;
		}

		Node temp = currY.next;
		currY.next = currX.next;
		currX.next = temp;
	}

	public void reverseLinkedList() {
		Node currPtr = headPtr;
		Node prevPtr = null;
		Node nextPtr = null;
		while (currPtr != null) {
			nextPtr = currPtr.next;
			currPtr.next = prevPtr;
			prevPtr = currPtr;
			currPtr = nextPtr;
		}
		headPtr = prevPtr;
	}

	/*public Node reverse(Node head, Node last) {
		Node curr = head;
		Node prev = null;
		Node next = null;
		while (curr != last) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public void reverseInSets(int k) {
		Node curr = headPtr;
		Node last = null;
		Node temp = null;
		int count = 0;
		int length = length();
		
		
		while (curr != null && count < k) {
			count++;
			last = curr;
			curr = curr.next;
		}
	}
*/
	public Node reverseLinkedListInSets(Node head, int k) {
		Node curr = head;
		Node next = null;
		Node prev = null;
		int count = 0;
		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if (next != null) {
			head.next = reverseLinkedListInSets(next, k);
		}

		return prev;
	}
	
	public Node addTwoLinkedLists(LinkedList l1, LinkedList l2){
		Node head1 = l1.headPtr;
		Node head2 = l2.headPtr;
		Node prev = null;
		Node finalHead = null;
		Node tempPtr = null;
		int carry = 0;
		while(head1!= null || head2 != null){
			int sumValue = (head1 != null ? head1.data:0) + (head2 != null?head2.data:0) + carry;
			int value = sumValue % 10;
			carry = value /10;
			tempPtr = createNewNode(value);
			if(finalHead == null){
				finalHead = tempPtr;
			} else{
				prev.next = tempPtr;
			}
			prev = tempPtr;
			if(head1 != null){
				head1 = head1.next;
			}
			if(head2 != null){
				head2 = head2.next;
			}
		}
		
		if(carry > 0){
			tempPtr.next = createNewNode(carry);
		}
		return finalHead;
	}
	
}

public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(5);
		list.insert(6);
		list.insert(3);
		LinkedList list2 = new LinkedList();
		list2.insert(8);
		list2.insert(4);
		list2.insert(2);

		list.print();
		list2.print();
		
		LinkedList l3 = new LinkedList();
		l3.headPtr = list.addTwoLinkedLists(list, list2);
		l3.print();

		//list.headPtr = list.reverseLinkedListInSets(list.headPtr, 3);
		//list.print();

		/*
		 * list.reverseLinkedList(); list.print();
		 * System.out.println("The linked list length is:" + list.length());
		 * list.swapNodesWithoutSwappingData(14, 11); list.print();
		 * list.append(16); list.print(); list.deleteNodeAtPosition(6);
		 * list.print(); list.deleteNode(15); list.print();
		 */

	}
}
