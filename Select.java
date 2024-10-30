import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select {

    public static void selectData(Connection conn, Scanner scanner) {
        try {
            // Get user input for conditions
            System.out.print("Enter conditions for AND query (e.g., column1 = 'value' AND column2 > 5): ");
            String andConditions = scanner.nextLine();

            System.out.print("Enter conditions for OR query (e.g., column1 = 'value' OR column2 > 5): ");
            String orConditions = scanner.nextLine();

            // Create a statement for AND query
            Statement stmtAnd = conn.createStatement();

            // Select data based on user-defined conditions with AND
            String selectAndSQL = "SELECT * FROM APPLE WHERE " + andConditions;
            ResultSet rsAnd = stmtAnd.executeQuery(selectAndSQL);

            // Print the selected data for AND query
            System.out.println("Selected Data with AND:");
            printResultSet(rsAnd, 6); // Print only first 6 rows

            // Close resources for AND query
            rsAnd.close();
            stmtAnd.close();

            // Create a statement for OR query
            Statement stmtOr = conn.createStatement();

            // Select data based on user-defined conditions with OR
            String selectOrSQL = "SELECT * FROM APPLE WHERE " + orConditions;
            ResultSet rsOr = stmtOr.executeQuery(selectOrSQL);

            // Print the selected data for OR query
            System.out.println("Selected Data with OR:");
            printResultSet(rsOr, 6); // Print only first 6 rows

            // Close resources for OR query
            rsOr.close();
            stmtOr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printResultSet(ResultSet rs, int numRows) throws SQLException {
        int count = 0;
        while (rs.next() && count < numRows) {
            int id = rs.getInt("ID");
            double size = rs.getDouble("Size");
            double weight = rs.getDouble("Weight");
            double sweetness = rs.getDouble("Sweetness");
            double ripeness = rs.getDouble("Ripeness");
            double juiciness = rs.getDouble("Juiciness");
            double crunchiness = rs.getDouble("Crunchiness");
            System.out.printf("%-4d %-6.1f %-8.1f %-11.1f %-10.1f %-11.1f %-10.1f%n", id, size, weight, sweetness, ripeness, juiciness, crunchiness);
            count++;
        }
    }
}
