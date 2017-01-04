package tutorial.queue;

class QNode{
	int pageNumber;
	QNode previous, next;
	
	public QNode(int pageNumber){
		this.pageNumber = pageNumber;
		this.previous = this.next = null;
	}
	private QNode createNewQNode(int pageNumber){
		return new QNode(pageNumber); 
	}
}
class DLLQueue{
	
	
	int count; // Number o filled frames
	int numberOfFrames; // total number of frames;
	QNode front, rear;
	
	
	/*private void createQueue(int numberOfFrames){
		this.count = 0;
		this.numberOfFrames = numberOfFrames;
		this.front = this.rear = null;
	}*/
	
	public DLLQueue(int numberOfFrames){
		this.count = 0;
		this.numberOfFrames = numberOfFrames;
		this.front = this.rear = null;
	}
	
	public boolean areAllFramesFull(){
		return this.count == this.numberOfFrames;
	}
	
	public boolean isQueueEmpty(){
		return rear == null;
	}
	
	public void dequeue(){
		if(isQueueEmpty())
			return;
		if(front == rear){
			front = null;
		}
		
		QNode temp = rear;
	}
}

class Hash{
	int capacity;
	QNode[] array;
	
	public Hash(int capacity){
		this.capacity = capacity;
		array = new QNode[capacity];
	}
}

public class LRUCache {

	public static void main(String[] args) {
		
	}
}
