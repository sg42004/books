package lv.sda.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Application {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        Bookstore bookstore = new Bookstore();
        try {
            Scanner s = new Scanner(new File("src/main/resources/books.txt"));
            ArrayList<String> list = new ArrayList<>();
            while (s.hasNextLine()) {
                list.add(s.nextLine());
            }
            s.close();

         //   System.out.println(list);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Search for a book");
            System.out.println("2. Add a book");
            System.out.println("3. Remove a book");
            System.out.println("4. Get book info");
            System.out.println("5. List available books");
            System.out.println("To quit press: q");

            String input = scanner.nextLine();

            if ("q".equalsIgnoreCase(input)) {
                System.out.println("Quitting application.");
                break;
            }

            switch (input) {
                case "1":
                    bookstore.searchBook();
                    break;
                case "2":
                    bookstore.addBook();
                    break;

                case "3":
                    System.out.println("Removing a book");
                    System.out.println("Provide isbn of the book to remove:");
                    scanner.nextLine();
                    System.out.println("Book removed successfully.");
                    break;
                case "4":
                    bookstore.getInfo();
                    break;
                case "5":
                    bookstore.allBooks();
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
            }

            System.out.println();
        }
    }



}
