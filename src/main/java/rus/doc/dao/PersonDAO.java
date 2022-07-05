package rus.doc.dao;

import org.springframework.stereotype.Component;
import rus.doc.models.Person;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Vladislav Domaniewski
 */

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person personUpdated) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(personUpdated.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
