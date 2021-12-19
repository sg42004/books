package lv.sda.books;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

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

    public void addBook(Book book) {

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

    public List<Book> allBooks(){
        return Collections.emptyList();
    }


}
