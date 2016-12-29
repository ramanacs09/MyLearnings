package tutorial.stack;

public class PrintNextGreatestElement extends Stack{
	
	public void printNextGreatestElement(int[] arr){
		int arrLength = arr.length;
		System.out.println("Next Greatest Elements");
		for(int i=0;i<arrLength;i++){
			if(i == 0){
				push(arr[i]);
			} else{
				int curr = arr[i];
				if(!isEmpty()){
					int currTop = pop();
					while( currTop < curr){
						System.out.println(curr+"----"+currTop);
						if(isEmpty())
							break;
						currTop = pop();
					}
					if(currTop > curr)
						push(currTop);
				}
			}
		}
		while(!isEmpty()){
			int curr = pop();
			int next = -1;
			System.out.println(curr+"----"+next);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {11,13,21,3};
		PrintNextGreatestElement png = new PrintNextGreatestElement();
		png.printNextGreatestElement(arr);
	}

}
