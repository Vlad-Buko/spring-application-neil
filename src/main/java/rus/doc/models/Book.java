package rus.doc.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by Vladislav Domaniewski
 */

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 3, max = 77, message = "Длина названия книги в пределах 3-77")
    @Column(name = "name_book")
    private String nameBook;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 3, max = 77, message = "Длина имени автора в пределах 3-77")
    private String author;
    @Min(value = 1600, message = "Год не менее 1600")
    @Max(value = 2022, message = "Год не может быть больше чем сегодня")
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
