package tutorial.stack;

class CharStack{
	class Node{
		char ch;
		Node next;
		
		Node(char ch){
			this.ch = ch;
			this.next = null;
		}
	}
	
	Node top;
	private Node createNewElement(char ch){
		return new Node(ch);
	}
	
	public void push(char ch){
		Node newNode = createNewElement(ch);
		newNode.next = top;
		top = newNode;
	}
	
	public void printStack(){
		Node curr = top;
		while(curr != null){
			System.out.print(curr.ch+"-->");
			curr = curr.next; 
		}
	}
	
	public char peek(){
		char ch = '\u0000';
		if(top != null)
			return top.ch;
		return ch;
	}
}


public class InfixToPostfixImpl extends CharStack{
	
	public void convertInfixToPostfix(String expression){
		StringBuilder sb = new StringBuilder();
		int length = expression.length();
		for(int i=0;i<length;i++){
			char ch = (char) expression.indexOf(i);
			switch(ch){
			case '(':
				push(ch);
				break;
			case '*':
			case '/':
				push(ch);
				break;
			case '+':
			case '-':
				char topChar = peek();
				if(topChar == '*' || topChar == '/'){
					
				}
			
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
