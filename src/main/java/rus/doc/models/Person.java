package rus.doc.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;


/**
 * Created by Vladislav Domaniewski
 */

@Entity
@Data
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 3, max = 77, message = "Длина ФИО в пределах 3-77")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Возвраст не может быть отрицательным")
    @Max(value = 101, message = "Возвраст не может быть больше")
    @Column(name = "age")
    private int age;

    @Column(name = "book")
    private String book;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
