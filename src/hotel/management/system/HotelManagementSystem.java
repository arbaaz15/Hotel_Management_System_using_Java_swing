package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {

    JButton b1;


    public HotelManagementSystem() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));

//////////////////////////////////////////////////////////////////////////////

        JLabel l1 = new JLabel(i1);
        l1.setBounds(0, 0, 600, 600);
        add(l1);

//////////////////////////////////////////////////////////////////////////////

        JLabel l2 = new JLabel("WELOME TO HOTEL AZ");
        l2.setBounds(10, 340, 500, 100);
        l2.setForeground(Color.white);
        l2.setFont(new Font("serif", Font.PLAIN, 40));
        l1.add(l2);

//////////////////////////////////////////////////////////////////////////////

        b1 = new JButton("Next");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(10,430,200,50);
        b1.setFont(new Font("serif", Font.PLAIN, 30));
        b1.addActionListener(this);
        l1.add(b1);


//////////////////////////////////////////////////////////////////////////////

        setLayout(null);
        setBounds(450, 150, 600, 600);
        setVisible(true);

//////////////////////////////////////////////////////////////////////////////

        while (true) {
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }


        }

    }

//////////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1) {

            new Login().setVisible(true);
            this.setVisible(false);

        }
    }

//////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        new HotelManagementSystem().setVisible(true);
    }
}
