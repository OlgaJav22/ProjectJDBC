package project.jdbc;

import project.jdbc.dao.cityDao.CityDao;
import project.jdbc.dao.cityDao.CityImpl;
import project.jdbc.dao.employeeDao.EmployeeDao;
import project.jdbc.dao.employeeDao.EmployeeImpl;
import project.jdbc.models.Employee;

import java.sql.SQLException;

public class Application {

    private static CityDao cityDao = new CityImpl();
    private static EmployeeDao employeeDao = new EmployeeImpl();

    public static void main(String[] args) throws SQLException {

//        System.out.println(cityDao.findById(1));
//        System.out.println(employeeDao.findById(3));
//        employeeDao.hireNewEmployee("Lovsin", "Lev", 19, 2);
//        employeeDao.refactorEmployee(5, "Лебедев", "Артем", 41, 3);
//        employeeDao.deleteEmployeeById(6);

//        for (Employee employee : employeeDao.allEmployees()) {
//            System.out.println(employee);
//        }

//        Employee employee1 = new Employee("Марина", "Пивоварова", 30, 1);
//        employeeDao.create(employee1);

        // Получаем объект по id
        System.out.println(employeeDao.readById(5));
    }
}
