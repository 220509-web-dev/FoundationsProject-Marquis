package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Quizzard and Trello Reference

public class ConnectionUtil {

    private static ConnectionUtil instance;

    private ConnectionUtil() {}

    public static ConnectionUtil getInstance() {
        if (instance == null) {
            instance = new ConnectionUtil();
        }

        return instance;
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.err.println("Failed to load PostgreSQL Driver");
            throw new RuntimeException(e); // fail fast
        }
    }

    //getConnection - adam says "avoid hard coding credentials
    //May 26th Lesson-Video 2- 35:00

    public static Connection getConnection(){
        //colin explained that we could add the current schema
        //String dbInfo = "jdbc:postgresql://localhost/postgres?user=postgres&password=password&currentSchema=foundation_sql";
        try {
            String dbInfo = System.getenv("DB_Connection");
            Connection connection = DriverManager.getConnection(dbInfo);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}