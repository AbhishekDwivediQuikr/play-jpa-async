package Repository;

import models.Person;
import models.Vehicle;

import javax.persistence.*;
import java.util.List;


public class EmpRepo {

    // private static final String PERSISTENCE_UNIT_NAME = "defaultPersistenceUnit";

    private JPAUtility jpaUtility;


    public void save(Vehicle vehicle, EntityManager manager) {
        manager.persist(vehicle);
        throw new NullPointerException();
    }

    public void savePerson(Person person, EntityManager manager) {
        manager.persist(person);
    }


    public Person showPerson(Long id, EntityManager manager) {
        Person person = manager.find(Person.class, id);
        return person;
    }

    public void deleteVehicle(Long id, EntityManager manager) {
        Vehicle vehicle = manager.find(Vehicle.class, id);

        manager.getTransaction().begin();
        manager.remove(vehicle);
        manager.getTransaction().commit();
    }

    public List deletePerson(Long id, EntityManager manager) {
        Person person = manager.find(Person.class, id);
        manager.getTransaction().begin();
        manager.remove(person);
        manager.getTransaction().commit();
        List personlist = (manager.createNativeQuery("select * from person where id <= :id", Person.class).setParameter("id", id)).getResultList();
        return personlist;
    }

}

