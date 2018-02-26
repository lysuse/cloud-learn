package tech.youngstream.cloud.learn.java8.lambda;

import tech.youngstream.cloud.learn.java8.model.Person;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//lambda表达式学习
public class AppLambda {


    //方式1， 通过对比某个特征查找名单列表
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for(Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }


    //方式2，创建更加通用的搜索方法
    public static  void printPersonWithinAgeRange(List<Person> roster, int low, int high) {
        for(Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }


    //方式3，通过内部类指定查询条件查找名单列表
    interface CheckPerson {
        boolean test(Person p);
    }

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for(Person p : roster) {
            if(tester.test(p)) {
                p.printPerson();
            }
        }
    }

    static class CheckPersonEligibleForSelectiveService implements CheckPerson {
        @Override
        public boolean test(Person p) {
            return p.getGender() == Person.Sex.MALE &&
                    p.getAge() >= 18 &&
                    p.getAge() <= 25;
        }
    }

    //方式6， 使用标准的lambda函数接口

    public static void printPersonsWithPredicate(
            List<Person> roster,
            Predicate<Person> tester) {
        for(Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    //方式7 使用lambda表达式贯穿你的程序
    public static void processPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block) {
        for (Person p : roster) {
            if(tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    //方式8，使用泛型增加灵活性

    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for(X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();

        //方式3，通过内部类指定查询条件查找名单列表
        printPersons(roster, new CheckPersonEligibleForSelectiveService());
        System.out.println();
        //方式4， 通过匿名内部类指定
        printPersons(
                roster,
                new CheckPerson() {
                    @Override
                    public boolean test(Person p) {
                        return p.getGender() == Person.Sex.MALE &&
                                p.getAge() >= 18 &&
                                p.getAge() <= 25;
                    }
                });
        System.out.println();
        //方式5，通过lambda实现匿名条件代码
        printPersons(
                roster,
                (Person p) -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25);

        System.out.println();

        //方式6 使用标准的lambda函数接口
        printPersonsWithPredicate(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25);

        System.out.println();
        //方式7 使用lambda表达式贯穿你的程序
        //1. 固定指定匹配后的动作
        processPersons(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson());
        //2. 未固定匹配后的动作
        processPersonWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );

        //方式8，使用泛型增加灵活性
        processElements(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        //方式9， 使用接受lambda表达式作为参数的聚合操作
        roster
                .stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));

        Random random = new Random();
        //supplier使用
        Supplier<Person> personSupplier = () -> roster.get(random.nextInt(roster.size()));
        System.out.println(personSupplier.get().getAge());

        //Function使用
        Function<Person, Integer> ageFunction = Person::getAge;
        System.out.println(ageFunction.apply(personSupplier.get()));

        //Consumer使用
        Consumer<Person> personConsumer = (Person p) -> System.out.print(p.getAge());

        personConsumer.accept(personSupplier.get());
        System.out.println();
        System.out.println(2 % 4);
        System.out.println(2 & (4 - 1));

    }

}
