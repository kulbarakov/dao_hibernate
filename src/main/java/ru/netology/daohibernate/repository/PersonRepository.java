package ru.netology.daohibernate.repository;

import org.springframework.stereotype.Repository;
import ru.netology.daohibernate.entity.City;
import ru.netology.daohibernate.entity.Person;
import ru.netology.daohibernate.entity.Profile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager manager;

    public List<Person> getPersonsByCity(String city) {
        Query query = manager.createQuery("select p from Person p where p.cityOfLiving.name = :city");
        query.setParameter("city", city);
        return query.getResultList();
    }

    @Transactional
    public void addDataToBase() {
        var cities = Stream.of("Астана", "Москва", "Байконур")
                .map(n -> City.builder()
                        .name(n)
                        .build()).toList();

        for (City entity : cities) {
            manager.persist(entity);
        }

        var names = List.of("Азамат", "Нурсултан", "Иван");

        var random = new Random();
        IntStream.range(0, 50)
                .forEach(i -> {
                    var person = Person.builder()
                            .profile(Profile.builder()
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(String.valueOf(random.nextInt(1000)))
                                    .age(random.nextInt(100)).build())
                            .phoneNumber("+77775554433")
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .build();
                    manager.persist(person);
                });
    }
}
