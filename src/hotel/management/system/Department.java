package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {


    JButton b1,b2,b3;
    Choice c1;
    JCheckBox ch1;
    JLabel l1,l2,l3,l4;
    JTable t1;



    public Department(){

        JLabel title = new JLabel("DEPARTMENTS");
        title.setBounds(160,5,300,40);
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setForeground(Color.RED);
        title.setBackground(Color.black);
        add(title);

///////////////////////////////////////////////////////////////////////////

        t1 = new JTable();
        t1.setBounds(0,50,500,350);
        add(t1);

///////////////////////////////////////////////////////////////////////////

        b1 = new JButton("Show");
        b1.setBounds(80,420,130,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(250,420,130,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

///////////////////////////////////////////////////////////////////////////

        // getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(550,150,500,500);
        setVisible(true);

    }

///////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==b1){

            try{

                conn c = new conn();

                String str = "select * from department";

                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

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
        new Department().setVisible(true);
    }
}
