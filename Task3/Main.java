import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added.");
                }
                case 2 -> library.showBooks();
                case 3 -> {
                    library.showBooks();
                    System.out.print("Enter book number to issue: ");
                    int index = Integer.parseInt(sc.nextLine());
                    library.issueBook(index);
                }
                case 4 -> {
                    library.showBooks();
                    System.out.print("Enter book number to return: ");
                    int index = Integer.parseInt(sc.nextLine());
                    library.returnBook(index);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}


