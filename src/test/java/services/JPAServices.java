package services;

import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repositories.PersonRepository;

import java.util.Iterator;
import java.util.List;

@Service
public class JPAServices {

    @Autowired
    PersonRepository personRepository;

    public void save() {
        Person person = new Person();
        person.setId(7);
        person.setFirstName("Peter");
        person.setLastName("Yadav");
        person.setAge(59);
        person.setSalary(200000);
        personRepository.save(person);
    }

    public void findAll() {
        Iterable<Person> iterable = personRepository.findAll();
        Iterator<Person> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void delete(int id) {
        personRepository.delete(id);
    }

    public boolean checkPeople(int id) {
        return personRepository.exists(id);
    }

    public void count() {
        System.out.println(personRepository.count());
    }

    /*Question 4*/
    public List<Person> findPersonByFirstName(String name) {
        return personRepository.findByFirstName(name);
    }

    public List<Person> findPersonByLastName(String name) {
        return personRepository.findByLastName(name);
    }

    public List<Person> findPersonById(int id) {
        return personRepository.findById(id);
    }

    /*Question 6*/
    public void findFirstNameCustom(Integer age) {
        List<Person> list = personRepository.customFindFirstName(age);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*Question 7*/
    public void findFirstNameAndLastNameCustom(Integer age) {
        List<Object[]> obj = personRepository.customFindFirstNameAndLastName(age);
        Iterator<Object[]> iterator = obj.iterator();
        while (iterator.hasNext()) {
            Object[] objects = iterator.next();
            System.out.println(objects[0] + " " + objects[1]);
        }
    }

    /*Question 8*/
    public void customFindAllPerson(Integer age) {
        List<Person> list = personRepository.customFindAll(age);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*Question 9*/
    public Integer countByFirstName(String fName) {
        Integer integer = personRepository.countByFirstName(fName);
        return integer;
    }

    /*Question 10*/
    public Integer countByMethodOfPersonRepository(String Name) {
        return personRepository.countPersonByFirstName(Name);
    }

    public void findDistinctPersonByName(String name) {
        List<Person> list = personRepository.findDistinctByFirstName(name);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void findByFirstNameOrAge(String name, Integer age) {
        List<Person> list = personRepository.findByFirstNameOrAge(name, age);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void findByFirstNameAndAge(String name, Integer age) {
        List<Person> list = personRepository.findByFirstNameAndAge(name, age);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void findByAgeBetween(int min, int max) {
        List<Person> list = personRepository.findByAgeBetween(min, max);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void findByAgeLessThan(int number) {
        List<Person> list = personRepository.findByAgeLessThan(number);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void findByAgeGreaterThan(int number) {
        List<Person> list = personRepository.findByAgeGreaterThan(number);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void findByFirstNameLike(String name) {
        List<Person> list = personRepository.findByFirstNameLike(name);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void findByFirstNameNot(String name) {
        List<Person> list = personRepository.findByFirstNameNot(name);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void findByAgeIn(List<Integer> agelist) {
        List<Person> list = personRepository.findByAgeIn(agelist);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void findByFirstNameIgnoreCase(String string) {
        List<Person> list = personRepository.findByFirstNameIgnoreCase(string);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*Question 11*/
    public void findByAgeGreaterThanAndOrderByIdDesc(Integer age) {
        List<Person> list = personRepository.findByAgeGreaterThanOrderByIdDesc(age);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*Question 12*/
    public void findAll(Integer age, Sort sort) {
        List<Person> list = personRepository.findAll(age, sort);
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*Question 13*/
    public void findAll(Pageable pageable) {
        Page<Person> page = personRepository.findAll(pageable);
        System.out.println(page.getContent());
    }

}
