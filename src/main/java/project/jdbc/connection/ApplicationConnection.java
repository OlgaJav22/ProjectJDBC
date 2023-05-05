package project.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationConnection {

    public PreparedStatement getPrepareStatement;

    private Connection getConnection () throws SQLException {
        String URL = "jdbc:postgresql://localhost:5432/postgres";
        String USSERNAME = "postgres";
        String PASSWORD = "Lelik1984";
        return DriverManager.getConnection(URL, USSERNAME, PASSWORD);

    }

    public PreparedStatement getPrepareStatement (String sgl) throws SQLException {
        return getConnection().prepareStatement(sgl);

    }
}
