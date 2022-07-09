package rus.doc.models;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * Created by Vladislav Domaniewski
 */
@Data
public class Person {
    private int id;
    @NotEmpty(message = "Field can't empty")
    @Size(min = 0, max = 27, message = "Length name should be in 2-27 characters!")
    private String name;

    @Min(value = 0, message = "Age started with 0!")
    private int age;

    @NotEmpty(message = "Field can't empty!")
    @Email
    private String email;

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Person() {
    }
}
