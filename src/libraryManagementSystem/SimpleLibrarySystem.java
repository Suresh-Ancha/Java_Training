package libraryManagementSystem;

import java.util.Scanner;

public class SimpleLibrarySystem {

	private static final int MAX_BOOKS = 20;
	private static final int MAX_PATTRONS = 10;
	private static String[] bookTitles = new String[MAX_BOOKS];
	private static String[] books = new String[MAX_BOOKS];
	private String[] authors = new String[MAX_BOOKS];
	private String[] patrons = new String[MAX_PATTRONS];
	private int bookCount=0;
	private int authorCount=0;
	private int patronsCount=0;
	private int availablebooksCount=0;
	private int barrowCount=0;
	private static String[] availableBooks = new String[MAX_BOOKS];
	private static String[] barrowbooks = new String[MAX_BOOKS];
	Scanner sc = new Scanner(System.in);

	public void addBooks(String title, String aut) {
		if (bookCount <= MAX_BOOKS) {
			if (bookCount == 0) {
				books[bookCount++] = title;
				availableBooks[availablebooksCount++] = title;
				authors[authorCount++] = aut;
				System.out.println("Book added Successfully");
			} else {
				if (!bookexist(title)) {
					books[bookCount++] = title;
					availableBooks[availablebooksCount++] = title;
					authors[authorCount++] = aut;
					System.out.println("Book added Successfully");
				} else {
					System.out.println("Book already exist");
				}
			}
		}
	}

	public void addPatrons(String user) {
		if (patronsCount <= MAX_PATTRONS) {
			if (patronsCount == 0) {
				patrons[patronsCount++] = user;
				System.out.println("patron added Successfully");
			} else {
				if (!patronsexist(user)) {
					patrons[patronsCount++] = user;
					System.out.println("patron added Successfully");
					System.out.println(" ");
				} else {
					System.out.println("patron already exist");
				}
			}
		}
	}

	public void barrowBooks(String title, String user) {
		if (availablebooksCount == 0) {
			System.out.println("No Books are available, Please add books into library...");
		} else {
			if (patronsexist(user)) {
				if (availableBooks(title)) {
					barrowbooks[barrowCount++] = title;
					System.out.println("Book borrowed Successfully");
					for (int i = 0; i < availablebooksCount; i++) {
						if (availableBooks[i].equalsIgnoreCase(title)) {
							for (int j = i; j < availableBooks.length - 1; j++) {
								availableBooks[j] = availableBooks[j + 1];
							}
							availablebooksCount--;
							break;
						}
					}
				} else {
					System.out.println("This book is not available ");
				}
			} else {
				System.out.println("patron doesnot exist");
			}

		}
	}

	public void returnBook(String title, String user) {
		if (bookexist(title)) {
			if (barrowBooks(title)) {
				availableBooks[availablebooksCount++] = title;
				System.out.println("Book returned Successfully");
				for (int i = 0; i < barrowCount; i++) {
					for (int j = i; j < barrowbooks.length - 1; j++) {
						barrowbooks[j] = barrowbooks[j + 1];
					}
					barrowCount--;
					break;
				}
			} else {
				System.out.println("This book is not yet borrowed");
			}
		} else {
			System.out.println("This book Invalid book");
		}
	}

	public boolean bookexist(String title) {
		for (int i = 0; i < bookCount; i++) {
			if (books[i].equalsIgnoreCase(title)) {
				return true;
			}
		}
		return false;
	}

	public boolean authorexist(String aut) {
		for (int i = 0; i < authorCount; i++) {
			if (authors[i].equalsIgnoreCase(aut)) {
				return true;
			}
		}
		return false;
	}

	public boolean patronsexist(String user) {
		for (int i = 0; i < patronsCount; i++) {
			if (patrons[i].equalsIgnoreCase(user)) {
				return true;
			}
		}
		return false;
	}

	public boolean availableBooks(String title) {
		for (int i = 0; i < availablebooksCount; i++) {
			if (availableBooks[i].equalsIgnoreCase(title)) {
				return true;
			}
		}
		return false;
	}

	public boolean barrowBooks(String title) {
		for (int i = 0; i < barrowCount; i++) {
			if (barrowbooks[i].equalsIgnoreCase(title)) {
				return true;
			}
		}
		return false;
	}

	public boolean bookcount()

	{

		if (bookCount == MAX_BOOKS) {

			return false;

		}

		return true;

	}

	public boolean patronscount()

	{

		if (patronsCount == MAX_PATTRONS) {

			return false;

		}

		return true;

	}
}