package com.Utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import static com.Validations.LibraryValidations.*;
import com.customException.LibraryException;
import com.main.Book;
import com.main.Category;

public class LibraryUtils {

	public static HashMap<String, Book> populateMap() {
		HashMap<String, Book> libraryMap = new HashMap<String, Book>();
		libraryMap.putIfAbsent("Life of Pi",
				new Book("Life of Pi", Category.ACTION, 720, LocalDate.parse("2003-05-01"), "Yann Martel", 10));
		libraryMap.putIfAbsent("Watchmen",
				new Book("Watchmen", Category.NOVEL, 1000, LocalDate.parse("2019-05-20"), "Dave Gibbons", 10));
		libraryMap.putIfAbsent("The Night Fire ", new Book("The Night Fire ", Category.MYSTERY, 1200,
				LocalDate.parse("2018-10-22"), "Michael Connelly", 10));
		libraryMap.putIfAbsent("Circe",
				new Book("Circe", Category.NOVEL, 900, LocalDate.parse("2018-04-10"), "Madeline Miller", 10));
		libraryMap.putIfAbsent("The Savior",
				new Book("The Savior", Category.ROMMANCE, 1100, LocalDate.parse("2019-04-02"), "J.R. Ward", 10));
		return libraryMap;
	}

	public static void displayBook(Map<String, Book> bookData) {
//		for (Book b : bookData.values())
//			System.out.println(b);
		bookData.forEach((k,v)->System.out.println(v));
	}

	public static Book findBookByTitle(String title, Map<String, Book> mapData) throws LibraryException {
		Book tempBook = mapData.get(title);
		if (tempBook != null)
			return tempBook;
		throw new LibraryException("Book Not Found");
	}

	public static void findBookByAuthor(String author, Map<String, Book> mapData) {
		byte count = 0;
		for (Book tempBook : mapData.values()) {
			if (tempBook.getAuthorName().equals(author)) {
				System.out.println(tempBook);
				count++;
			}
		}
		System.out.println(count + " book found");

	}

	public static void findBookByCategoryAndAfterDate(Map<String, Book> mapData, String category,
			LocalDate publishDate) {
		byte count = 0;
		for (Book tempBook : mapData.values()) {
			if (tempBook.getCat().equals(validateCategory(category))
					&& tempBook.getPublishDate().isAfter(publishDate)) {
				System.out.println(tempBook);
				count++;
			}
		}
		System.out.println(count + " book found");
	}
}
