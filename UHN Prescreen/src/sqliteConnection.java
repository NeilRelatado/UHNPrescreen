import javax.swing.*;
import java.sql.*;
import java.sql.DriverManager;

public class sqliteConnection {
Connection con = null;
        public static Connection dbconnector() {

            try{
                Class.forName("org.sqlite.JDBC");
                Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Neil\\IdeaProjects\\UHN Prescreen\\EmployeeData.sqlite");
                JOptionPane.showMessageDialog(null,"Connection Succesful");
                return con;

            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
                return null;
            }

    }
}


