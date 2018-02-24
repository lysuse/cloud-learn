package tech.youngstream.cloud.learn.java8.funct;

import tech.youngstream.cloud.learn.java8.model.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

//方法引用学习
public class AppFunc {

    //静态引用
    public static void staticRef() {
        System.out.println("================");

        System.out.println("static referee!");

        Person[] persons = Person.createRoster().toArray(new Person[]{});

        System.out.println("sort before: "+Arrays.toString(persons));

        Arrays.sort(persons,
                (a, b) -> Person.compareByAge(a, b)
        );

        System.out.println("sort after: "+Arrays.toString(persons));

    }


    //引用特定的示例方法 比如compare...
    public static void particularRef() {
        System.out.println("================");

        Person[] persons = Person.createRoster().toArray(new Person[]{});
        class ComparisonProvider {
            public int compareByName(Person a, Person b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(persons, myComparisonProvider::compareByName);
        System.out.println(Arrays.toString(persons));
    }

    //引用特定类型任意对象的实例方法
    public static void instanceMethodRef() {
        System.out.println("================");

        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };


        Arrays.sort(stringArray, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(stringArray));
    }

    //引用构造方法

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
        DEST transferElements(
                SOURCE sourceCollection,
                Supplier<DEST> collectionFactory) {
        DEST result = collectionFactory.get();
        for(T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public static void constructorRef() {
        System.out.println("================");
        Set<Person> rosterSet = transferElements(Person.createRoster(), HashSet<Person>::new);
        System.out.println(rosterSet);
    }


    public static void main(String[] args) {

        staticRef();

        particularRef();

        instanceMethodRef();

        constructorRef();
    }
}
