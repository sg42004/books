package lv.sda.books;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class Bookstore {

    public List<Book> booksList = new ArrayList<>();
    public Bookstore() {
        readBooksFromFile("src\\main\\resources\\books.txt");
    }
//src/main/resources/books.txt
    public Bookstore(String file) {
        readBooksFromFile(file);
    }

    private void readBooksFromFile(String file) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));

            List<Book> books = lines.stream().map(line -> {
                List<String> fields = Arrays.asList(line.split(";"));
                return new Book(
                        fields.get(0),
                        fields.get(1),
                        fields.get(2),
                        fields.get(3),
                        Integer.parseInt(fields.get(4)),
                        Integer.parseInt(fields.get(5)),
                        fields.get(6)
                );
            }).collect(Collectors.toList());
            booksList.addAll(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printList(){
        System.out.println("Book list:");
        for (Book book : booksList){
            System.out.println(book);
        }
    }

    public void addBook(Book book) {
        boolean isDuplicate= false;
        for(int j = 0; j < booksList.size(); j++){
            if(!(book.getIsbn().equals(booksList.get(j).getIsbn()))){
            } else {
                isDuplicate = true;
                System.out.println("This book already exists!");
            }
        }
        if(!isDuplicate){
            booksList.add(book);
            System.out.println("Book successfully added to the bookstore.");
        }
    }

    public void removeBook(String isbn) {
        Book one = booksList.stream().filter
                (y -> y.getIsbn().equals(isbn)).findFirst().orElse(null);
        if (one != null) {
            booksList.remove(one);
            System.out.println("Book successfully removed from bookstore.");
        } else {
            System.out.println("There is no such book.");
        }
    }

    public boolean find(String query) {
        boolean found = booksList.stream()
                .filter(book -> book.toString().contains(query))
                .peek(System.out::println)
                .findAny()
                .isPresent();
        if (!found) {
            System.out.println("There is no book in the bookstore with given isbn.");
        }
        return found;
    }

    public void deleteFile(){
        File file = new File ("src\\main\\resources\\books.txt");
        file.delete();
    }

    public void saveToFile() {
        try {
            Path path = Paths.get("src\\main\\resources\\books.txt");
            Files.write(path, booksList.stream().map(Book::toString).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}