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

    List<Book> books;
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
            books.addAll(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            bw.newLine();
            bw.write(isbn + ", " + title + ", " + description + ", " + author + ", " + pages + ", " + year + ", " + publisher);
            bw.close();
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void removeBook(String isbn){

    }




    public static void getInfo() throws FileNotFoundException {
        System.out.println("Please insert ISBN of the book you are looking for: ");
        Scanner scanner = new Scanner(System.in);
        String isbn = scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (line.contains(isbn)) {
                System.out.println(line);
            }
        }
    }
    //print options what to do further with the book (buy yes/no)
        //System.out.println("Would you like to buy this book (yes/no): ");

        //search for book by isbn (String type)
        //if correct then print full info on book




        //if there is no such book -> print an options for further actions (type again/return to menu/q)
       // System.out.println("Unfortunately, at the moment we do not have this book in the store. ");



    public List<Book> searchBook(String query){
        System.out.println("Type name of the book you are looking for: ");

        return Collections.emptyList();
    }

    public static List<Book> allBooks(){
        System.out.println("Listing available books:");
        try {
            File myObj = new File("src/main/resources/books.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


}
