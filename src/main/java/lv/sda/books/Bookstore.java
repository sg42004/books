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

    // Upload file to array list
    public List<Book> booksList = new ArrayList<>();

    public Bookstore() {
        readBooksFromFile("src\\main\\resources\\BookList.csv");
    }

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
                        fields.get(4),
                        Integer.parseInt(fields.get(5)),
                        Integer.parseInt(fields.get(6))
                );
            }).collect(Collectors.toList());
            booksList.addAll(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get book list
    public void printList(){
        System.out.println("Book list:");
        for (Book i : booksList){
            System.out.println(i);
        }
    }

    // Add book
    public void addBook(Book i) {
        boolean isDuplicate= false;
        for(int j = 0; j < booksList.size(); j++){
            if(!(i.getIsbn().equals(booksList.get(j).getIsbn()))){
            } else {
                isDuplicate = true;
                System.out.println("This book already exists!");
            }
        }
        if(!isDuplicate){
            booksList.add(i);
            System.out.println("Book successfully added to the database.");
        }
    }

    // Remove book
    public void removeBook(String isbn) {
        Book one = booksList.stream().filter
                (y -> y.getIsbn().equals(isbn)).findFirst().orElse(null);
        if (one != null) {
            booksList.remove(one);
            System.out.println("Book successfully removed from database.");
        } else {
            System.out.println("Record not found!");
        }
    }

    // Find book by isbn
    public boolean findByIsbn(String isbn) {
        boolean x = false;
        for (Book i : booksList) {
            if (i.getIsbn().equals(isbn)) {
                System.out.println(i);
                x = true;
            }
        }
        if (!x) {
            System.out.println("Record not found!");
        }
        return x;
    }

    // Find book by title
    public boolean findByTitle(String title) {
        boolean x = false;
        for(Book i : booksList){
            if(i.getTitle().equalsIgnoreCase(title)){
                System.out.println(i);
                x = true;
            }
        }
        if (!x){
            System.out.println("Record not found!");
        }
        return x;
    }

    // Save to file
    public void deleteFile()
            throws IOException{
        File file = new File("src\\main\\resources\\BookList.csv");
        file.delete();
    }

    public void saveData(String fileName, String text, boolean append )
            throws IOException{
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file, append);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(text);
        pw.close();
    }

    public void saveToFile() throws IOException {
        for(int i = 0; i < booksList.size(); i++){
            String dataToSave = booksList.get(i).getIsbn()
                    +";"+booksList.get(i).getTitle()
                    +";"+booksList.get(i).getAuthor()
                    +";"+booksList.get(i).getPublisher()
                    +";"+booksList.get(i).getGenre()
                    +";"+booksList.get(i).getPages()
                    +";"+booksList.get(i).getPublishingYear();

            saveData("src\\main\\resources\\BookList.csv", dataToSave,true);
        }
    }
}