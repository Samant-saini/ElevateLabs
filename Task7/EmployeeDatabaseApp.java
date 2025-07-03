import java.sql.*;
import java.util.Scanner;

public class EmployeeDatabaseApp {
    static final String URL = "jdbc:mysql://localhost:3306/DB";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();

                    String sql = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";
                    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setInt(1, id);
                        stmt.setString(2, name);
                        stmt.setDouble(3, salary);
                        stmt.executeUpdate();
                        System.out.println("Employee added successfully.");
                    }

                } else if (choice == 2) {
                    String sql = "SELECT * FROM employee";
                    try (Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery(sql)) {
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id")
                                    + ", Name: " + rs.getString("name")
                                    + ", Salary: " + rs.getDouble("salary"));
                        }
                    }

                } else if (choice == 3) {
                    System.out.print("Enter ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter New Salary: ");
                    double salary = scanner.nextDouble();

                    String sql = "UPDATE employee SET name=?, salary=? WHERE id=?";
                    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, name);
                        stmt.setDouble(2, salary);
                        stmt.setInt(3, id);
                        int rowsUpdated = stmt.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("Employee updated successfully.");
                        } else {
                            System.out.println("Employee not found.");
                        }
                    }

                } else if (choice == 4) {
                    System.out.print("Enter ID to delete: ");
                    int id = scanner.nextInt();

                    String sql = "DELETE FROM employee WHERE id=?";
                    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setInt(1, id);
                        int rowsDeleted = stmt.executeUpdate();
                        if (rowsDeleted > 0) {
                            System.out.println("Employee deleted successfully.");
                        } else {
                            System.out.println("Employee not found.");
                        }
                    }

                } else if (choice == 5) {
                    break;
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
