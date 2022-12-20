package stack.utils;

import stack.com.Customer;
import stack.custom_exception.StackException;

public class FixedStack implements StackInterface {
	public static byte index;
	static {
		index = 0;
	}
	Customer[] fixedCustData = new Customer[STACK_SIZE];

	@Override
	public void push(Customer custRef) {
		try {
			if (index >= 0 && index < STACK_SIZE) {
				fixedCustData[index++] = custRef;
				System.out.println("Customer Details Added Successfully");
			} else
				throw new StackException("Fixed Stack already Full Cant push more Elements");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void pop() {
		try {
			if (index > 0) {
				System.out.println("Popped Customer : " + fixedCustData[index - 1]);
				fixedCustData[index-1] = null;
				index--;
				//if (index == -1)
					//index = 0;
			} else
				throw new StackException("Fixed Stack already Empty Cant pop more Elements");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void displayData() {
		if (index == 0)
			System.out.println("Stack is Empty");
		else {
			for (int i = STACK_SIZE-1; i >= 0; i--)
				if (fixedCustData[i] != null)
					System.out.println(fixedCustData[i]);
		}
	}
	
	
}
