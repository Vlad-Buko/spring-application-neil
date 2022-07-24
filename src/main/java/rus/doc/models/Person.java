package rus.doc.models;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;


/**
 * Created by Vladislav Domaniewski
 */

@Entity
@Data
@Table
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

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
