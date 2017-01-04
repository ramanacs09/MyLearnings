package tutorial.binarytree;

class Stack<T>{
	class Element{
		T data;
		Element next;
		
		public Element(T data){
			this.data = data;
			this.next = null;
		}
	}
	
	Element top;
	
	private Element constructNode(T data){
		return new Element(data);
	}
	
	public void push(T data){
		Element newNode = constructNode(data);
		newNode.next = top;
		top = newNode;
	}
	
	public T pop(){
		if(top == null){
			return null;
		} 
		Element curr = top;
		top = top.next;
		return curr.data;
	}
	
	public int size(){
		Element curr = top;
		int count = 0;
		while(curr != null){
			count++;
			curr = curr.next;
		}
		return count;
	}
}

public class BinaryTreeInOrderTraversalWithoutRecursion extends BinaryTree{

	public void implementationInorderWithoutRecursion(){
		Stack<Node> stackObj = new Stack<Node>();
		Node head = root; // assigning root pointer to head inorder to traverse
		if(head == null)
			return;
		
		while(head != null){
			stackObj.push(head);
			//System.out.print(head.data+" ");
			head = head.left;
		}
		
		//int stackSize = stackObj.size();
				
		while(stackObj.size() > 0){
			head = stackObj.pop();
			System.out.print(head.data+" ");
			if(head.right != null){
				head = head.right;
				
				while(head != null){
					stackObj.push(head);
					head = head.left;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeInOrderTraversalWithoutRecursion bt = new BinaryTreeInOrderTraversalWithoutRecursion();
		bt.root = bt.new Node(1);
		bt.root.left = bt.new Node(2);
		bt.root.right = bt.new Node(3);
		bt.root.left.left = bt.new Node(4);
		bt.root.left.right = bt.new Node(5);
		
		bt.implementationInorderWithoutRecursion();
	}
}
