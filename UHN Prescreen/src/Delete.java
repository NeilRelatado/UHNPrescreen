import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Delete {
    private JTextField textField1;
    private JTextField textField2;
    private JLabel lblCode;
    private JLabel lblCIS;
    private JPanel pnlDelete;
    private JButton btnDelete;
    Connection connection = null;

    public Delete() {
        connection =sqliteConnection.dbconnector();
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // String query = "DELETE FROM employees WHERE last_name = 'Johnson'\n" +
                    //    "AND employee_id >= 80;";
                //String query = "DELETE FROM diseases WHERE Code = ? AND CodeSystemID = ?";
              //  PreparedStatement pst =


               /*
                PreparedStatement pst = connection.prepareStatement(query);
                pst.setString(1,txtCode.getText());
                pst.setString(2,txtCodeSID.getText());
                pst.setString(3,txtDName.getText());
                pst.setString(4,txtSetID.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null,"Successfully Inserted ");
                pst.close();
                */
                try
                {

                    String query = "DELETE FROM diseases WHERE Code = ? AND CodeSystemID = ?";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1,textField1.getText());
                    pst.setString(2,textField2.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Successfully Deleted ");
                    pst.close();



                }catch(Exception s)
                {
                    s.printStackTrace();
                    JOptionPane.showMessageDialog(null,"An error occurred ");
                }




            }
        });
    }

    public JPanel getPnlDelete() {
        return pnlDelete;
    }
}

