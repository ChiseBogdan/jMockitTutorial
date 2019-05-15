package domain;

import java.util.ArrayList;
import java.util.List;

public class Person {


    private String CNP;
    private String name;
    private int age;

    public Person(String CNP, String name, int age) {
        this.CNP = CNP;
        this.name = name;
        this.age = age;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
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
}
