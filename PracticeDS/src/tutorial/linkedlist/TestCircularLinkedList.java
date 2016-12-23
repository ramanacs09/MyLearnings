package tutorial.linkedlist;

class CircularLinkedList{
	class Node{
		int element;
		Node next;
		
		Node(int data){
			this.element = data;
			this.next = null;
		}
	}
	
	Node headPtr;
	
	private Node createNewNode(int data){
		return new Node(data);
	}
	
	public void insert(int data){
		Node newNode = createNewNode(data);
		if(headPtr == null){
			newNode.next = newNode;
			headPtr = newNode;
		} else{
			Node temp = headPtr;
			while(temp.next != headPtr){
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = headPtr;
		}
	}
	
	public void print(){
		Node temp = headPtr;
		if(headPtr != null){
			do{
				System.out.print(temp.element+"-->");
				temp = temp.next;
			}while(temp != headPtr);
		}
		System.out.println();
	}
	
	public int length(){
		int length = 0;
		Node  temp = headPtr; 
		if(headPtr != null){
			while(temp.next != headPtr){
				++length;
				temp= temp.next;
				System.out.println(temp.element);
			}
		}
		return length;
	}
	
	
	public void splitLinkedListIntoTwoHalves(){
		Node curr = headPtr;
		if(headPtr != null){
			//while(curr)
		}
	}
}

public class TestCircularLinkedList {
	public static void main(String[] args) {
		CircularLinkedList ll = new CircularLinkedList();
		ll.insert(10);
		ll.insert(12);
		ll.insert(14);
		ll.insert(16);
		ll.insert(18);
		
		//ll.print();
		
		System.out.println("Length of linked list is:"+ll.length());
	}
}
