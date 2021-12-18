package lv.sda.books;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try {

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

                    System.out.println("Input the following information");
                    System.out.println("The isbn:");
                    String isbn2 = scanner.nextLine();
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
                        bw.write(isbn2 + ", " + title + ", " + description + ", " + author + ", " + pages + ", " + year + ", " + publisher);
                        bw.newLine();
                        bw.close();
                        System.out.println("Book added successfully.");
                    } catch (Exception e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }

                    break;

                case "3":
                    System.out.println("Input isbn of the book to remove:");
                    scanner.nextLine();
                    System.out.println("Book removed successfully.");
                    break;
                case "4":
                    System.out.println("Getting book info");
                    System.out.println("Input isbn of the book to find:");
                    scanner.nextLine();
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


    /*
    viens no paņēmieniem, ielasīšanai no faila
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
                        fields.get(4),
                        Integer.parseInt(fields.get(5)),
                        LocalDate.of(Integer.parseInt(fields.get(6)), 1, 1)
                );
            })
            .collect(Collectors.toList());
    books.forEach(System.out::println);
} catch (Exception e) {
    e.printStackTrace();
}*/


}
