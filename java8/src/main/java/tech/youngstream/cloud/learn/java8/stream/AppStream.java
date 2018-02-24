package tech.youngstream.cloud.learn.java8.stream;

import tech.youngstream.cloud.learn.java8.model.Person;

public class AppStream {

    public static void main(String[] args) {
        long count = Person.createRoster()
                .stream()
                .filter(p -> p .getAge() < 25 && p.getGender() == Person.Sex.MALE)
                .peek(p -> System.out.println(p.toString()))
                .map(p -> p.getAge())
                .count();
        System.out.println(count);
    }

}
