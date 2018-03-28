package org.jac.java.v8.features;

public class LambdaExample {

	public static void main (String[] args) {
		
		LambdaExample lambdaExp = new LambdaExample();
		
		MathOperation subtraction = (int a, int b) -> a - b;
		int substractResult = lambdaExp.operate(3, 4, subtraction);
		System.out.println(substractResult);
		
		MathOperation addition = (a, b) -> a + b;
		int addResult = lambdaExp.operate(4, 5, addition);
		System.out.println(addResult);
		
		MathOperation mutiple = (a, b) -> { return a * b;};
		int multiResult = mutiple.operation(7, 9);
		System.out.println(multiResult);
		GreetingService greeting = (name) -> System.out.println("Hello, " + name);
		greeting.sayMessage("Jennifer");
	}
	
	private int operate(int a, int b, MathOperation mathOperation){
		return mathOperation.operation(a, b);
	}

	interface MathOperation {
		int operation(int a, int b);
	}
	
	interface GreetingService {
		void sayMessage(String message);
	}
	
}

