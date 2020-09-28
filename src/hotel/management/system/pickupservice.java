package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class pickupservice extends JFrame implements ActionListener {


    JButton b1,b2,b3;
    Choice c1;
    JCheckBox ch1;
    JLabel l1,l2,l3,l4;
    JTable t1;



    public pickupservice(){

        JLabel title = new JLabel("PICK_UP SERVICE");
        title.setBounds(300,5,300,40);
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setForeground(Color.RED);
        title.setBackground(Color.black);
        add(title);

////////////////////////////////////////////////////////////////////////////////////

        JLabel car_brand = new JLabel("Car");
        car_brand.setFont(new Font("Tahoma",Font.PLAIN,17));
        car_brand.setBounds(20,70,150,30);
        add(car_brand);

        c1 = new Choice();

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");

            while (rs.next()){
                c1.add(rs.getString("car_company"));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        c1.setBounds(20,100,150,30);
        add(c1);

///////////////////////////////////////////////////////////////////////////

        t1 = new JTable();
        t1.setBounds(190,50,490,330);
        add(t1);

///////////////////////////////////////////////////////////////////////////

        b1 = new JButton("Check");
        b1.setBounds(200,400,130,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBounds(380,400,130,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

///////////////////////////////////////////////////////////////////////////

        // getContentPane().setBackground(Color.white);

        setLayout(null);
        setBounds(450,200,700,500);
        setVisible(true);

    }

///////////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==b1){

            try{

                conn c = new conn();

                String str = "select * from driver where car_company = '"+ c1.getSelectedItem() +"'";
               // String str2 = "select * from room where available = 'available' AND bed_type = '"+ c1.getSelectedItem() +"'";

                    ResultSet rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                System.out.println(e);
            }

        }

///////////////////////////////////////////////////////////////////////////

        else if (ae.getSource() == b2) {

            new Reception().setVisible(true);
            this.setVisible(false);
        }

    }

///////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        new pickupservice().setVisible(true);
    }
}
