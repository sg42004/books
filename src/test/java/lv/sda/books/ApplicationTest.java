package lv.sda.books;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ApplicationTest {
    @Test
    public void findByIsbnTest() {
        Bookstore bs = new Bookstore("src\\main\\resources\\books.txt");
        assertEquals(true, bs.find("123123123AAA"));
    }

    @Test
    public void findByTitleTest(){
        Bookstore bs = new Bookstore("src\\main\\resources\\books.txt");
        assertEquals(true, bs.find("Latvija Zeme Daba Tauta: Ezeru katlienes"));
    }

    @Test
    public void addBookTest(){
        Bookstore bs = new Bookstore("src\\main\\resources\\books.txt");
        Book book = new Book("test1", "test1", "test1","test1",123,2012,"test1");
        int initialSize = bs.booksList.size();
        bs.addBook(book);
    }

}
