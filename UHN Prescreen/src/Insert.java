import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Insert {

    private JPanel frmInsert;
    private JTextField txtCode;
    private JTextField txtCodeSID;

    private JTextField txtSetID;
    private JButton insertButton;
    private JLabel txtSystemID;
    private JTextField txtDName;
    Connection connection = null;

    public Insert()
    {
        connection =sqliteConnection.dbconnector();

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                   // String query = "SELECT * FROM diseases where code = ?;";
                    String query = "INSERT INTO diseases (Code,CodeSystemID,DisplayName,ValueSetID) VALUES (?,?,?,?);";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1,txtCode.getText());
                    pst.setString(2,txtCodeSID.getText());
                    pst.setString(3,txtDName.getText());
                    pst.setString(4,txtSetID.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Successfully Inserted ");
                    pst.close();



                }catch(Exception s)
                {
                    s.printStackTrace();
                    JOptionPane.showMessageDialog(null,"An error occurred ");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InsertForm");
        frame.setContentPane(new  Insert().frmInsert);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public JPanel getFrmInsert() {
        return frmInsert;
    }
}
