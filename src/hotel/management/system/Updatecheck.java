package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Updatecheck extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    Choice c1;
    JButton b1,b2,b3;


    public Updatecheck(){

        JLabel title = new JLabel("CHECK-IN-DETAILS");
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

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(20,180,150,30);
        add(name);

        t2 = new JTextField();
        t2.setBounds(180,180,150,30);
        add(t2);

///////////////////////////////////////////////////////////////////////////

        JLabel check_in = new JLabel("Check-In");
        check_in.setFont(new Font("Tahoma",Font.PLAIN,17));
        check_in.setBounds(20,230,150,30);
        add(check_in);

        t3 = new JTextField();
        t3.setBounds(180,230,150,30);
        add(t3);

//////////////////////////////////////////////////////////////////////////

        JLabel amount_paid = new JLabel("Amount Paid");
        amount_paid.setFont(new Font("Tahoma",Font.PLAIN,17));
        amount_paid.setBounds(20,280,150,30);
        add(amount_paid);

        t4 = new JTextField();
        t4.setBounds(180,280,150,30);
        add(t4);

//////////////////////////////////////////////////////////////////////////

        JLabel pending_amount = new JLabel("Pending Amount");
        pending_amount.setFont(new Font("Tahoma",Font.PLAIN,17));
        pending_amount.setBounds(20,330,150,30);
        add(pending_amount);

        t5 = new JTextField();
        t5.setBounds(180,330,150,30);
        add(t5);

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









    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==b1){

            try{

                String room = null;
                String deposit = null;
                int amountpaid = 0;
                String price = null;

                conn c = new conn();
                String id = c1.getSelectedItem();

                String str = "select * from customer where id_number = '"+ id +"'";
                ResultSet rs = c.s.executeQuery(str);

                while (rs.next()){
                    t1.setText(rs.getString("room_alloted"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("checked_in"));
                    t4.setText(rs.getString("deposit"));

                    room = rs.getString("room_alloted");
                    deposit = rs.getString("deposit");
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+ room +"'");

                while(rs2.next()){

                    price = rs2.getString("price");
                    amountpaid = Integer.parseInt(price) - Integer.parseInt(deposit);

                    t5.setText(Integer.toString(amountpaid));
                }

            }catch (Exception e){
                System.out.println(e);
            }

        }
///////////////////////////////////////////////////////////////////////////

        else if (ae.getSource() == b2) {

            try{

                conn c = new conn();

                String id_no = c1.getSelectedItem();
                String check_in = t3.getText();
                String amountpaid = t4.getText();

                String str = "update customer set checked_in = '"+ check_in +"',deposit = '"+ amountpaid +"' where id_number = '"+ id_no +"'" ;
                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"Data Updated!");

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
        new Updatecheck().setVisible(true);
    }
}
