package lv.sda.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Bookstore {

    public void addBook(Book book) {

    }

    public void removeBook(String isbn){

    }

    public Book getInfo(String isbn) throws FileNotFoundException {
        System.out.println("Please insert ISBN of the book you are looking for: ");
        Scanner scanner = new Scanner(new File("src/main/resources/books.txt"));
        String isbnUser = scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine().toLowerCase(Locale.ROOT).toString();
            if (line.contains(isbnUser)) {
                System.out.println(line);
            }
        }

        //search for book by isbn (String type)
        //if correct then print full info on book


        //print options what to do further with the book (buy yes/no)
        System.out.println("Would you like to buy this book (yes/no): ");

        //if there is no such book -> print an options for further actions (type again/return to menu/q)
        System.out.println("Unfortunately, at the moment we do not have this book in the store. ");




        return null;
    }

    public List<Book> searchBook(String query){
        System.out.println("Type name of the book you are looking for: ");

        return Collections.emptyList();
    }

    public List<Book> allBooks(){
        return Collections.emptyList();
    }
}
