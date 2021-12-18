package lv.sda.books;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Collections;

import static java.util.stream.Collectors.toList;

public class Application {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            Path path = Paths.get("src/main/resources/books.txt");
            List<Book> books = Files.lines(path)
                    .map(line -> {
                        List<String> fields = Arrays.stream(line.split(";")).collect(toList());
                         return new Book(
                                Integer.parseInt(fields.get(0)),
                                fields.get(1),
                                fields.get(2),
                                fields.get(3),
                                fields.get(4),
                                Integer.parseInt(fields.get(5)),
                                Integer.parseInt(fields.get(6)),
                                fields.get(7)
                                //LocalDate.of(Integer.parseInt(fields.get(6)), 1, 1),                        );
                        );
                    })
                    .collect(Collectors.toList());
                books.forEach(System.out::println);

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
                    System.out.println("Adding a book");
                    break;
                case "3":
                    System.out.println("Removing a book");
                    System.out.println("Provide isbn of the book to remove:");
                    scanner.nextLine();
                    break;
                case "4":
                    System.out.println("Getting book info");
                    break;
                case "5":
                    System.out.println("Listing available books:");
                    break;
                default:
                    System.out.println("Wrong input, please try again.");
            }

            System.out.println();
        }
    }




}
