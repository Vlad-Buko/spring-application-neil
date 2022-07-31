package rus.doc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import rus.doc.dao.PersonDAO;
import rus.doc.models.Person;

/**
 * Created by Vladislav Domaniewski
 */

@Component
public class ValidatorForPerson implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public ValidatorForPerson(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

//        if (personDAO.show(person.getName()) != null) {
//            errors.rejectValue("name", "", "Это имя использовано");
//        }
    }
}
