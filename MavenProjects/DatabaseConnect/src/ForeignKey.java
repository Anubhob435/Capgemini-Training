import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class ForeignKey {

    public static void main(String[] args) {

        try {
            Connection con = DatabaseConfig.getConnection();
            Statement stmt = con.createStatement();

            // Fetch all Departments
            System.out.println("----- Department Table -----");
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM Department");

            while (rs1.next()) {
                System.out.println(
                        rs1.getInt("dept_id") + " | " +
                                rs1.getString("dept_name")
                );
            }

            // Fetch all Students
            System.out.println("\n----- Student Table -----");
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM Student");

            while (rs2.next()) {
                System.out.println(
                        rs2.getInt("student_id") + " | " +
                                rs2.getString("student_name") + " | " +
                                rs2.getInt("age") + " | " +
                                rs2.getInt("dept_id")
                );
            }

            // JOIN Query
            System.out.println("\n----- Students with Department Name -----");
            ResultSet rs3 = stmt.executeQuery(
                    "SELECT s.student_id, s.student_name, s.age, d.dept_name " +
                            "FROM Student s JOIN Department d " +
                            "ON s.dept_id = d.dept_id"
            );

            while (rs3.next()) {
                System.out.println(
                        rs3.getInt("student_id") + " | " +
                                rs3.getString("student_name") + " | " +
                                rs3.getInt("age") + " | " +
                                rs3.getString("dept_name")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}