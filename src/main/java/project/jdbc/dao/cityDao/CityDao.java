package project.jdbc.dao.cityDao;

import project.jdbc.models.City;

import java.sql.SQLException;

public interface CityDao {
    City findById(Integer id) throws SQLException;
}
