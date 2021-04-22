package model;

import java.util.StringJoiner;

public class Person {

    private String name;
    private String surname;

    public Person() {
        this("", "");
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        /*StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" ");
        sb.append(surname);*/
        //Umjesto gornje konstrukcije mozemo koristiti:
        return new StringJoiner(" ").add(name).add(surname).toString();
    }
}
