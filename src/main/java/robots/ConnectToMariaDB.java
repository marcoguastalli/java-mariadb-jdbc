package robots;

import java.sql.Connection;
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
        //String url = "jdbc:mariadb://localhost:3306/novo?useSSL=false&allowPublicKeyRetrieval=true";
        String url = "jdbc:mariadb://localhost:3306/novo?useSSL=false";
        String user = "novo";
        String password = "novo123";
        Connection conn = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT * FROM books");

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                logger.info(rs.getString(1) + " " + rs.getString(2));
            }

            stmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("SQL Error", e);
            throw new RobotsRuntimeException("SQL Error", e);
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.error("Error close DDBB Connection", e);
            }
        }
    }

}
