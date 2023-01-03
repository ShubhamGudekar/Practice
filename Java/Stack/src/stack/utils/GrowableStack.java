package stack.utils;

import java.util.ArrayList;

import stack.com.Customer;
import stack.custom_exception.StackException;

public class GrowableStack implements StackInterface {
	ArrayList<Customer> growableCustData = new ArrayList<Customer>();

	@Override
	public void push(Customer custRef) {
		growableCustData.add(custRef);

	}

	@Override
	public void pop() {
		try {
			if (growableCustData.isEmpty())
				throw new StackException("GrowableStack Already Empty Cant Pop Element");
			else
				System.out.println("Popped Customer : " + growableCustData.remove(growableCustData.size() - 1));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void displayData() {
		for (int i=growableCustData.size()-1;i>=0;i--)
			System.out.println(growableCustData.get(i));
	}
}
