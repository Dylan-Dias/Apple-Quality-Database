import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTable {

    public static void insertPredefinedData(Connection conn, Scanner scanner) {
        try {
            // INSERT INTO statement without specifying the ID column
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO APPLE (Size, Weight, Sweetness, Ripeness, Juiciness, Crunchiness) VALUES (?, ?, ?, ?, ?, ?)");

            // Insert data for row 1
            insertRow(pstmt, -3.9, -2.5, 5.3, 1.0, -1.8, 1.3);
            insertRow(pstmt, 1.1, -2.8, 3.6, 1.5, 1.6, 1.8);
            insertRow(pstmt, -1.9, -1.3, -1.7, 0.3, 2.8, 0.3);
            insertRow(pstmt, 0.2, -2.2, 1.3, 3.4, -3.6, 0.9);
            insertRow(pstmt, 0.6, -1.2, 0.3, -1.3, 3.3, 0.5);
            insertRow(pstmt, 1.3, -1.4, -1.9, 1.9, 3.8, -1.9);

            pstmt.close();
            System.out.println("Predefined data inserted into 'APPLE' table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertRow(PreparedStatement pstmt, double size, double weight, double sweetness, double ripeness, double juiciness, double crunchiness) throws SQLException {
        pstmt.setDouble(1, size);
        pstmt.setDouble(2, weight);
        pstmt.setDouble(3, sweetness);
        pstmt.setDouble(4, ripeness);
        pstmt.setDouble(5, juiciness);
        pstmt.setDouble(6, crunchiness);
        pstmt.executeUpdate();
    }
}

