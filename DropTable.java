import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable {
    public static void dropTable(Connection conn) {
        try {
            // Create a statement
            Statement stmt = conn.createStatement();

            // Drop the table if it exists
            stmt.executeUpdate("DROP TABLE APPLE");

            // Close the statement
            stmt.close();

            System.out.println("Table 'APPLE' dropped successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
