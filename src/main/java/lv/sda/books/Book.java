package lv.sda.books;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private String description;
    private String author;
    private int pages;
    private int publishingYear;
    private String publisher;

    public Book(int id, String isbn, String title, String description, String author, int pages, int publishingYear, String publisher) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.author = author;
        this.pages = pages;
        this.publishingYear = publishingYear;
        this.publisher = publisher;
    }

    public int getId() {return id; }

    public String getIsbn() {return isbn;}

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public Book setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }
}
