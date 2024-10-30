import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final String DB_URL = "jdbc:derby:myDB;create=true";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Scanner scanner = new Scanner(System.in)) {

            boolean exit = false;
            while (!exit) {
                // Display the menu
                System.out.println("Menu:");
                System.out.println("1. Create Table");
                System.out.println("2. Insert Data");
                System.out.println("3. Update Data");
                System.out.println("4. Delete Data");
                System.out.println("5. Display Table");
                System.out.println("6. Drop Table");
                System.out.println("7. Aggregation");
                System.out.println("8. Select Data");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");

                // Get user input
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        CreateTable.createTable(conn);
                        break;
                    case 2:
                        InsertTable.insertPredefinedData(conn, scanner);
                        break;
                    case 3:
                        UpdateTable.updateRow(conn, scanner);
                        break;
                    case 4:
                        DeleteRow.deleteRow(conn, scanner);
                        break;
                    case 5:
                        DisplayTable.displayTable(conn);
                        break;
                    case 6:
                        DropTable.dropTable(conn);
                        break;
                    case 7:
                        Aggregation.performAggregations(conn);
                        break;
                    case 8:
                        Select.selectData(conn, scanner);
                        break;
                    case 9:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
