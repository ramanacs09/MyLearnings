package tutorial.queue;

class IntQueue{
	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	Node front, rear;
	
	private Node createQueueNode(int data){
		return new Node(data);
	}
	
	public void enqueue(int data){
		Node newNode = createQueueNode(data);
		if(rear == null){
			front = rear = newNode;
			return;
		}
		
		rear.next = newNode;
		rear = newNode;
	}
	
	public int dequeue(){
		if(front == null){
			System.out.println("Queue is empty");
			return -1;
		}
		
		if(front != rear){			
			Node currNode = front;
			front = front.next;
			return currNode.data;
		} else{
			System.out.println("No nodes in queue");
			return -1;
		}
	}
	
	public void printQueue(){
		Node front1 = front;
		Node rear1 = rear;
		while(front1 != rear1.next){
			System.out.print(front1.data+"  ");
			front1 = front1.next;
		}
		System.out.println();
	}
}

public class QueueImplementationUsingLinkedList {
	public static void main(String[] args) {
		IntQueue queue = new IntQueue();
		queue.enqueue(10);
		queue.enqueue(11);
		queue.enqueue(12);
		queue.enqueue(13);
		queue.enqueue(14);
		queue.enqueue(15);
				
		queue.printQueue();
		
		System.out.println(queue.dequeue());
		
		queue.printQueue();
	}
}
