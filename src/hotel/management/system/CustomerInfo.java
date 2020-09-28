package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{

    JTable t1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton b1,b2;

    public CustomerInfo(){

        t1 = new JTable();
        t1.setBounds(0,50,1000,500);
        add(t1);

/////////////////////////////////////////////////////////////////////

        l1 = new JLabel("Id_Type");
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setBounds(30,10,60,30);
        add(l1);

/////////////////////////////////////////////////////////////////////

        l2 = new JLabel("Id_No");
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setBounds(150,10,60,30);
        add(l2);

/////////////////////////////////////////////////////////////////////

        l3 = new JLabel("Name");
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setBounds(260,10,60,30);
        add(l3);

/////////////////////////////////////////////////////////////////////

        l4 = new JLabel("Gender");
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setBounds(360,10,60,30);
        add(l4);


/////////////////////////////////////////////////////////////////////

        l5 = new JLabel("Phone");
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setBounds(480,10,60,30);
        add(l5);


/////////////////////////////////////////////////////////////////////

        l6 = new JLabel("Address");
        l6.setFont(new Font("Tahoma",Font.BOLD,14));
        l6.setBounds(590,10,60,30);
        add(l6);


/////////////////////////////////////////////////////////////////////

        l7 = new JLabel("Room_No");
        l7.setFont(new Font("Tahoma",Font.BOLD,14));
        l7.setBounds(690,10,80,30);
        add(l7);


/////////////////////////////////////////////////////////////////////

        l8 = new JLabel("Status");
        l8.setFont(new Font("Tahoma",Font.BOLD,14));
        l8.setBounds(810,10,60,30);
        add(l8);

/////////////////////////////////////////////////////////////////////

        l9 = new JLabel("Deposit");
        l9.setFont(new Font("Tahoma",Font.BOLD,14));
        l9.setBounds(910,10,60,30);
        add(l9);

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

        //getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(300,150,1000,650);
        setVisible(true);

    }



    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==b1){

            try{

                conn c = new conn();

                String str = "select * from customer";
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
        new CustomerInfo().setVisible(true);
    }
}
