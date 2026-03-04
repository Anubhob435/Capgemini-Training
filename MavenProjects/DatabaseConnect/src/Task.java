import java.sql.Connection;
import java.sql.PreparedStatement;

public class Task {
    public static void main(String[] args) {
        try {
            Connection con = DatabaseConfig.getConnection();

            String query = "INSERT INTO tasks (title, description) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            // First Record
            ps.setString(1, "Learn JDBC");
            ps.setString(2, "Practice inserting records using Java");
            ps.executeUpdate();

            // Second Record
            ps.setString(1, "Build Project");
            ps.setString(2, "Create a task manager app");
            ps.executeUpdate();

            System.out.println("2 Records Inserted Successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}