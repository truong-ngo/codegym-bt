import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/student_manager";
        String username = "root";
        String password = "truongngo0";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
                                   rs.getString(3) + " " + rs.getString(4) + " " +
                                   rs.getByte(5) + " " + rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
