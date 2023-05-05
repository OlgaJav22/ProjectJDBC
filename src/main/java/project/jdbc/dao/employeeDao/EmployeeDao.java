package project.jdbc.dao.employeeDao;

import project.jdbc.models.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
//    Employee findById(Integer id) throws SQLException;
//
//    void hireNewEmployee(String lastName, String firstName, Integer age, Integer citiId) throws SQLException;
//
//    void refactorEmployee(Integer id, String lastName, String firstName, Integer age, Integer citiId) throws SQLException;
//
//    void deleteEmployeeById(Integer id) throws SQLException;
//
//    List<Employee> allEmployees() throws SQLException;

    void create(Employee employee);

    Employee readById(int id);

    void updateAmount(Employee employee);

    void delete(Employee employee);
}
