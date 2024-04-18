import java.util.Scanner;

class Handler {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Library library = new Library();
		boolean flag = true;
		while (flag) {
			System.out.println("Here is the menu!");
			System.out.println("1. Read book");
			System.out.println("2. Add a new book");
			System.out.println("3. Update a book");
			System.out.println("4. Delete a book");
			System.out.println("5. Exit");
			System.out.println("Please press a number!!");
			try{
				int action = input.nextInt();
				input.nextLine();
				if (action == 1) {
					System.out.println("Please enter the 1 to enter the title"
						+" or 2 to enter the writer of the book");
					int answer = input.nextInt();
					input.nextLine();
					if (answer == 1) {
						System.out.println("Please enter the title of the book:");
						String title = input.nextLine();
						library.readBook(title, null);
					} else if (answer == 2) {
						System.out.println("Please enter the writer of the book:");
						String writer = input.nextLine();
						library.readBook(null, writer);
					} else {
						System.out.println("There has been an error. Please try again!");
					}
				} else if (action == 2) {
					int ans = library.addBook();
					if (ans == 0) {
						System.out.println("We could not add the book. Please try again!");
					} else {
						System.out.println("Book is added to the library.");
					}
				} else if (action == 3) {
					System.out.println("Please enter the 1 to enter the title "
						+ " or 2 to enter the writer of the book you want to update");
					int nu = input.nextInt();
					input.nextLine();
					if (nu == 1) {
						System.out.println("Please enter the title of the book:");
						String title = input.nextLine();
						int id = library.updateBook(title, null);
						if (id == 0) {
							System.out.println("We could not update the book. Please try again!");
						} else {
							System.out.println("Book is updated succesfully.");
						}
					} else if (nu == 2) {
						System.out.println("Please enter the writer of the book:");
						String writer = input.nextLine();
						int id = library.updateBook( null, writer);
						if (id == 0) {
							System.out.println("We could not update the book. Please try again!");
						} else {
							System.out.println("Book is updated succesfully.");
						}
					} else {
						System.out.println("There has been an error. Please try again!");
					}
				} else if (action == 4) {
					System.out.println("Please enter the 1 to enter the title"
					+ " FOR or 2 to enter the writer of the book");
					int nu = input.nextInt();
					input.nextLine();
					if (nu == 1) {
						System.out.println("Please enter the title of the book:");
						String title = input.nextLine();
						if ( library.deleteBook(title, null) == 0) {
							System.out.println("Could not delete the book!");
						} else {
							System.out.println("Book deleted succesfully!");
					   }
					} else if (nu == 2) {
						System.out.println("Please enter the writer of the book:");
						String writer = input.nextLine();
						if ( library.deleteBook(null, writer) == 0) {
							System.out.println("Could not delete the book!");
						} else {
							System.out.println("Book deleted succesfully!");
						}
					} else {
						System.out.println("There has been an error. Please try again!");
					}
				} else if (action == 5) {
					flag = false;
					System.out.println("Exiting...");
				} else {
					System.out.println("There has been an error. Please try again!");
				}
			} catch (Exception e) {
				System.out.print("There has been a problem... Please try again!!" + e);
				input.nextLine();
			}
		}
		input.close();
	}
}