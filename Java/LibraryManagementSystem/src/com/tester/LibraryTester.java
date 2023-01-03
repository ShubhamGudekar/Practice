package com.tester;

import static com.Utils.IOUtils.readLibDetails;
import static com.Utils.IOUtils.storeLibDetails;
import static com.Utils.LibraryUtils.displayBook;
import static com.Utils.LibraryUtils.findBookByAuthor;
import static com.Utils.LibraryUtils.findBookByCategoryAndAfterDate;
import static com.Utils.LibraryUtils.findBookByTitle;
import static com.Validations.LibraryValidations.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import com.customException.LibraryException;
import com.main.Book;

public class LibraryTester {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// populateMap();
		boolean adminFlag = false, readerFlag = false, exitFlag = false, loginFlag = false;
		while (!exitFlag) {
			try {
				Map<String, Book> libData = readLibDetails("LibraryData.ser");
				Book tempBook = null;
				System.out.print("Username Password : ");
				byte loggedInAs = login(sc.next(), sc.next());
				if (loggedInAs == 1) {
					System.out.println("Welcome Admin");
					adminFlag = true;
					loginFlag = true;
				}
				if (loggedInAs == 2) {
					System.out.println("Welcome Reader");
					readerFlag = true;
					loginFlag = true;
				}
				while (loginFlag) {
					System.out.println("Options - ");
					System.out.println("1.Add Book\t\t2.Display All Book");
					System.out.println("3.Issue Book\t\t4.Return Book");
					System.out.println("5.Remove Book\t\t6.Filter Books by Author Name");
					System.out.println("7.Filter Books by Category and after Publish Date");
					System.out.println("8.Logout\t\t9.Exit");
					System.out.print("Your Choice : ");
					try {
						switch (sc.nextInt()) {
						case 1:
							sc.nextLine();
							if (adminFlag) {
								System.out.print("Enter Book Name : ");
								String title = sc.nextLine();
								if (libData.containsKey(title)) {
									tempBook = libData.get(title);
									System.out
											.println("Book Already Present\nBook Qunatity :" + tempBook.getQuantity());
									System.out.print("Enter quantity to add : ");
									tempBook.setQuantity(tempBook.getQuantity() + sc.nextInt());
									System.out.println("Qunatity Updated : " + tempBook.getQuantity());
								} else {
									System.out.println("Enter Category Price Date(yyyy-mm-dd) Auther Quanity ");
									libData.put(title, new Book(title, validateCategory(sc.next()), sc.nextDouble(),
											LocalDate.parse(sc.next()), sc.next(), sc.nextInt()));
								}
							} else
								throw new LibraryException("Please Login as Admin ");
							break;

						case 2:
							displayBook(libData);
							break;

						case 3:
							sc.nextLine();
							if (readerFlag) {
								System.out.print("Enter Book Name : ");
								tempBook = findBookByTitle(sc.nextLine(), libData);
								System.out.println("Issued");
								tempBook.setQuantity(tempBook.getQuantity() - 1);
							} else
								throw new LibraryException("Please Login as Reader ");
							break;

						case 4:
							sc.nextLine();
							if (readerFlag) {
								System.out.print("Enter Book Name : ");
								tempBook = findBookByTitle(sc.nextLine(), libData);
								System.out.println("Returned");
								tempBook.setQuantity(tempBook.getQuantity() + 1);
							} else
								throw new LibraryException("Please Login as Reader ");
							break;

						case 5:
							sc.nextLine();
							if (adminFlag) {
								System.out.print("Enter Book Name : ");
								tempBook = libData.remove(sc.nextLine());
								if (tempBook == null)
									System.out.println("Book Not Found");
								else
									System.out.println("Removed " + tempBook);
							} else
								throw new LibraryException("Please Login as Admin ");
							break;

						case 6:
							sc.nextLine();
							if (readerFlag) {
								System.out.print("Author : ");
								findBookByAuthor(sc.nextLine(), libData);
							} else
								throw new LibraryException("Please Login as Reader ");
							break;

						case 7:
							sc.nextLine();
							if (readerFlag) {
								System.out.print("Enter Category Date(yyyy-mm-dd) : ");
								findBookByCategoryAndAfterDate(libData, sc.next(), LocalDate.parse(sc.next()));
							} else
								throw new LibraryException("Please Login as Reader ");
							break;

						case 8:
							System.out.println("Logged Out");
							loginFlag = false;
							adminFlag = false;
							readerFlag = false;
							break;

						case 9:
							storeLibDetails("LibraryData.ser", libData);
							System.out.println("Tata Bye");
							loginFlag = false;
							exitFlag = true;
							break;

						default:
							System.out.println("Inavlid Choice");

						}// switch
					} catch (Exception e) {
						e.printStackTrace();
					} // catch
				} // while
			} catch (Exception e) {
				e.printStackTrace();
				sc.nextLine();
			}
		}
		sc.close();
	}

}
