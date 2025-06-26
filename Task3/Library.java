import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    void issueBook(int index) {
        if (index < 1 || index > books.size()) {
            System.out.println("Invalid book number.");
            return;
        }

        Book book = books.get(index - 1);
        if (book.isIssued) {
            System.out.println("Book already issued.");
        } else {
            book.isIssued = true;
            System.out.println("Book issued: " + book.title);
        }
    }

    void returnBook(int index) {
        if (index < 1 || index > books.size()) {
            System.out.println("Invalid book number.");
            return;
        }

        Book book = books.get(index - 1);
        if (!book.isIssued) {
            System.out.println("Book was not issued.");
        } else {
            book.isIssued = false;
            System.out.println("Book returned: " + book.title);
        }
    }
}
