package project.jdbc.models;

import java.util.Objects;

public class Employee {

    private String lastName;
    private String firstName;
    private Integer age;
    private City city;

    public Employee(String lastName, String firstName, Integer age, City city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(lastName, employee.lastName) && Objects.equals(firstName, employee.firstName) && Objects.equals(age, employee.age) && Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, age, city);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + ", возраст:" + age + " Город - " + city +".";
    }
}

