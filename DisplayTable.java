import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayTable {

    public static void displayTable(Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM APPLE WHERE ID BETWEEN 1 AND 6")) {
            System.out.println("Table Data:");
            System.out.println("ID   Size   Weight   Sweetness   Ripeness   Juiciness   Crunchiness");
            System.out.println("--------------------------------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("ID");
                double size = rs.getDouble("Size");
                double weight = rs.getDouble("Weight");
                double sweetness = rs.getDouble("Sweetness");
                double ripeness = rs.getDouble("Ripeness");
                double juiciness = rs.getDouble("Juiciness");
                double crunchiness = rs.getDouble("Crunchiness");
                System.out.printf("%-4d %-6.1f %-8.1f %-11.1f %-10.1f %-11.1f %-10.1f%n", id, size, weight, sweetness, ripeness, juiciness, crunchiness);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
