package tester;

import java.util.Scanner;
import static com.utils.DbUtils.*;

public class BackAccountTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			boolean exitFlag = false;
			double tempBal = 0;
			while (!exitFlag) {
				try {
					System.out.println("select option from below - ");
					System.out.println("1:Show All Accounts");
					System.out.println("2:Create New Account");
					System.out.println("3:update Name email for specific BankAccount");
					System.out.println("4:Delete BankAccount for specific BankAccount");
					System.out.println("5:WithDraw Amount for specific BankAccount");
					System.out.println("6:Deposite Amount for specific BankAccount");
					System.out.println("7:MoneyTransfer from one account into another account");
					System.out.println("8:Exit");
					System.out.print("Your Choice : ");

					switch (sc.nextInt()) {
					case 1:
						displayAcctDetails();
						break;

					case 2:
						System.out.println("enter name,email,balance,account-type - ");
						insertBankAccount(sc.next(), sc.next(), sc.nextDouble(), sc.next());
						break;

					case 3:
						System.out.println("1.Update Name\t2.Update Email");
						switch (sc.nextInt()) {
						case 1:
							System.out.print("Enter Acctno and New Name :");
							updateBankAccountName(sc.nextInt(), sc.next());
							break;

						case 2:
							System.out.print("Enter Acctno and New Email :");
							updateBankAccountEmail(sc.nextInt(), sc.next());
							break;
						}
						break;

					case 4:
						System.out.println("Enter Acctno. - ");
						deleteBankAccount(sc.nextInt());
						break;

					case 5:
						System.out.println("Enter Acctno. Amount - ");
						tempBal = withdrawBalance(sc.nextInt(), sc.nextDouble());
						System.out.println("Enter Y to display Balance or N to continue");
						if (sc.next().charAt(0) == 'Y' || sc.next().charAt(0) == 'y')
							System.out.println("Balance" + tempBal);
						break;

					case 6:
						System.out.println("Enter Acctno. Amount - ");
						tempBal = depositBalance(sc.nextInt(), sc.nextDouble());
						System.out.println("Enter Y to display Balance or N to continue");
						if (sc.next().charAt(0) == 'Y' || sc.next().charAt(0) == 'y')
							System.out.println("Balance" + tempBal);
						break;

					case 7:
						System.out.println("Enter Sender's Acctno.,Reciever's Acctno.,Amount - ");
						moneyTransfer(sc.nextInt(), sc.nextInt(), sc.nextDouble());
						break;

					case 8:
						System.out.println("Thank you!");
						exitFlag = false;
						break;

					}

				} catch (Exception e) {
					sc.nextLine();
					e.printStackTrace();
				}
			}
		}
	}
}
