package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class Room extends JFrame implements ActionListener {

    JButton b1,b2;
    JTable t1;
    JLabel l1,l2,l3,l4,l5;


    public Room(){

        t1 = new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);

///////////////////////////////////////////////////////////////////////////

        l1 = new JLabel("Room Number");
        l1.setFont(new Font("Tahoma",Font.BOLD,10));
        l1.setBounds(10,10,80,30);
        add(l1);

/////////////////////////////////////////////////////////////////////

        l2 = new JLabel("Available");
        l2.setFont(new Font("Tahoma",Font.BOLD,10));
        l2.setBounds(120,10,80,30);
        add(l2);

/////////////////////////////////////////////////////////////////////

        l3 = new JLabel("Cleaning Status");
        l3.setFont(new Font("Tahoma",Font.BOLD,10));
        l3.setBounds(210,10,80,30);
        add(l3);

/////////////////////////////////////////////////////////////////////

        l4 = new JLabel("Price");
        l4.setFont(new Font("Tahoma",Font.BOLD,10));
        l4.setBounds(340,10,80,30);
        add(l4);

/////////////////////////////////////////////////////////////////////

        l5 = new JLabel("Bed Type");
        l5.setFont(new Font("Tahoma",Font.BOLD,10));
        l5.setBounds(430,10,80,30);
        add(l5);

///////////////////////////////////////////////////////////////////////////

        b1 = new JButton("Load");
        b1.setBounds(60,500,130,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);


        b2 = new JButton("Cancel");
        b2.setBounds(220,500,130,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

///////////////////////////////////////////////////////////////////////////

        setLayout(null);
        setBounds(450,150,1000,600);
        setVisible(true);

    }

///////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == b1){
            try{

                conn c = new conn();

                String str = "select * from room";
                ResultSet rs = c.s.executeQuery(str);

                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                System.out.println(e);
            }

    ///////////////////////////////////////////////////////////////////////////////

        }
        else if (ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Room().setVisible(true);
    }
}
