package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements  ActionListener {

    JLabel l1,l2;
    JTextField t1, t2;
    JButton b1,b2;

    public Login(){

    l1 = new JLabel("User Name");
    l1.setBounds(40,20,100,30);
    add(l1);

    l2 = new JLabel("Password");
    l2.setBounds(40,70,100,30);
    add(l2);

/////////////////////////////////////////////////////////////////

    t1 = new JTextField();
    t1.setBounds(150,20,150,30);
    add(t1);

    t2 = new JPasswordField();
    t2.setBounds(150,70,150,30);
    add(t2);

///////////////////////////////////////////////////////////////////

    b1 = new JButton("Login");
    b1.setBackground(Color.black);
    b1.setForeground(Color.white);
    b1.setBounds(40,150,120,30);
    b1.addActionListener(this);
    add(b1);

    b2 = new JButton("Back");
    b2.setBackground(Color.black);
    b2.setForeground(Color.white);
    b2.setBounds(180,150,120,30);
    b2.addActionListener(this);
    add(b2);




    setLayout(null);
    setBounds(500,300,400,300);
    setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){

            String username = t1.getText();
            String password = t2.getText();
            conn c = new conn();
            System.out.println(username+" "+password);
            String str = "select * from login where username = '"+username+"' and password = '"+password+"'";

            try{
            ResultSet rs = c.s.executeQuery(str);

                    if(rs.next()){
                        new Dashboard().setVisible(true);
                        this.setVisible(false);
                        System.out.println("true");
                     }

                    else{
                        JOptionPane.showMessageDialog(null,"Invalid username and password");
                        this.setVisible(false);
                     }


            }catch(Exception e){
                System.out.println(e);
            }

        }

        else if(ae.getSource()==b2){
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        new Login();
    }
}
