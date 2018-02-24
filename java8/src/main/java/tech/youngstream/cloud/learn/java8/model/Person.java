package tech.youngstream.cloud.learn.java8.model;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class Person {

    public enum Sex {
        MALE,FEMALE
    }

    String name;

    LocalDate birthday;

    Sex gender;

    String emailAddress;

    public Person() {
    }

    Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        return birthday
                .until(IsoChronology.INSTANCE.dateNow())
                .getYears();
    }

    public void printPerson() {
        System.out.println(name + ", " + this.getAge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static List<Person> createRoster() {

        List<Person> roster = new ArrayList<>();
        roster.add(new Person("Fred",
                IsoChronology.INSTANCE.date(1991,6, 20),
                Sex.MALE,
                "fred@example.com"
                ));
        roster.add(new Person("Jane",
                IsoChronology.INSTANCE.date(1992,7, 15),
                Sex.FEMALE,
                "jane@example.com"
        ));
        roster.add(new Person("George",
                IsoChronology.INSTANCE.date(1993,8, 13),
                Sex.MALE,
                "george@example.com"
        ));
        roster.add(new Person("Bob",
                IsoChronology.INSTANCE.date(2002,9, 12),
                Sex.MALE,
                "bob@example.com"
        ));
        return roster;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
