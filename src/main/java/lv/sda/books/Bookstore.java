package lv.sda.books;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bookstore {

    public static void addBook() {
        System.out.println("Input the following information");
        Scanner scanner = new Scanner(System.in);
        System.out.println("The isbn:");
        String isbn = scanner.nextLine();
        System.out.println("The title:");
        String title = scanner.nextLine();
        System.out.println("The description:");
        String description = scanner.nextLine();
        System.out.println("The author:");
        String author = scanner.nextLine();
        System.out.println("The page count:");
        String pages = scanner.nextLine();
        System.out.println("The publishing year:");
        String year = scanner.nextLine();
        System.out.println("The publisher:");
        String publisher = scanner.nextLine();

        System.out.println("Adding the book");

        try {
            FileWriter fw = new FileWriter("src/main/resources/books.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(isbn + ", " + title + ", " + description + ", " + author + ", " + pages + ", " + year + ", " + publisher);
            bw.newLine();
            bw.close();
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void removeBook(String isbn){

    }

    public Book getInfo(String isbn){
        return null;
    }

    public List<Book> searchBook(String query){
        return Collections.emptyList();
    }

    public List<Book> allBooks(){
        return Collections.emptyList();
    }
}
