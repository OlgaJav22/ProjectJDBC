package project.jdbc.dao.cityDao;

import project.jdbc.models.City;

import java.util.List;

public interface CityDao {
//    City findById(Integer id) throws SQLException;

    void create(City city);

    City getById(int id);

    List<City> getAllCity();

    City updateCity(City city);

    Integer Add(City city);

    void  deleteCity(City city);
}
