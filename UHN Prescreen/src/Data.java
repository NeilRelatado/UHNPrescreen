import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Data {
    private JPanel Data;
    private JTable tblSicknesses;
    private JButton btnLoadTable;
    private JButton btnInsert;
    private JButton btnDelete;
    private JTextField txtSearchCode;
    private JTextField txtSeachCIS;


    Connection connection = null;
    public Data()
    {
        connection =sqliteConnection.dbconnector();

        try
        {
            String query = "SELECT * FROM diseases";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            tblSicknesses.setModel(DbUtils.resultSetToTableModel(rs));


        }catch(Exception s)
        {
            s.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");

        }


        btnLoadTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    String query = "SELECT * FROM diseases where Code = ? AND CodeSystemID = ?;";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1,txtSearchCode.getText());
                    pst.setString(2,txtSeachCIS.getText());
                    ResultSet rs = pst.executeQuery();
                    tblSicknesses.setModel(DbUtils.resultSetToTableModel(rs));


                }catch(Exception s)
                {
                    s.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("App");
                frame.setContentPane(new  Insert().getFrmInsert());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);





            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("App");
                frame.setContentPane(new Delete().getPnlDelete());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);



            }
        });


    }





    public static void main(String[] args) {

        JFrame frame = new JFrame("App");
        frame.setContentPane(new  Data().Data);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);






    }




}
