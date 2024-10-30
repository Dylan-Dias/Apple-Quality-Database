import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Aggregation {

    public static void performAggregations(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MIN(Size), MAX(Weight), COUNT(*), AVG(Sweetness), AVG(Weight), SUM(Size + Weight + Sweetness + Ripeness + Juiciness + Crunchiness) FROM APPLE");

            if (rs.next()) {
                double minSize = rs.getDouble(1);
                double maxWeight = rs.getDouble(2);
                int totalCount = rs.getInt(3);
                double avgSweetness = rs.getDouble(4);
                double avgWeight = rs.getDouble(5);
                double sumOfAll = rs.getDouble(6);

                // Display the aggregation results
                System.out.println("Min Size: " + minSize);
                System.out.println("Max Weight: " + maxWeight);
                System.out.println("Total Count: " + totalCount);
                System.out.println("Average Sweetness: " + avgSweetness);
                System.out.println("Average Weight: " + avgWeight);
                System.out.println("Sum of All: " + sumOfAll);
            }

            // Close the resources
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
