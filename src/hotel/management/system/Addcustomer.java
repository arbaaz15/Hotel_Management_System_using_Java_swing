package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Addcustomer extends JFrame implements ActionListener {

    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2;
    JComboBox c1,c3;
    Choice c2;

    public Addcustomer() {

        JLabel title = new JLabel("NEW CUSTOMER FORM");
        title.setBounds(350,5,300,40);
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setForeground(Color.RED);
        title.setBackground(Color.black);
        add(title);

///////////////////////////////////////////////////////////////////////////

        JLabel id = new JLabel("Type of Id");
        id.setFont(new Font("Tahoma",Font.PLAIN,17));
        id.setBounds(20,80,150,30);
        add(id);

        c1 = new JComboBox(new String[] {"Passport","Voter Id","Driving Licence","Aadhar card"});
        c1.setBounds(150,80,150,30);
        c1.setBackground(Color.white);
        add(c1);

///////////////////////////////////////////////////////////////////////////

        JLabel id_number = new JLabel("Id Number");
        id_number.setFont(new Font("Tahoma",Font.PLAIN,17));
        id_number.setBounds(20,130,150,30);
        add(id_number);

        t1 = new JTextField();
        t1.setBounds(150,130,150,30);
        add(t1);

///////////////////////////////////////////////////////////////////////////

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(20,180,150,30);
        add(name);

        t2 = new JTextField();
        t2.setBounds(150,180,150,30);
        add(t2);

///////////////////////////////////////////////////////////////////////////

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(20,230,150,30);
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setBounds(150,230,70,30);
        r1.setFont(new Font("Tahoma",Font.PLAIN,14));
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(230,230,70,30);
        r2.setFont(new Font("Tahoma",Font.PLAIN,14));
        r2.setBackground(Color.white);
        add(r2);

///////////////////////////////////////////////////////////////////////////

        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        phone.setBounds(20,280,150,30);
        add(phone);

        t3 = new JTextField();
        t3.setBounds(150,280,150,30);
        add(t3);

///////////////////////////////////////////////////////////////////////////

        JLabel country = new JLabel("Country");
        country.setFont(new Font("Tahoma",Font.PLAIN,17));
        country.setBounds(20,330,150,30);
        add(country);

        t4 = new JTextField();
        t4.setBounds(150,330,150,30);
        add(t4);

///////////////////////////////////////////////////////////////////////////

        JLabel allocated_room = new JLabel("Room");
        allocated_room.setFont(new Font("Tahoma",Font.PLAIN,17));
        allocated_room.setBounds(20,380,100,30);
        add(allocated_room);

       c2 = new Choice();
       try{
           conn c = new conn();
           String str = "select * from room";
           ResultSet rs =  c.s.executeQuery(str);

           while (rs.next()){
                c2.add(rs.getString("room_number"));
           }

       }catch (Exception e){
           System.out.println(e);
       }
        c2.setBounds(150,380,150,30);
        add(c2);

///////////////////////////////////////////////////////////////////////////

        JLabel checked_in = new JLabel("Checked In");
        checked_in.setFont(new Font("Tahoma",Font.PLAIN,17));
        checked_in.setBounds(20,430,150,30);
        add(checked_in);

        c3 = new JComboBox(new String[] {"Yes","No"});
        c3.setBounds(150,430,150,30);
        c3.setBackground(Color.white);
        add(c3);


///////////////////////////////////////////////////////////////////////////

        JLabel deposit = new JLabel("Deposit");
        deposit.setFont(new Font("Tahoma",Font.PLAIN,17));
        deposit.setBounds(20,480,150,30);
        add(deposit);

        t5 = new JTextField();
        t5.setBounds(150,480,150,30);
        add(t5);

///////////////////////////////////////////////////////////////////////////

        b1 = new JButton("Add");
        b1.setBounds(60,550,130,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(220,550,130,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

///////////////////////////////////////////////////////////////////////////

        getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(250,130,1000,650);
        setVisible(true);

    }

///////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==b1) {

            String id_number = t1.getText();
            String name = t2.getText();
            String phone = t3.getText();
            String address = t4.getText();
            String deposit = t5.getText();


            ///////////////////////////////////////////////////

            String gender = null;
            if (r1.isSelected()) {
                gender = "male";
            } else if (r2.isSelected()) {
                gender = "female";
            }

            ////////////////////////////////////////////////////

            String id = (String) c1.getSelectedItem();

            String room = (String) c2.getSelectedItem();

            String checked_in = (String) c3.getSelectedItem();

            ////////////////////////////////////////////////////

            conn c = new conn();

            String str = "insert into customer values ('" + id + "','" + id_number + "','" + name + "','" + gender + "','" + phone + "','" + address + "','" + room + "','" + checked_in + "','" + deposit + "')";

            String str2 = "update room set available = 'occupied' where room_number = '"+ room +"'";

            try {
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null, "New Customer Added!");
                this.setVisible(false);


            } catch (Exception e) {
                System.out.println(e);
            }

///////////////////////////////////////////////////////////////////////////////

        }else if (ae.getSource()==b2){

            new Reception().setVisible(true);
            this.setVisible(false);

        }



    }

///////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        new Addcustomer().setVisible(true);
    }
}
