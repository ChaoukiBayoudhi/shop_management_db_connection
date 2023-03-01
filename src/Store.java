import java.net.ConnectException;
import java.sql.*;
import java.util.Set;

public class Store {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/shop_db", "user_lmad", "user_lmad");
    }
    public static void createTables() {
        Connection connection = null;
        try {
            //1- Create a connection
            connection = getConnection();
            //2-Write an SQL request
            String sqlRequest="CREATE TABLE IF NOT EXISTS products (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(255) not null, " +
                    "expiration_date DATE, " +
                    "price FLOAT, " +
                    "image BYTEA)";
            //3-create a statement
            PreparedStatement statement = connection.prepareStatement(sqlRequest);
            //4-Execute the statement
            statement.executeUpdate();
            System.out.println("Product Table created.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    connection.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }

}
