import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteRow {

    public static void deleteRow(Connection conn, Scanner scanner) {
        try {
            // Get the ID from the scanner
            System.out.print("Enter the ID of the row to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Create a statement
            Statement stmt = conn.createStatement();

            // Delete the row with the specified ID
            String deleteSQL = "DELETE FROM APPLE WHERE ID = " + id;
            int rowsDeleted = stmt.executeUpdate(deleteSQL);

            // Print the updated table regardless of whether a row was deleted or not
            System.out.println("Updated Table:");
            DisplayTable.displayTable(conn);

            // Check if any row was deleted
            if (rowsDeleted > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No row deleted.");
            }

            // Close the statement
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

