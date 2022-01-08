package lv.sda.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
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

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
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
                    System.out.println("Searching for a book");
                    break;
                case "2":
                    Bookstore.addBook();
                    break;

                case "3":
                    System.out.println("Removing a book");
                    System.out.println("Provide isbn of the book to remove:");
                    scanner.nextLine();
                    System.out.println("Book removed successfully.");
                    break;
                case "4":
                    Bookstore.getInfo();
                    break;
                case "5":
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
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
            }

            System.out.println();
        }
    }



}
