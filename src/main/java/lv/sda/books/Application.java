package lv.sda.books;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello world!");
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
