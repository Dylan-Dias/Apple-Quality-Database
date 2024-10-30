import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();

            // Check if the table exists before creating it
            if (!tableExists(conn, "APPLE")) {
                // Create the table with ID and attributes
                String createTableSQL = "CREATE TABLE APPLE (" +
                        "ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY," +
                        "Size DOUBLE," +
                        "Weight DOUBLE," +
                        "Sweetness DOUBLE," +
                        "Ripeness DOUBLE," +
                        "Juiciness DOUBLE," +
                        "Crunchiness DOUBLE)";

                // Execute the SQL query to create the table
                stmt.executeUpdate(createTableSQL);
                System.out.println("Table 'APPLE' created successfully.");
            } else {
                System.out.println("Table 'APPLE' already exists.");
            }

            // Close the statement
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean tableExists(Connection conn, String tableName) throws SQLException {
        // Check if the table exists in the database schema
        return conn.getMetaData().getTables(null, null, tableName.toUpperCase(), null).next();
    }
}

