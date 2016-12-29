package tutorial.queue;

class Queue{
	int[] arr;
	int front,rear;
	int capacity;
	
	Queue(){
		this.capacity = 10;
		arr = new int[capacity];
		front = rear = 0;
	}
	
	public void enqueue(int data){
		if(rear > capacity){
			System.out.println("Overflow occured");
			return;
		}		
		arr[rear++] = data;
	}
	
	public int dequeue(){
		if( rear < front){
			System.out.println("Underflow!!!");
			return -1;
		}
		return arr[front++];
	}
	public void printQueue(){
		for(int i=front;i<rear;i++){
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
	}
	
	public int sizeOfQueue(){
		return rear-front;
	}
}

public class QueueImplementationUsingArray {
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(11);
		queue.enqueue(12);
		queue.enqueue(13);
		queue.enqueue(14);
		queue.enqueue(15);
		
		queue.printQueue();
		System.out.println("The size of queue is :"+queue.sizeOfQueue());
		System.out.println("Dequeued element is:"+queue.dequeue());
		System.out.println("The size of queue is :"+queue.sizeOfQueue());
		queue.printQueue();
	}
}
