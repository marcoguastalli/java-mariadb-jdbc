package robots;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import exception.RobotsRuntimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ConnectToMariaDB {

    private static final Logger logger = LogManager.getLogger(ConnectToMariaDB.class);
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db?useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "root123";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RobotsRuntimeException("Driver Error", e);
        }
        try (Connection conn = DriverManager.getConnection(url, user, password)){
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT * FROM bookmarks");

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                long id = rs.getLong("ID");
                String name = rs.getString("NAME");
                String lastName = rs.getString("URL");
            }
            stmt.close();
        } catch (SQLException e) {
            logger.error("SQL Error", e);
            throw new RobotsRuntimeException("SQL Error", e);
        }
    }
}
