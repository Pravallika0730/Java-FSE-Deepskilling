import java.util.Arrays;
import java.util.Scanner;

// Book class
class Book implements Comparable<Book> {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }

    // For binary search sorting (by title)
    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }
}

public class LibraryManagementSystem {

    // Linear Search: O(n)
    public static int linearSearch(Book[] books, String keyTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equalsIgnoreCase(keyTitle)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search: O(log n) - assumes books are sorted by title
    public static int binarySearch(Book[] books, String keyTitle) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(keyTitle);
            if (cmp == 0) return mid;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "To Kill a Mockingbird", "Harper Lee"),
            new Book(103, "1984", "George Orwell"),
            new Book(104, "Pride and Prejudice", "Jane Austen"),
            new Book(105, "The Great Gatsby", "F. Scott Fitzgerald")
        };

        System.out.print("Enter book title to search: ");
        String searchTitle = sc.nextLine();

        // Linear Search
        System.out.println("\n--- Linear Search ---");
        int indexLinear = linearSearch(books, searchTitle);
        if (indexLinear != -1) {
            System.out.println("Book found at index " + indexLinear + ":");
            books[indexLinear].display();
        } else {
            System.out.println("Book not found.");
        }

        // Sort array for binary search
        Arrays.sort(books);

        // Binary Search
        System.out.println("\n--- Binary Search ---");
        int indexBinary = binarySearch(books, searchTitle);
        if (indexBinary != -1) {
            System.out.println("Book found at index " + indexBinary + ":");
            books[indexBinary].display();
        } else {
            System.out.println("Book not found.");
        }

        // Analysis (in comments)
        /*
         * Linear Search:
         * - Time Complexity: O(n)
         * - Suitable for: small or unsorted datasets
         *
         * Binary Search:
         * - Time Complexity: O(log n)
         * - Suitable for: large and sorted datasets
         * 
         * 📌 If data is sorted and performance is important, use binary search.
         * 📌 If data is unsorted or changes frequently, linear search may be simpler.
         */

        sc.close();
    }
}
