import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTable {

    public static void updateRow(Connection conn, Scanner scanner) {
        try {
            // Prompt the user for the row to update
            System.out.println("Enter the ID of the row to update:");
            int id = scanner.nextInt();

            // Prompt the user to input the new data
            System.out.println("Enter the new data for the row:");
            System.out.print("Size: ");
            double size = scanner.nextDouble();
            System.out.print("Weight: ");
            double weight = scanner.nextDouble();
            System.out.print("Sweetness: ");
            double sweetness = scanner.nextDouble();
            System.out.print("Ripeness: ");
            double ripeness = scanner.nextDouble();
            System.out.print("Juiciness: ");
            double juiciness = scanner.nextDouble();
            System.out.print("Crunchiness: ");
            double crunchiness = scanner.nextDouble();

            // Prepare the update statement
            String updateSQL = "UPDATE APPLE SET Size = ?, Weight = ?, Sweetness = ?, Ripeness = ?, Juiciness = ?, Crunchiness = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateSQL);
            pstmt.setDouble(1, size);
            pstmt.setDouble(2, weight);
            pstmt.setDouble(3, sweetness);
            pstmt.setDouble(4, ripeness);
            pstmt.setDouble(5, juiciness);
            pstmt.setDouble(6, crunchiness);
            pstmt.setInt(7, id);

            // Execute the update statement
            int rowsUpdated = pstmt.executeUpdate();

            // Print the updated table regardless of whether a row was updated or not
            System.out.println("Updated Table:");
            DisplayTable.displayTable(conn);

            // Check if any row was updated
            if (rowsUpdated > 0) {
                System.out.println("Row updated successfully.");
            } else {
                System.out.println("No row updated.");
            }

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
