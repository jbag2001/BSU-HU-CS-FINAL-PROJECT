import java.sql.Connection;
import java.sql.SQLException;

public class CheckDatabaseDriverSetup {

    public static void main(String[] args) {
        System.out.println("Attempting to connection to MySQL database using:");
        System.out.println(String.format("MYSQL_HOST: %s", System.getenv("CS310_HOST")));
        System.out.println(String.format("MYSQL_PORT: %s", System.getenv("CS310_PORT")));
        System.out.println(String.format("MYSQL_USERNAME: %s", System.getenv("CS310_USERNAME")));
        System.out.println(String.format("MYSQL_PASSWORD: %s", System.getenv("CS310_PASSWORD")));
        System.out.println(String.format("MYSQL_DATABASE: %s", System.getenv("CS310_DATABASE")));
        try{
            Connection connection = MySqlDatabase.getDatabaseConnection();
            System.out.println("Database connection SUCCESS!");
            connection.close();
        } catch (SQLException sql){
            System.out.println("Failed to connect to database! Please make sure your Environment variables are set!");
        }
    }
}
