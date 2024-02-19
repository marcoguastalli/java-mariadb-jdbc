package robots;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import exception.RobotsRuntimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ConnectToMySql {

    private static final Logger logger = LogManager.getLogger(ConnectToMySql.class);
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/novo?useSSL=false";
        String user = "novo";
        String password = "novo123";
        try (Connection conn = DriverManager.getConnection(url, user, password)){
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT * FROM books");

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                long id = rs.getLong("BookID");
                String title = rs.getString("Title");
                logger.info(id + " " + title);
            }
            stmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("SQL Error", e);
            throw new RobotsRuntimeException("SQL Error", e);
        }
    }
}
