package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Checkout extends JFrame implements ActionListener {

        JTextField t1;
        Choice c1;
        JButton b1,b2,b3;


    public Checkout(){

        JLabel title = new JLabel("CHECK-OUT");
        title.setBounds(350,5,300,40);
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setForeground(Color.RED);
        title.setBackground(Color.black);
        add(title);

///////////////////////////////////////////////////////////////////////////

        JLabel customer_id = new JLabel("Customer Id");
        customer_id.setFont(new Font("Tahoma",Font.PLAIN,17));
        customer_id.setBounds(20,80,100,30);
        add(customer_id);

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

        c1.setBounds(180,85,150,80);
        add(c1);

///////////////////////////////////////////////////////////////////////////

        JLabel room_no = new JLabel("Room Number");
        room_no.setFont(new Font("Tahoma",Font.PLAIN,17));
        room_no.setBounds(20,130,150,30);
        add(room_no);

        t1 = new JTextField();
        t1.setBounds(180,130,150,30);
        add(t1);

///////////////////////////////////////////////////////////////////////////

        b1 = new JButton("Check");
        b1.setBounds(60,200,130,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Check-out");
        b2.setBounds(220,200,130,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("Cancel");
        b3.setBounds(370,200,130,30);
        b3.setForeground(Color.white);
        b3.setBackground(Color.black);
        b3.addActionListener(this);
        add(b3);

///////////////////////////////////////////////////////////////////////////

    getContentPane().setBackground(Color.white);

    setLayout(null);
    setBounds(450,200,800,300);
    setVisible(true);

}


///////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent ae) {


        if(ae.getSource()==b1){

            try{

                String room = null;

                conn c = new conn();
                String id = c1.getSelectedItem();

                String str = "select * from customer where id_number = '"+ id +"'";
                ResultSet rs = c.s.executeQuery(str);

                while (rs.next()){
                    t1.setText(rs.getString("room_alloted"));

                    room = rs.getString("room_alloted");
                }

            }catch (Exception e){
                System.out.println(e);
            }

        }
///////////////////////////////////////////////////////////////////////////

        else if (ae.getSource() == b2) {

            String id = c1.getSelectedItem();
            String room = t1.getText();

            try{

                conn c = new conn();

                String str = "delete from customer where id_number = '"+ id +"'";
                String str2 = "update room set available = 'available' where room_number = '"+ room +"'";

                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);

                JOptionPane.showMessageDialog(null,"Customer Checked Out!");

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
        new Checkout().setVisible(true);
    }
}
