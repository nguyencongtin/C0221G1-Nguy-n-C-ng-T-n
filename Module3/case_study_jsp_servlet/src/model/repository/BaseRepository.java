package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    Connection connectDataBase() {
        final String URL = "jdbc:mysql://localhost:3306/case_study?useSSL=false";
        final String USER = "root";
        final String PASSWORD = "Huonguyen151197";
        Connection connection = null;
        try {
            // Khai báo Driver của mysql: không đổi
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
