import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection conn = DatabaseConfig.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tasks(title, description) VALUES (?,?)");
        pstmt.setString(1, "JDBS Testing");
        pstmt.setString(2, "This is the jdbc Testing description");
        pstmt.executeUpdate();

        System.out.println("Task Added!");
        pstmt.close();
        conn.close();
    }
}