package project.jdbc.dao.cityDao;

import project.jdbc.connection.ApplicationConnection;
import project.jdbc.models.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityImpl implements CityDao {

    private final ApplicationConnection applicationConnection = new ApplicationConnection();

    @Override
    public City findById(Integer id) throws SQLException {
        try (PreparedStatement statement = applicationConnection.getPrepareStatement
                ("SELECT * FROM city WHERE city_id=(?)")) {
            statement.setInt(1, id);
            statement.executeQuery();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            return new City(resultSet.getString("city_name"));
        }
    }
}
