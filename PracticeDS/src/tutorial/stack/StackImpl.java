package tutorial.stack;

class Stack {
	class Element {
		int data;
		Element next;

		Element(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Element top;

	private Element getNewElement(int data) {
		return new Element(data);
	}

	public boolean isEmpty(){
		return (top == null);
	}
	
	public void push(int data) {
		Element newElement = getNewElement(data);
		newElement.next = top;
		top = newElement;
	}

	public void printStack() {
		Element curr = top;
		while (curr != null) {
			if(curr == top){
				System.out.print("top-->");				
			}
			System.out.println("\t| " + curr.data+" |");
			System.out.println("\t------");
			curr = curr.next;
		}
	}
	
	public int pop(){
		if(top != null){			
			Element topElement = top;
			top = top.next;
			return topElement.data;
		} else{
			System.out.println("Stack is empty");
			return -1;
		}
	}
	private boolean isOperand(char ch){
		return (ch>='1' && ch<='9');
	}
	
	public int evaluatePostfixExpression(String expression){
		int length = expression.length();
		for(int i=0;i<length;i++){
			char ch = expression.charAt(i);
			if(isOperand(ch)){
				push(Integer.parseInt(ch+""));
			} else {
				switch(ch){
				case '+' : push(pop() + pop()); break;
				case '-' : push(pop() - pop()); break;
				case '*' : push(pop() * pop()); break;
				case '/' : push(pop() / pop()); break;
				}
			}
		}
		return top.data;
	}
}

public class StackImpl {
	public static void main(String[] args) {
		Stack stack = new Stack();
	/*	stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(13);
		stack.push(14);
		stack.push(15);

		stack.printStack();
		System.out.println("Popped element is :"+stack.pop());
		
		System.out.println("Stack after popping element is:");
		stack.printStack();
		
		System.out.println("Is stack empty?:"+stack.isEmpty());*/
		String expression ="231*+9-";
		int value = stack.evaluatePostfixExpression(expression);
		System.out.println(value);
	}
}
