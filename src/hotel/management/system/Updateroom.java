package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Updateroom extends JFrame implements ActionListener {

    JTextField t1,t2,t3;
    Choice c1;
    JButton b1,b2,b3;


    public Updateroom(){

        JLabel title = new JLabel("UPDATE ROOM STATUS");
        title.setBounds(350,5,300,40);
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setForeground(Color.RED);
        title.setBackground(Color.black);
        add(title);

///////////////////////////////////////////////////////////////////////////

        JLabel guest_id = new JLabel("Guest Id");
        guest_id.setFont(new Font("Tahoma",Font.PLAIN,17));
        guest_id.setBounds(20,80,80,30);
        add(guest_id);

        c1 = new Choice();

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");

            while (rs.next()){
                c1.add(rs.getString("id_number"));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        c1.setBounds(150,85,150,80);
        add(c1);

///////////////////////////////////////////////////////////////////////////

        JLabel room_no = new JLabel("Room Number");
        room_no.setFont(new Font("Tahoma",Font.PLAIN,17));
        room_no.setBounds(20,130,150,30);
        add(room_no);

        t1 = new JTextField();
        t1.setBounds(150,130,150,30);
        add(t1);

///////////////////////////////////////////////////////////////////////////

        JLabel availability = new JLabel("Availability");
        availability.setFont(new Font("Tahoma",Font.PLAIN,17));
        availability.setBounds(20,180,150,30);
        add(availability);

        t2 = new JTextField();
        t2.setBounds(150,180,150,30);
        add(t2);

///////////////////////////////////////////////////////////////////////////

        JLabel cleaning_status = new JLabel("Cleaning Status");
        cleaning_status.setFont(new Font("Tahoma",Font.PLAIN,17));
        cleaning_status.setBounds(20,230,150,30);
        add(cleaning_status);

        t3 = new JTextField();
        t3.setBounds(150,230,150,30);
        add(t3);

///////////////////////////////////////////////////////////////////////////

        b1 = new JButton("Check");
        b1.setBounds(60,550,130,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Update");
        b2.setBounds(220,550,130,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Cancel");
        b3.setBounds(370,550,130,30);
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.addActionListener(this);
        add(b3);

///////////////////////////////////////////////////////////////////////////

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(250,130,1000,650);
        setVisible(true);

    }

///////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            String room=null;
            String guest_id = c1.getSelectedItem();
            conn c = new conn();

            try {

                ResultSet rs = c.s.executeQuery("select * from customer where id_number = '" + guest_id + "'");

                while(rs.next()){
                    t1.setText(rs.getString("room_alloted"));
                    room = rs.getString("room_alloted");
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" + room + "'");

                while(rs2.next()){
                    t2.setText(rs2.getString("available"));
                    t3.setText(rs2.getString("cleaning_status"));
                }

            }catch (Exception e){

                System.out.println(e);

            }

        }

///////////////////////////////////////////////////////////////////////////

        else if (ae.getSource() == b2) {

            try{

                conn c = new conn();

                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();

                String str = "update room set available = '"+ available +"',cleaning_status = '"+ status +"' where room_number = '"+ room +"'" ;
                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"Room Updated!");

                new Reception().setVisible(true);
                this.setVisible(false);

            }catch (Exception e){
                System.out.println(e);
            }
        }

///////////////////////////////////////////////////////////////////////////

        else if (ae.getSource() == b3) {

            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }
///////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        new Updateroom().setVisible(true);
    }
}
