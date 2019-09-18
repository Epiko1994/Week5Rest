package facades;

import entities.Person;

import java.util.List;

public interface IPersonFacade {
        public Person addPerson(String fName, String lName, String phone);
        public Person deletePerson(int id);
        public Person getPerson(int id);
        public List<Person> getAllPersons();
        public Person editPerson(Person p);
}
