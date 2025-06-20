import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void displayBook() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }
}

public class LibraryManagementSystem {

    // Linear search by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Binary search by title (assumes sorted array)
    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    // Display all books
    public static void displayBooks(Book[] books) {
        for (Book b : books) {
            b.displayBook();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "A Brief History of Time", "Stephen Hawking"),
            new Book(103, "The Hobbit", "J.R.R. Tolkien"),
            new Book(104, "1984", "George Orwell"),
            new Book(105, "To Kill a Mockingbird", "Harper Lee")
        };

        System.out.println("📚 Library Book List:");
        displayBooks(books);

        // Linear Search
        System.out.print("\n🔍 Linear Search - Enter title to search: ");
        String title = sc.nextLine();
        Book found = linearSearch(books, title);
        if (found != null) {
            System.out.println("✅ Book Found:");
            found.displayBook();
        } else {
            System.out.println("❌ Book not found.");
        }

        // Binary Search
        // Sort array by title before binary search
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.print("\n🔍 Binary Search - Enter title to search: ");
        title = sc.nextLine();
        found = binarySearch(books, title);
        if (found != null) {
            System.out.println("✅ Book Found:");
            found.displayBook();
        } else {
            System.out.println("❌ Book not found.");
        }

        sc.close();
    }
}
