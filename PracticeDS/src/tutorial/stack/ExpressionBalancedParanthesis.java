package tutorial.stack;

public class ExpressionBalancedParanthesis extends CharStack{

	private boolean isMatchingPair(char character1, char character2){
		if(character1 == '(' && character2 == ')')
			return true;
		else if(character1 == '[' && character2 == ']')
			return true;
		else if(character1 == '{' && character2 == '}')
			return true;
		else 
			return false;
	}
	
	public boolean isValidExpression(String expression){
		int length = expression.length();
		int index = 0;
		while(index < length){
			char ch = expression.charAt(index);
			if(ch == '(' || ch == '[' || ch == '{'){
				push(ch);
			} else if(ch == ')' || ch == ']' || ch == '}'){
				if(top == null)
					return false;
				if(!isMatchingPair(pop(), ch))
					return false;
			}
			index++;
		}
		
		if(top == null)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		ExpressionBalancedParanthesis ex = new ExpressionBalancedParanthesis();
		String exp = "{[()]}";
		System.out.println("Is expression valid?:"+ex.isValidExpression(exp));
	}
}
