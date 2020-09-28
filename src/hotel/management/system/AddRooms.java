package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;


    public AddRooms(){

        JLabel title = new JLabel("ADD ROOMS");
        title.setBounds(130,5,300,40);
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setForeground(Color.RED);
        title.setBackground(Color.black);
        add(title);

///////////////////////////////////////////////////////////////////////////////

        JLabel room = new JLabel("Room Number");
        room.setBounds(60,80,120,30);
        room.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(room);

        t1 = new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);

///////////////////////////////////////////////////////////////////////////////

        JLabel available = new JLabel("Available");
        available.setBounds(60,130,150,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(available);

        c1 = new JComboBox(new String[] {"Available","Occupied"});
        c1.setBounds(200,130,150,30);
        c1.setBackground(Color.white);
        add(c1);



///////////////////////////////////////////////////////////////////////////////

        JLabel status = new JLabel("Cleaning Status");
        status.setBounds(60,180,150,30);
        status.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(status);

        c2 = new JComboBox(new String[] {"Cleaned","Dirty"});
        c2.setBounds(200,180,150,30);
        c2.setBackground(Color.white);
        add(c2);


///////////////////////////////////////////////////////////////////////////////

        JLabel price = new JLabel("Price");
        price.setBounds(60,230,150,30);
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(price);

        t2 = new JTextField();
        t2.setBounds(200,230,150,30);
        add(t2);


///////////////////////////////////////////////////////////////////////////////

        JLabel type = new JLabel("Bed Type");
        type.setBounds(60,280,150,30);
        type.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(type);

        c3 = new JComboBox(new String[] {"Single Bed","Double Bed"});
        c3.setBounds(200,280,150,30);
        c3.setBackground(Color.white);
        add(c3);

///////////////////////////////////////////////////////////////////////////////

        b1 = new JButton("Add Room");
        b1.setBounds(60,350,130,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);


        b2 = new JButton("Cancel");
        b2.setBounds(220,350,130,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

///////////////////////////////////////////////////////////////////////////////

        setLayout(null);
        setBounds(500,180,600,550);
        setVisible(true);
    }

///////////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){

            String room_number = t1.getText();
            String available = (String)c1.getSelectedItem();
            String status = (String)c2.getSelectedItem();
            String price = t2.getText();
            String type = (String)c3.getSelectedItem();

        ///////////////////////////////////////////////////////////////////////////////

            conn c = new conn();

            String str = "insert into room values ('"+room_number+"','"+available+"','"+status+"','"+price+"','"+type+"')";
            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added!");
                this.setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }

        ///////////////////////////////////////////////////////////////////////////////

        }
        else if (ae.getSource() == b2){
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRooms().setVisible(true);
    }
}
