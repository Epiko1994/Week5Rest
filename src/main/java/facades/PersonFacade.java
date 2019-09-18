package facades;

import entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade implements IPersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private PersonFacade() {}


    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getPersonCount(){
        EntityManager em = getEntityManager();
        try{
            long PersonCount = (long)em.createQuery("SELECT COUNT(p) FROM Person p").getSingleResult();
            return PersonCount;
        }finally{  
            em.close();
        }
        
    }

    @Override
    public Person addPerson(String fName, String lName, String phone) {
        return null;
    }

    @Override
    public Person deletePerson(int id) {
        return null;
    }

    @Override
    public Person getPerson(int id) {
        return null;
    }

    @Override
    public List<Person> getAllPersons() {
        EntityManager em = getEntityManager();
        try{
            return em.createNamedQuery("Person.getAllRows").getResultList();
        }finally{
            em.close();
        }
    }

    @Override
    public Person editPerson(Person p) {
        return null;
    }
}
