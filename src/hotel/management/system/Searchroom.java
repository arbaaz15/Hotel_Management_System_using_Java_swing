package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Searchroom extends JFrame implements ActionListener {


    JButton b1,b2,b3;
    JComboBox c1;
    JCheckBox ch1;
    JLabel l1,l2,l3,l4;
    JTable t1;



    public Searchroom(){

        JLabel title = new JLabel("SEARCH ROOM");
        title.setBounds(300,5,300,40);
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setForeground(Color.RED);
        title.setBackground(Color.black);
        add(title);

///////////////////////////////////////////////////////////////////////////

        t1 = new JTable();
        t1.setBounds(190,50,490,330);
        add(t1);


///////////////////////////////////////////////////////////////////////////

        c1 = new JComboBox(new String[] {"Single Bed","Double Bed"});
        c1.setBounds(20,100,150,30);
        add(c1);
///////////////////////////////////////////////////////////////////////////

        ch1 = new JCheckBox("Only Display Available");
        ch1.setBounds(20,150,150,30);
        add(ch1);
///////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////









///////////////////////////////////////////////////////////////////////////

        b1 = new JButton("Search");
        b1.setBounds(200,400,130,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(380,400,130,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

///////////////////////////////////////////////////////////////////////////

   // getContentPane().setBackground(Color.white);

    setLayout(null);
    setBounds(450,200,700,500);
    setVisible(true);

}

///////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==b1){

            try{

                conn c = new conn();

                String str = "select * from room where bed_type = '"+ c1.getSelectedItem() +"'";
                String str2 = "select * from room where available = 'available' AND bed_type = '"+ c1.getSelectedItem() +"'";



                if (ch1.isSelected()){
                    ResultSet rs = c.s.executeQuery(str2);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                else
                {
                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                }

            }catch (Exception e){
                System.out.println(e);
            }

        }

///////////////////////////////////////////////////////////////////////////

        else if (ae.getSource() == b2) {

            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }

///////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        new Searchroom().setVisible(true);
    }
}
