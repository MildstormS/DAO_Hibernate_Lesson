package ru.netology.daohibernateentitymanager.repository;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.netology.daohibernateentitymanager.entity.Person;
import ru.netology.daohibernateentitymanager.entity.PersonId;

import java.util.List;

@Repository
public class PersonRepository implements PersonStoragable {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {

        String qSqlString = "select p from Person p where p.cityOfLiving=:city_of_living";
        TypedQuery<Person> query = entityManager.createQuery(qSqlString, Person.class);
        query.setParameter("city_of_living", city).setMaxResults(5);

        return query.getResultList();
    }

    @Transactional
    public void checkAndFillForTest() {
        PersonId pKey = new PersonId("Ivan","Efremov",18);


        Person person = entityManager.find(Person.class, pKey);
        if (person == null) {
            Person newPerson = Person.builder()
                    .name("Ivan")
                    .surname("Efremov")
                    .age(18)
                    .phoneNumber("+79167542354")
                    .cityOfLiving("Moscow")
                    .build();
            entityManager.persist(newPerson);
        } else {
            System.out.println("Table have one or more rows");
        }
    }
}


