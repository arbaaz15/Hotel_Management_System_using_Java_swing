package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1,b2;
    JLabel title;


    public AddEmployee(){

        title = new JLabel("ADD EMPLOYEE DETAILS");
        title.setBounds(180,0,300,40);
        title.setFont(new Font("Tahoma",Font.BOLD,20));
        title.setForeground(Color.RED);
        title.setBackground(Color.black);
        add(title);



        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,50,120,30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(200,50,150,30);
        add(t1);

//////////////////////////////////////////////////////////////////////////////////

        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,100,120,30);
        add(age);

        t2 = new JTextField();
        t2.setBounds(200,100,150,30);
        add(t2);

//////////////////////////////////////////////////////////////////////////////////

        JLabel gender = new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,150,120,30);
        add(gender);

        r1 = new JRadioButton("Male");
        r1.setBounds(200,150,70,30);
        r1.setFont(new Font("Tahoma",Font.PLAIN,14));
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(280,150,70,30);
        r2.setFont(new Font("Tahoma",Font.PLAIN,14));
        r2.setBackground(Color.white);
        add(r2);

////////////////////////////////////////////////////////////////////////////////////

        JLabel job = new JLabel("JOB");
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        job.setBounds(60,200,120,30);
        add(job);

        String str[] = {"Front Desk Clerk","Housekeeping","Kitchen Staff","Chief","Manager","Accountant","Kitchen Staff","Kitchen/Waiter"};
        c1 = new JComboBox(str);
        c1.setBounds(200,200,150,30);
        c1.setBackground(Color.white);
        add(c1);

////////////////////////////////////////////////////////////////////////////////////

        JLabel salary = new JLabel("SALARY");
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        salary.setBounds(60,250,120,30);
        add(salary);

        t3 = new JTextField();
        t3.setBounds(200,250,150,30);
        add(t3);

////////////////////////////////////////////////////////////////////////////////////

        JLabel phone = new JLabel("PHONE NO.");
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        phone.setBounds(60,300,120,30);
        add(phone);

        t4 = new JTextField();
        t4.setBounds(200,300,150,30);
        add(t4);

////////////////////////////////////////////////////////////////////////////////////

        JLabel aadhar = new JLabel("AADHAR NO.");
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        aadhar.setBounds(60,350,120,30);
        add(aadhar);

        t5 = new JTextField();
        t5.setBounds(200,350,150,30);
        add(t5);

////////////////////////////////////////////////////////////////////////////////////

        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        email.setBounds(60,400,120,30);
        add(email);

        t6 = new JTextField();
        t6.setBounds(200,400,150,30);
        add(t6);

////////////////////////////////////////////////////////////////////////////////////

        b1 = new JButton("Add Employee");
        b1.setBounds(60,470,130,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(220,470,130,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        add(b2);

////////////////////////////////////////////////////////////////////////////////////

        setLayout(null);
        setBounds(500,150,600,580);
        setVisible(true);
    }

///////////////////////////////////////////////////////////////////////////////


    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==b1) {

            String name = t1.getText();
            String age = t2.getText();
            String salary = t3.getText();
            String phone = t4.getText();
            String aadhar = t5.getText();
            String email = t6.getText();

    ///////////////////////////////////////////////////

            String gender = null;
            if (r1.isSelected()) {
                gender = "male";
            } else if (r2.isSelected()) {
                gender = "female";
            }

            ////////////////////////////////////////////////////

            String job = (String) c1.getSelectedItem();

            ////////////////////////////////////////////////////

            conn c = new conn();

            String str = "insert into employee values ('" + name + "','" + age + "','" + gender + "','" + job + "','" + salary + "','" + phone + "','" + aadhar + "','" + email + "')";
            try {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Employee Added!");
                this.setVisible(false);


            } catch (Exception e) {
                System.out.println(e);
            }

///////////////////////////////////////////////////////////////////////////////

        }else if (ae.getSource()==b2){
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddEmployee().setVisible(true);
    }

}
