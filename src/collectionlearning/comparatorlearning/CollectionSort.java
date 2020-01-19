package collectionlearning.comparatorlearning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 学习
 */
public class CollectionSort {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>() {
            {
                add(new Person("纬地", 25));
                add(new Person("崔汝童", 23));
                add(new Person("毛迎明", 26));
                add(new Person("方旭", 32));
                add(new Person("微微", 28));
            }
        };
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.compare(o1, o2);
            }
        });
        for (Person person : personList) {
            System.out.println("name = " + person.getName() + ",age = " + person.getAge());
        }
    }
}

class Person implements Comparator<Person> {

    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return (o1.getAge() - o2.getAge());
    }
}