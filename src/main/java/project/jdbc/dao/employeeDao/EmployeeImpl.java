package project.jdbc.dao.employeeDao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.jdbc.connection.ApplicationConnection;
import project.jdbc.connection.HibernateSessionFactoryUtil;
import project.jdbc.dao.cityDao.CityDao;
import project.jdbc.dao.cityDao.CityImpl;
import project.jdbc.models.Employee;

public class EmployeeImpl implements EmployeeDao {

    private final ApplicationConnection applicationConnection = new ApplicationConnection();

    private final CityDao cityDao = new CityImpl();


    @Override
    public void create(Employee employee) {
        // В ресурсах блока try создаем объект сессии с помощью нашего конфиг-файла
        // И открываем сессию
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            // Создаем транзакцию и начинаем ее
            Transaction transaction = session.beginTransaction();
            // вызываем на объекте сессии метод save
            // данный метод внутри себя содержит необходимый запрос к базе
            // для создания новой строки
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee readById(int id) {
        // С помощью конфиг-файла получаем сессию, открываем ее
        // и через метод get получаем объект
        // В параметре метода get нужно указать объект какого класса нам нужен
        // и его id
        Employee employee = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
        return employee;
    }

    @Override
    public void updateAmount(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void delete(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            // Для удаления объекта из таблицы нужно передать его в метод delete
            session.delete(employee);
            transaction.commit();
        }
    }


//    @Override
//    public Employee findById(Integer id) throws SQLException {
//        try (PreparedStatement statement = applicationConnection.getPrepareStatement
//                ("SELECT * FROM employee WHERE employee_id=(?)")) {
//            statement.setInt(1, id);
//            statement.executeQuery();
//
//            ResultSet resultSet = statement.getResultSet();
//            resultSet.next();
//
//            return new Employee(resultSet.getString("last_name"),
//                    resultSet.getString("first_name"),
//                    resultSet.getInt("age"),
//                    cityDao.findById(resultSet.getInt("city_id")));
//        }
//    }
//
//    @Override
//    public void hireNewEmployee(String lastName, String firstName, Integer age, Integer citiId) throws SQLException {
//        try (PreparedStatement statement = applicationConnection.getPrepareStatement
//                ("INSERT INTO employee (last_name, first_name, age, city_id) VALUES (?,?,?,?)")) {
//            statement.setString(1, lastName);
//            statement.setString(2, firstName);
//            statement.setInt(3, age);
//            statement.setInt(4, citiId);
//            statement.executeUpdate();
//        }
//    }
//
//    @Override
//    public void refactorEmployee(Integer id, String lastName, String firstName, Integer age, Integer citiId) throws SQLException {
//        try (PreparedStatement statement = applicationConnection.getPrepareStatement
//                ("UPDATE employee SET last_name = ?, first_name = ?, age = ?, city_id = ? WHERE employee_id = (?)")) {
//            statement.setString(1, lastName);
//            statement.setString(2, firstName);
//            statement.setInt(3, age);
//            statement.setInt(4, citiId);
//            statement.setInt(5, id);
//            statement.executeUpdate();
//        }
//    }
//
//    @Override
//    public void deleteEmployeeById(Integer id) throws SQLException {
//        try (PreparedStatement statement = applicationConnection.getPrepareStatement
//                ("DELETE FROM employee WHERE employee_id = (?)")) {
//            statement.setInt(1, id);
//            statement.executeUpdate();
//        }
//    }
//
//    @Override
//    public List<Employee> allEmployees() throws SQLException {
//        try (PreparedStatement statement = applicationConnection.getPrepareStatement
//                ("SELECT * FROM employee")) {
//            statement.executeQuery();
//
//            ResultSet resultSet = statement.getResultSet();
//            List<Employee> employees = new ArrayList<>();
//            while (resultSet.next()) {
//                employees.add(new Employee(
//                        resultSet.getString("last_name"),
//                        resultSet.getString("first_name"),
//                        resultSet.getInt("age"),
//                        cityDao.findById(resultSet.getInt("city_id"))));
//            }
//            return employees;
//        }
//    }
}
