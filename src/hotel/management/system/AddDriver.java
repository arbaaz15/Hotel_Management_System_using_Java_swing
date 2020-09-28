package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5;
    JComboBox c1;
    JButton b1,b2;
    JRadioButton r1,r2;

    public AddDriver(){

        JLabel title = new JLabel("ADD DRIVER");
        title.setBounds(220,5,300,40);
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setForeground(Color.RED);
        title.setBackground(Color.black);
        add(title);

///////////////////////////////////////////////////////////////////////////////

        JLabel name = new JLabel("Name");
        name.setBounds(60,80,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(name);

        t1 = new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);

/////////////////////////////////////////////////////////////////////////////////

        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,130,120,30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(200,130,150,30);
        add(t2);

/////////////////////////////////////////////////////////////////////////////////

        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,180,120,30);
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setBounds(200,180,70,30);
        r1.setFont(new Font("Tahoma",Font.PLAIN,14));
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(280,180,70,30);
        r2.setFont(new Font("Tahoma",Font.PLAIN,14));
        r2.setBackground(Color.white);
        add(r2);

/////////////////////////////////////////////////////////////////////////////////

        JLabel car = new JLabel("Car Company");
        car.setBounds(60,230,120,30);
        car.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(car);

        t3 = new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);

/////////////////////////////////////////////////////////////////////////////////

        JLabel model = new JLabel("Car Model");
        model.setBounds(60,280,120,30);
        model.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(model);

        t4 = new JTextField();
        t4.setBounds(200,280,150,30);
        add(t4);

/////////////////////////////////////////////////////////////////////////////////

        JLabel available = new JLabel("Available");
        available.setBounds(60,330,150,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(available);

        c1 = new JComboBox(new String[] {"Available","Bussy"});
        c1.setBounds(200,330,150,30);
        c1.setBackground(Color.white);
        add(c1);

/////////////////////////////////////////////////////////////////////////////////

        JLabel location = new JLabel("Location");
        location.setBounds(60,380,120,30);
        location.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(location);

        t5 = new JTextField();
        t5.setBounds(200,380,150,30);
        add(t5);

///////////////////////////////////////////////////////////////////////////////

        b1 = new JButton("Add Driver");
        b1.setBounds(60,450,130,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        add(b1);


        b2 = new JButton("Cancel");
        b2.setBounds(220,450,130,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

/////////////////////////////////////////////////////////////////////////////////


        setLayout(null);
        setBounds(500,180,600,550);
        setVisible(true);

    }







    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){

            String name = t1.getText();
            String age = t2.getText();
            String car_company = t3.getText();
            String model = t4.getText();
            String available = (String)c1.getSelectedItem();
            String location = t5.getText();

            ///////////////////////////////////////////////////

            String gender = null;
            if(r1.isSelected()){
                gender = "male";
            }
            else if(r2.isSelected()){
                gender = "female";
            }

            ///////////////////////////////////////////////////////////////////////////////

            conn c = new conn();

            String str = "insert into driver values ('"+name+"','"+age+"','"+gender+"','"+car_company+"','"+model+"','"+available+"','"+location+"')";
            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Driver Added!");
                this.setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }

            ///////////////////////////////////////////////////////////////////////////////

        }
        else if (ae.getSource()==b2){
            this.setVisible(false);
        }
    }


    public static void main(String[] args) {
        new AddDriver().setVisible(true);
    }
}
