package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener{

    JTable t1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b1,b2;

    public ManagerInfo(){

        t1 = new JTable();
        t1.setBounds(10,40,1000,500);
        add(t1);

/////////////////////////////////////////////////////////////////////

        l1 = new JLabel("Name");
        l1.setFont(new Font("Tahoma",Font.PLAIN,17));
        l1.setBounds(50,10,60,30);
        add(l1);

/////////////////////////////////////////////////////////////////////

        l2 = new JLabel("Age");
        l2.setFont(new Font("Tahoma",Font.PLAIN,17));
        l2.setBounds(180,10,60,30);
        add(l2);

/////////////////////////////////////////////////////////////////////

        l3 = new JLabel("Gender");
        l3.setFont(new Font("Tahoma",Font.PLAIN,17));
        l3.setBounds(290,10,60,30);
        add(l3);

/////////////////////////////////////////////////////////////////////

        l4 = new JLabel("Job");
        l4.setFont(new Font("Tahoma",Font.PLAIN,17));
        l4.setBounds(420,10,60,30);
        add(l4);


/////////////////////////////////////////////////////////////////////

        l5 = new JLabel("Salary");
        l5.setFont(new Font("Tahoma",Font.PLAIN,17));
        l5.setBounds(550,10,60,30);
        add(l5);


/////////////////////////////////////////////////////////////////////

        l6 = new JLabel("Phone");
        l6.setFont(new Font("Tahoma",Font.PLAIN,17));
        l6.setBounds(670,10,60,30);
        add(l6);


/////////////////////////////////////////////////////////////////////

        l7 = new JLabel("Aadhar");
        l7.setFont(new Font("Tahoma",Font.PLAIN,17));
        l7.setBounds(790,10,60,30);
        add(l7);


/////////////////////////////////////////////////////////////////////

        l8 = new JLabel("E-mail");
        l8.setFont(new Font("Tahoma",Font.PLAIN,17));
        l8.setBounds(910,10,60,30);
        add(l8);


/////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////

        b1 = new JButton("Load Data");
        b1.setBounds(350,560,120,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);

/////////////////////////////////////////////////////////////////////

        b2 = new JButton("Back");
        b2.setBounds(530,560,120,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);



/////////////////////////////////////////////////////////////////////

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(300,150,1000,650);
        setVisible(true);

    }



    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==b1){

            try{

                conn c = new conn();

                String str = "select * from employee where job = 'Manager' ";
                ResultSet rs = c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                System.out.println(e);
            }

        }
        else if (ae.getSource()==b2){

            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ManagerInfo().setVisible(true);
    }
}
