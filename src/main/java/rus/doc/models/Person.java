package rus.doc.models;

import lombok.Data;

import javax.validation.constraints.*;


/**
 * Created by Vladislav Domaniewski
 */
@Data
public class Person {

    private int id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 3, max = 77, message = "Длина ФИО в пределах 3-77")
    private String name;

    @Min(value = 0, message = "Возвраст не может быть отрицательным")
    @Max(value = 101, message = "Возвраст не может быть больше")
    private int age;

    private String book;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
