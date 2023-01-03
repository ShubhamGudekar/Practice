package stack.tester;

import java.util.Scanner;

import stack.com.Customer;
import stack.custom_exception.StackException;
import stack.utils.*;

public class StackTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			StackInterface tempData = null;
			boolean fixedStackFlag = false, growableStackFlag = false, exitFlag = false;
			do {
				System.out.println("Options Available\n1.Fixed Stack\t\t2.Growable Stack");
				System.out.println("Note:Stack Selection Once Made Cannot be Changed Later");
				System.out.print("Your Choice : ");
				byte tempCoice = sc.nextByte();
				if (tempCoice == 1) {
					fixedStackFlag = true;
					tempData = new FixedStack();
				} else if (tempCoice == 2) {
					growableStackFlag = true;
					tempData = new GrowableStack();
				} else
					System.out.println("Inavlid Choice");
			} while (!fixedStackFlag && !growableStackFlag);
			if (fixedStackFlag)
				System.out.println("Fixed Stack Selected");
			else
				System.out.println("Growable Stack Selected");
			while (!exitFlag) {
				try {
					System.out.println("Options :1.Push\t\t2.Pop\t\t3.Display all\t\t0.Exit");
					System.out.print("Your Choice : ");
					switch (sc.nextInt()) {
					case 1:
						if(fixedStackFlag&&FixedStack.index>=FixedStack.STACK_SIZE)
							throw new StackException("Fixed Stack already Full Cant push more Elements");
						System.out.println("Push Selected ");
						System.out.print("Enter Customer_Id Customer_Name Customer_address : ");
						tempData.push(new Customer(sc.nextInt(), sc.next(), sc.nextLine()));
						break;

					case 2:
						tempData.pop();
						break;

					case 3:
						tempData.displayData();
						break;

					case 0:
						System.out.println("Tata Bye Bye");
						exitFlag = true;
						break;
						
					default:
						System.out.println("Invalid Choice");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}

}
