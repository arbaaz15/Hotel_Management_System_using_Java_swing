package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Reception extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;


    public Reception() {

        JLabel title = new JLabel("WELCOME TO RECEPTION");
        title.setBounds(220, 1, 300, 40);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setForeground(Color.RED);
        title.setBackground(Color.black);
        add(title);

///////////////////////////////////////////////////////////////////////////////

        b1 = new JButton("New Customer Form");
        b1.setBounds(20,50,180,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);

///////////////////////////////////////////////////////////////////////////////

        b2 = new JButton("Rooms");
        b2.setBounds(20,90,180,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

///////////////////////////////////////////////////////////////////////////////

        b3 = new JButton("Department");
        b3.setBounds(20,130,180,30);
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.addActionListener(this);
        add(b3);

///////////////////////////////////////////////////////////////////////////////

        b4 = new JButton("Employees Info ");
        b4.setBounds(20,170,180,30);
        b4.setForeground(Color.white);
        b4.setBackground(Color.black);
        b4.addActionListener(this);
        add(b4);

///////////////////////////////////////////////////////////////////////////////

        b5 = new JButton("Customer Info");
        b5.setBounds(20,210,180,30);
        b5.setForeground(Color.white);
        b5.setBackground(Color.black);
        b5.addActionListener(this);
        add(b5);

///////////////////////////////////////////////////////////////////////////////

        b6 = new JButton("Manager Info");
        b6.setBounds(20,250,180,30);
        b6.setForeground(Color.white);
        b6.setBackground(Color.black);
        b6.addActionListener(this);
        add(b6);

///////////////////////////////////////////////////////////////////////////////

        b7 = new JButton("Check Out");
        b7.setBounds(20,290,180,30);
        b7.setForeground(Color.white);
        b7.setBackground(Color.black);
        b7.addActionListener(this);
        add(b7);

///////////////////////////////////////////////////////////////////////////////

        b8 = new JButton("Update Check Status");
        b8.setBounds(20,330,180,30);
        b8.setForeground(Color.white);
        b8.setBackground(Color.black);
        b8.addActionListener(this);
        add(b8);

///////////////////////////////////////////////////////////////////////////////

        b9 = new JButton("Update Room Status");
        b9.setBounds(20,370,180,30);
        b9.setForeground(Color.white);
        b9.setBackground(Color.black);
        b9.addActionListener(this);
        add(b9);

///////////////////////////////////////////////////////////////////////////////

        b10 = new JButton("Pickup Service");
        b10.setBounds(20,410,180,30);
        b10.setForeground(Color.white);
        b10.setBackground(Color.black);
        b10.addActionListener(this);
        add(b10);

///////////////////////////////////////////////////////////////////////////////

        b11 = new JButton("Search Room");
        b11.setBounds(20,450,180,30);
        b11.setForeground(Color.white);
        b11.setBackground(Color.black);
        b11.addActionListener(this);
        add(b11);

///////////////////////////////////////////////////////////////////////////////

        b12 = new JButton("Logout");
        b12.setBounds(20,490,180,30);
        b12.setForeground(Color.white);
        b12.setBackground(Color.black);
        b12.addActionListener(this);
        add(b12);

/////////////////////////////////////////////////////////////////////////////////

        setLayout(null);
        setBounds(400, 150, 800, 600);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == b1) {

            new Addcustomer().setVisible(true);
            this.setVisible(false);

        }
        ///////////////////////////////////////////////////////////////////////////////

        else if(ae.getSource() == b2) {

            new Room().setVisible(true);
            this.setVisible(false);

        }
        ///////////////////////////////////////////////////////////////////////////////

        else if(ae.getSource() == b3) {

            new Department().setVisible(true);
            this.setVisible(false);

        }
        ///////////////////////////////////////////////////////////////////////////////

        else if(ae.getSource() == b4) {

            new EmployeeInfo().setVisible(true);
            this.setVisible(false);

        }
        ///////////////////////////////////////////////////////////////////////////////

        else if(ae.getSource() == b5) {

            new CustomerInfo().setVisible(true);
            this.setVisible(false);

        }
        ///////////////////////////////////////////////////////////////////////////////

        else if(ae.getSource() == b6) {

            new ManagerInfo().setVisible(true);
            this.setVisible(false);

        }
        ///////////////////////////////////////////////////////////////////////////////

        else if(ae.getSource() == b7) {

            new Checkout().setVisible(true);
            this.setVisible(false);

        }
        ///////////////////////////////////////////////////////////////////////////////

        else if(ae.getSource() == b8) {

            new Updatecheck().setVisible(true);
            this.setVisible(false);

        }
        ///////////////////////////////////////////////////////////////////////////////

        else if(ae.getSource() == b9) {

            new Updateroom().setVisible(true);
            this.setVisible(false);
        }
        ///////////////////////////////////////////////////////////////////////////////

        else if(ae.getSource() == b10) {

            new pickupservice().setVisible(true);
            this.setVisible(false);
        }
        ///////////////////////////////////////////////////////////////////////////////

        else if(ae.getSource() == b11) {

            new Searchroom().setVisible(true);
            this.setVisible(false);
        }
        ///////////////////////////////////////////////////////////////////////////////

        else if (ae.getSource()==b12){
            new Login().setVisible(true);
            this.setVisible(false);
        }

    }

///////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        new Reception().setVisible(true);
    }
}

