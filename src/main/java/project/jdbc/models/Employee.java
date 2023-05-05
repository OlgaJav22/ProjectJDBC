package project.jdbc.models;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "city_id")
    private int city;

    public Employee() {

    }

    public Employee(int id, String lastName, String firstName, Integer age, int city) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
    }

    public Employee(String lastName, String firstName, Integer age, Integer city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
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

