package lv.sda.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class Bookstore {

    private List<Book> books = new ArrayList<>();

    public Bookstore(){
        try {
            Path path = Paths.get("src/main/resources/books.txt");
            List<Book> books = Files.lines(path)
                    .map(line -> {
                        List<String> fields = Arrays.stream(line.split(";")).collect(toList());
                        return new Book(
                                fields.get(0),
                                fields.get(1),
                                fields.get(2),
                                fields.get(3),
                                Integer.parseInt(fields.get(4)),
                                Integer.parseInt(fields.get(5)),
                                fields.get(6)
                        );
                    })
                    .collect(Collectors.toList());
            this.books.addAll(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBook() {
        System.out.println("Input the following information");
        Scanner scanner = new Scanner(System.in);
        System.out.println("The isbn:");
        String isbn = scanner.nextLine();

        // klases class Car {
        //   String krasa; // mainigie jeb lauki kas veido datu struktūru
        //   String numurs;

        // }
        String text; // šī definīcija (vērtība ir null)
        text = "text"; // šī ir inicializācija (vērtība ir text)

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

        Book newBook = new Book(isbn, title, description, author, Integer.parseInt(pages), Integer.parseInt(year), publisher);
        books.add(newBook);
    }

    public void removeBook(String isbn){

    }

    public void getInfo() {
        System.out.println("Please insert ISBN of the book you are looking for: ");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (line.contains(isbn)) {
                System.out.println(line);
                break;
            } else {
                System.out.println("Book not found. Select options: ");
                System.out.println("Return to main menu -> type: 1 ");
                System.out.println("Quit bookstore -> type: q");
            }
        }
    }
    //print options what to do further with the book (buy yes/no)
        //System.out.println("Would you like to buy this book (yes/no): ");

        //search for book by isbn (String type)
        //if correct then print full info on book




        //if there is no such book -> print an options for further actions (type again/return to menu/q)
       // System.out.println("Unfortunately, at the moment we do not have this book in the store. ");



    public List<Book> searchBook() {
        System.out.println("Type title of the book you are looking for: ");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();
        List<Book> results = new ArrayList<>(); // iepirkumu grozs
        for (Book book: books) {
            if (book.getTitle().toLowerCase().contains(search.toLowerCase())){ // šeit jūs atrodat preci
                results.add(book);// jāieliek grozā
            }
        }

        if(results.isEmpty()){
            System.out.println("Unfortunately, there is no such book with title " + search);
        } else {
            System.out.println("Book has been found. Total there are " + results.size() + " books.");
        }

        return results; //kase, un ejat uz mājām
    }

/*    public static void searchBook(){
        System.out.println("Type title of the book");
        Scanner scanner = new Scanner(System.in);
        String searchForBook = scanner.nextLine();
        if()
    }*/

    public List<Book> allBooks(){
        System.out.println("Listing available books:");
        books.forEach(System.out::println);
        return books;
    }





}
