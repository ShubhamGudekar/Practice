package stack.utils;

import stack.com.Customer;

public interface StackInterface {
	int STACK_SIZE=5;
	
	void push(Customer custRef);
	
	void pop();
	
	void displayData();
	
}
