package tutorial.binarytree;

class BinaryTree{
	
	class Node{
		int data;
		Node left, right;
		
		public Node(int data){
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	Node root;
	
	
	private int calculateHeight(Node head){
		if(head == null)
			return 0;
		else{
			int lheight = calculateHeight(head.left);
			int rheight = calculateHeight(head.right);
			if(lheight > rheight){
				return (lheight+1);
			} else{
				return (rheight+1);
			}
		}
	}
	
	public void inorder(Node head){
		if(head == null){
			return;
		}
		inorder(head.left);
		System.out.print(head.data+" ");
		inorder(head.right);
	}
	
	public void preorder(Node head){
		if(head == null){
			return;
		}
		System.out.print(head.data+" ");
		preorder(head.left);
		preorder(head.right);
	}
	public void postorder(Node head){
		if(head == null){
			return;
		}
		postorder(head.left);
		postorder(head.right);
		System.out.print(head.data+" ");
	}
	
	public void levelOrder(Node head){
		int height = calculateHeight(head);
		for(int i=1;i<=height;i++){
			printGivenLevel(head, i);
		}
	}
	
	private void printGivenLevel(Node curr, int level){
		if(curr == null){
			return;
		}
		if(level == 1){
			System.out.print(curr.data+" ");
		} else if(level > 1){
			printGivenLevel(curr.left, level-1);
			printGivenLevel(curr.right, level-1);
		}
	}
	
	
}

public class BinaryTreeTraversalsDemo {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = bt.new Node(1);
		bt.root.left = bt.new Node(2);
		bt.root.right = bt.new Node(3);
		bt.root.left.left = bt.new Node(4);
		bt.root.left.right = bt.new Node(5);
		
		bt.inorder(bt.root);
		System.out.println();
		bt.preorder(bt.root);
		System.out.println();
		bt.postorder(bt.root);
		System.out.println();
		bt.levelOrder(bt.root);
	}
}
