package project.jdbc.dao.cityDao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.jdbc.connection.ApplicationConnection;
import project.jdbc.connection.HibernateSessionFactoryUtil;
import project.jdbc.models.City;

import java.util.List;

public class CityImpl implements CityDao {

    private final ApplicationConnection applicationConnection = new ApplicationConnection();


    @Override
    public void create(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City getById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> getAllCity() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM City").list();
        }
    }

    @Override
    public City updateCity(City city) {
        City update;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            update = (City) session.merge(city);
            transaction.commit();
        }
        return update;
    }

    @Override
    public Integer Add(City city) {
        Integer id;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            id = (Integer) session.save(city);
            transaction.commit();
        }
        return id;
    }

    @Override
    public void  deleteCity (City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }

//    @Override
//    public City findById(Integer id) throws SQLException {
//        try (PreparedStatement statement = applicationConnection.getPrepareStatement
//                ("SELECT * FROM city WHERE city_id=(?)")) {
//            statement.setInt(1, id);
//            statement.executeQuery();
//
//            ResultSet resultSet = statement.getResultSet();
//            resultSet.next();
//            return new City(resultSet.getString("city_name"));
//        }
//    }

}