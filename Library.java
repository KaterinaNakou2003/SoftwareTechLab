import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

class Library {

	private HashMap<Integer,Book> books;
	private int counter;

	public Library() {
        // Initialize the list of books
        this.books = new HashMap<>();
        this.counter = 0 ;
    }

	//returns 1 if succesfull, otherwise returns 0
	public int addBook() {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Please enter the title of the book:");
			String title = input.nextLine();
			System.out.println("Add the writer of the book:");
			String writer = input.nextLine();
			System.out.println("Add the year that the book was published of the book:");
			int publishYear = input.nextInt();
			input.nextLine();
			System.out.println("Add the summary of the book:");
			String summary = input.nextLine();
			counter++;
			int id = counter;
			Book book = new Book(title, writer, publishYear,summary);
			books.put(id,book);
			return 1;
		} catch (Exception e) {
            return 0;
        }
	}

	public void readBook(String title, String writer) {
		int bookId = findBook(title, writer);
		if (bookId == 0) {
			System.out.println("We could not find the book. Please try again!");
		} else {
			Book book = books.get(bookId);
			System.out.println("Title: " + book.getTitle());
			System.out.println("Author: " + book.getWriter());
			System.out.println("Year o the publishment: " + book.getYearPublished());
			System.out.println("Summary: " + book.getSummary());
		}
	}

	//returns 1 if succesfull, otherwise returns 0
	public int deleteBook(String title, String writer) {
		int bookId = findBook(title, writer);
		if (bookId == 0) {
			return 0;
		} else {
			books.remove(bookId);
			return 1;
		}
	}

	//returns 1 if succesfull, otherwise returns 0
	public int updateBook(String title, String writer) {
		Scanner input = new Scanner(System.in);
		int bookId = findBook(title, writer);
		if (bookId == 0) {
			return 0;
		} else {
			try {
				Book info = books.get(bookId);
				System.out.println("Do you want to change the title? yes/no");
				String answer = input.nextLine();
				if (answer == "yes") {
					System.out.println("Enter title!");
					title = input.nextLine();
					info.setTitle(title);
					books.put(bookId, info);
				}
				System.out.println("Do you want to change the author? yes/no");
				answer = input.nextLine();
				if (answer == "yes") {
					System.out.println("Enter author!");
					writer = input.nextLine();
					info.setWriter(writer);
					books.put(bookId, info);
				}
				System.out.println("Do you want to change the year of publishment? yes/no");
				answer = input.nextLine();
				if (answer == "yes") {
					System.out.println("Enter year!");
					int yearPublished = input.nextInt();
					info.setYearPublished(yearPublished);
					books.put(bookId, info);
				}
				System.out.println("Do you want to change the summary? yes/no");
				answer = input.nextLine();
				if (answer == "yes") {
					System.out.println("Enter summary!");
					String summary = input.nextLine();
					info.setSummary(summary);
					books.put(bookId, info);
				}
			} catch (Exception e) {
				return 0;
			}
			return 1;
		}

	}

	// returns bookId
	public int findBook(String title, String writer) {
		for (Map.Entry<Integer, Book> set :
		             books.entrySet()) {
			Book info = set.getValue();
			if (title != null) {
				if (info.getTitle().equals(title)) {
					return set.getKey();
				}
			} else if (writer != null) {
				if (info.getWriter().equals(writer)) {
					return set.getKey();
				}
			} else {
				return 0;
			}
		}
		return 0;
	}

}
