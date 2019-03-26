import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import services.JPAServices;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("config", "services");
        JPAServices jpaServices = ctx.getBean(JPAServices.class);
        //Question 3
        jpaServices.save();
        jpaServices.findAll();
        System.out.println("ID 4 is deleted from Person");
        jpaServices.delete(4);
        jpaServices.findAll();
        System.out.println("Check Id 3 is present or not");
        System.out.println(jpaServices.checkPeople(3));
        jpaServices.count();

        /*Question 5*/
        System.out.println(jpaServices.findPersonByFirstName("Shivam"));
        System.out.println("\n");
        System.out.println(jpaServices.findPersonByLastName("Chaudhary"));
        System.out.println("\n");
        //System.out.println(jpaServices.findPersonBy Id(3));

        /*Question 6*/
        jpaServices.findFirstNameCustom(27);

        /*Question 7*/
        jpaServices.findFirstNameAndLastNameCustom(27);

        /*Question 8*/
        jpaServices.customFindAllPerson(27);

        /*Question 9*/
        Integer count = jpaServices.countByFirstName("Peter");
        System.out.println("Number of People from Peter Name is : " + count);

        /*Question 10*/
        Integer count1 = jpaServices.countByMethodOfPersonRepository("Peter");
        System.out.println("Number of People From Peter Name is : " + count1);

        System.out.println("This is distinct type");
        jpaServices.findDistinctPersonByName("Peter");

        System.out.println("This is through Name");
        jpaServices.findByFirstNameOrAge("Shivam", 34);
        System.out.println("\n");
        System.out.println("This is through Age");
        jpaServices.findByFirstNameOrAge("sdfaasd", 21);

        System.out.println("This is through And Method of Person");
        jpaServices.findByFirstNameAndAge("Shivam", 21);


        System.out.println("This is example of between");
        jpaServices.findByAgeBetween(20, 30);

        System.out.println("This is example of Less Than");
        jpaServices.findByAgeLessThan(27);

        System.out.println("This is example of Greater Than");
        jpaServices.findByAgeGreaterThan(27);


        System.out.println("This is example of Like Method");
        jpaServices.findByFirstNameLike("%S%");

        System.out.println("This is example of Not Method");
        jpaServices.findByFirstNameNot("Peter");

        System.out.println("This is example of In Method");
        jpaServices.findByAgeIn(Arrays.asList(23, 25, 27));

        System.out.println("This is example of Ignore Method");
        jpaServices.findByFirstNameIgnoreCase("shivam");

        /*Question 11 */
        System.out.println("This function print person greater than 25 and order by id in Descending order");
        jpaServices.findByAgeGreaterThanAndOrderByIdDesc(25);

        /*Question 12*/
        System.out.println("This is through Sort Class");
        jpaServices.findAll(25, new Sort(Sort.Direction.DESC, "id"));

        /*Question 13*/
        System.out.println("This is of Pageable type");
        jpaServices.findAll(new PageRequest(2, 3));
    }

}
