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
	
	public boolean isEmpty(){
		return (top == null);
	}
	
	public void printStack(){
		Node curr = top;
		while(curr != null){
			System.out.print(curr.ch+"-->");
			curr = curr.next; 
		}
	}
	
	public boolean isOperand(char ch){
		return (ch>='a' && ch<='z') || (ch >= 'A' && ch <='Z');
	}
	
	public int precedence(char ch){
		switch(ch){
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
			
		case '^':
			return 3;
		}
		return -1;
	}
	
	public char pop(){
		if(top != null){			
			Node curr = top;
			top = top.next;
			return curr.ch;
		} else{
			return '$';
		}
	}
	
	public char peek(){
		/*char ch = '\u0000';
		if(top != null)
			return top.ch;
		return ch;*/
		return top.ch;
	}
}


public class InfixToPostfixImpl extends CharStack{
	
	public String convertInfixToPostfix(String expression){
		StringBuilder sb = new StringBuilder();
		int length = expression.length();
		for(int i=0;i<length;i++){
			char ch = expression.charAt(i);
			if(isOperand(ch)){
				sb.append(ch);
			} else if(ch == '('){
				push(ch);
			} else if(ch == ')'){
				while(!isEmpty() && peek() != '(')
					sb.append(pop());
				if(!isEmpty() && peek() != '(')
					return "Invalid";
				else
					pop();
			} else{
				while(!isEmpty() && precedence(ch) <= precedence(peek())){
					sb.append(pop());
				}
				push(ch);
			}
		}
		while(!isEmpty()){
			sb.append(pop());
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String expr = "a+b*(c^d-e)^(f+g*h)-i";
		InfixToPostfixImpl obj = new InfixToPostfixImpl();
		/*obj.push('a');
		obj.push('+');
		obj.push('b');*/
		String postfixExpr = obj.convertInfixToPostfix(expr);
		System.out.println(postfixExpr);
		
	}
}

