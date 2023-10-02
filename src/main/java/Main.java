import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "passwordhere");
            Statement stm = connection.createStatement();
            stm.execute("CREATE VIEW italian_students AS SELECT first_name,last_name FROM students WHERE country='Italy'");
            stm.execute("CREATE VIEW german_students AS SELECT first_name,last_name FROM students WHERE country='Germany'");
            ResultSet italianStudensRs = stm.executeQuery("SELECT * FROM italian_students");
            ResultSet germanStudentsRs = stm.executeQuery("SELECT * FROM german_students");
            ArrayList<String> italianStudents = new ArrayList<>();
            ArrayList<String> germanStudents = new ArrayList<>();
            while (italianStudensRs.next()) {
                italianStudents.add(italianStudensRs.getString("first_name"));
                italianStudents.add(italianStudensRs.getString("last_name"));
            }
            while (germanStudentsRs.next()) {
                germanStudents.add(germanStudentsRs.getString("first_name"));
                germanStudents.add(germanStudentsRs.getString("last_name"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
