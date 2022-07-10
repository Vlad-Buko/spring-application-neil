package rus.doc.models;

import lombok.Data;

/**
 * Created by Vladislav Domaniewski
 */

@Data
public class Book {
    private int id;
    private String nameBook;
    private String author;
    private int age;

    public Book(int id, String nameBook, String author, int age) {
        this.id = id;
        this.nameBook = nameBook;
        this.author = author;
        this.age = age;
    }

    public Book() {
    }
}
