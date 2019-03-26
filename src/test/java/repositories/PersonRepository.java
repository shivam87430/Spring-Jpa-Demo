package repositories;

import entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findByFirstName(String name);

    List<Person> findByLastName(String name);

    List<Person> findById(int id);

    /*Question 6*/
    @Query("select firstName from Person where age=:age")
    List<Person> customFindFirstName(@Param("age") Integer age);

    /*Question 7*/
    @Query("select firstName,lastName from Person where age=:age")
    List<Object[]> customFindFirstNameAndLastName(@Param("age") Integer age);

    /*Question 8*/
    @Query("SELECT e from Person e where age=:age")
    List<Person> customFindAll(@Param("age") Integer age);

    /*Question 9*/
    @Query("SELECT COUNT(e) from Person e where firstName=:firstName")
    Integer countByFirstName(@Param("firstName") String firstName);

    /*Question 10*/
    int countPersonByFirstName(String fName);

    List<Person> findDistinctByFirstName(String name);

    List<Person> findByFirstNameOrAge(String fname, Integer age);

    List<Person> findByFirstNameAndAge(String fname, Integer age);

    List<Person> findByAgeBetween(int min, int max);

    List<Person> findByAgeLessThan(int number);

    List<Person> findByAgeGreaterThan(int number);

    List<Person> findByFirstNameLike(String name);

    List<Person> findByFirstNameNot(String name);

    List<Person> findByAgeIn(List<Integer> ageList);

    List<Person> findByFirstNameIgnoreCase(String name);

    /*Question 11*/
    List<Person> findByAgeGreaterThanOrderByIdDesc(Integer age);

    /*Queston 12*/
    @Query("select e from Person e where age>:age")
    List<Person> findAll(@Param("age") Integer age, Sort sort);

    /*Question 13*/
    Page<Person> findAll(Pageable pageable);
}

