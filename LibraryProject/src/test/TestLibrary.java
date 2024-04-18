import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestLibrary {

    private Library library;
    private HashMap<Integer,Book> books = new HashMap<>();

    @Test
    public void setUp() {
        library = new Library();
        books.clear();
        Book bookie = new Book("Me before you", "Jojo Moyes",2012,"A dramatic love story.");
        System.out.println(books);
        books.put(1,bookie);
    }


    @Test
    public void testFindBookSuccess() {
        library = new Library();
        books.clear();
        Book bookie = new Book("Me before you", "Jojo Moyes",2012,"A dramatic love story.");
        System.out.println(books);
        books.put(1,bookie);;
        int actual = library.findBook(null, "Jojo Moyes");
        assertEquals(1, actual);
        actual = library.findBook("Me before you", null);
        assertEquals(1, actual);
    }

    @Test
    public void testFindBookFail() {
        library = new Library();
        books.clear();
        Book bookie = new Book("Me before you", "Jojo Moyes",2012,"A dramatic love story.");
        System.out.println(books);
        books.put(1,bookie);
        assertEquals(0, library.findBook("hihih", null));
        assertEquals(0, library.findBook(null, "hoho"));
    }

    @Test 
    public void testReadBook() {
        library = new Library();
        books.clear();
        Book bookie = new Book("Me before you", "Jojo Moyes",2012,"A dramatic love story.");
        System.out.println(books);
        books.put(1,bookie);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        library.readBook("Me before you", null);
        String output = "Title: Me before you\nAuthor: Jojo Moyes\nYear of the publishment: 2012\nSummary: A dramatic love story\n";
        assertEquals(output, out.toString());

        library.readBook(null, "Jojo Moyes");
        output = "Title: Me before you\nAuthor: Jojo Moyes\nYear of the publishment: 2012\nSummary: A dramatic love story\n";
        assertEquals(output, out.toString());

	}

    @Test
    public void testDeleteBook() {
        library = new Library();
        books.clear();
        Book bookie = new Book("Me before you", "Jojo Moyes",2012,"A dramatic love story.");
        System.out.println(books);
        books.put(1,bookie);
        assertEquals(1, library.deleteBook("Me before you", null));
        assertEquals(0, library.deleteBook("blahblahblah", null));
    }  

    @Test
	public void testAddBook() {
        library = new Library();
        String input = "Blah\nMe\n1897\nmoreblahhh\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int actual = library.addBook();
        assertEquals(1, actual);        
	}   


    @Test
    public void testUpdateBook() {
        library = new Library();
        books.clear();
        Book bookie = new Book("Me before you", "Jojo Moyes",2012,"A dramatic love story.");
        System.out.println(books);
        books.put(1,bookie);
        // Prepare input for simulating user interaction
        String input = "yes\nNew Title\nyes\nNew Author\nyes\n2020\nyes\nNew Summary\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int actual = library.updateBook("Me before you", null);
        assertEquals(1, actual);

        
        actual = library.updateBook(null, "New Author");
        assertEquals(1, actual);
        
    }

}
     