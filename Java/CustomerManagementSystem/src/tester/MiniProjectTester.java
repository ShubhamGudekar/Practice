package tester;

import static com.main.Customer.sdf;
import static com.utils.Validations.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.custom_exceptions.CustomerException;
import com.main.Customer;
import com.main.ServicePlan;
import static com.utils.CustomerUtils.*;

public class MiniProjectTester {
	
	public static void main(String[] args) throws ParseException {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exitFlag = false;
			ArrayList<Customer> custData = new ArrayList<Customer>();
			addEntries(custData);
			Customer tempCust = null;
			System.out.println("Options - ");
			System.out.println("1. Customer Registration\n2. Display details of all registered customers");
			System.out.println("3. Customer login\n4. Change Password\n5. Unsubscribe customer");
			System.out.println("6. Display names of the customers born between 2 specified dates.");
			System.out.println("7. Display all the customer details who have chosen specific plan");
			System.out.println("8. Upgrade Plan of Specific Customers with Specific Plan");
			while (!exitFlag) {
				try {
					System.out.print("Your Choice : ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Customer Registration Selected \nAvaliable Plans");
						displayPlanDetails();
						System.out.println("Enter name email password plan DateofBirth(dd-mm-yyyy)");
						tempCust = (validateData(sc.next(), sc.next(), sc.next(), sc.next(), sdf.parse(sc.next()),
								custData));
						custData.add(tempCust);
						System.out.println("Customer add successfully\nCustomer Id : " + tempCust.getId());
						break;

					case 2:
						if (custData.isEmpty())
							System.out.println("No Customers Registered");
						else {
							System.out.println("Customers Regitered - ");
							for (Customer c : custData)
								System.out.println(c);
						}
						break;

					case 3:
						System.out.print("Enter Email Password : ");
						tempCust = custLogin(sc.next(), sc.next(), custData);
						System.out.println("Customer Login Successfull");
						System.out.println("Your Details : " + tempCust);
						break;

					case 4:
						System.out.print("Enter Email OldPassword : ");
						tempCust = custLogin(sc.next(), sc.next(), custData);
						System.out.print("Enter newPassword : ");
						tempCust.setPassword(passwordValidation(sc.next()));
						System.out.println("Password Reset Successfully");
						break;

					case 5:
						System.out.print("Enter Customer Id : ");
						int tempCustId = sc.nextInt();
						boolean removeFlag = true;
						for (int i = 0; i < custData.size(); i++) {
							if (custData.get(i).getId() == tempCustId) {
								custData.remove(i);
								removeFlag = false;
								System.out.println("Customer Removed Successfully");
								break;
							}
						}
						if (removeFlag)
							throw new CustomerException("Customer Id not found");
						break;

					case 6:
						System.out.print("Enter StartDate(dd-mm-yyyy) EndDate(dd-mm-yyyy) ");
						Date startDate = sdf.parse(sc.next());
						Date endDate = sdf.parse(sc.next());
						for (Customer c : custData)
							if (c.getDateOfBirth().before(endDate) && c.getDateOfBirth().after(startDate))
								System.out.println(c);
						break;

					case 7:
						System.out.print("Enter plan to filter Customer : ");
						ServicePlan sp = planValidation(sc.next());
						for (Customer c : custData)
							if (c.getPlan().equals(sp))
								System.out.println(c);
						break;
						
					case 8:
						System.out.print("Enter oldServicePlan newServicePlan : ");
						updatePlan(custData, sc.next(), sc.next());
						System.out.println("Plan Updated Successfully");
						break;

					case 0:
						System.out.println("Tata Bye Bye");
						exitFlag = true;
						break;

					default:
						System.out.println("Invalid Choice");
					}// switch
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			} // while
		} // try with resources
	}
}
