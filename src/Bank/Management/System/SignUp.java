    package Bank.Management.System;
    import com.toedter.calendar.JDateChooser;
     import javax.swing.*;
     import java.awt.*;
     import java.awt.event.ActionEvent;
     import java.awt.event.ActionListener;
     import java.util.Random;

    public class SignUp extends JFrame implements ActionListener{
    JRadioButton male,female, other,other1, married, single;
    JTextField tName,tFname, tEmail, tMstatus, tState, villageArea, tDistrict, tPin;
    JDateChooser dateChooser;
    Random random = new Random();
    long first4 = (random.nextLong()% 9000L) + 1000L;
    String newRandomNo = " " + Math.abs(first4);
    JButton next, clear;
    SignUp() {
        super("APPLICATION FORM");
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Icons/3dBank.png"));
        Image i1 = i.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel bank = new JLabel(i2);
        bank.setBounds(25,5,150,150);
        add(bank);
        /**
         * page No
         */
        JLabel pageNo = new JLabel("Page No : 1");
        pageNo.setFont(new Font("Ralway", Font.BOLD, 22));
        pageNo.setBounds(630,10,600,30);
        add(pageNo);
        /**
         * Application Form Lable
         */
        JLabel formNo = new JLabel("APPLICATION FORM NO : " + newRandomNo);
        formNo.setBounds(210,80,600,40);
        formNo.setFont(new Font("Raleway" , Font.BOLD, 38));
        add(formNo);

        /**
         * Personal Details
         */
        JLabel info = new JLabel("Personal Details");
        info.setFont(new Font("Ralway", Font.BOLD,22));
        info.setBounds(300,130,600,30);
        add(info);
        /**
         * Name
         */
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 190, 200, 30);
        add(name);
        /**
         * Name field
         */
        tName = new JTextField();
        tName.setFont(new Font("Raleway", Font.BOLD, 16));
        tName.setBounds(300,190,400,30);
        add(tName);
        /**
         * fathers name lable and field
         */
        JLabel fName = new JLabel("Father's Name :");
        fName.setFont(new Font("Raleway", Font.BOLD,20));
        fName.setBounds(100, 230, 200, 30);
        add(fName);

        tFname = new JTextField();
        tFname.setFont(new Font("Raleway", Font.BOLD,16));
        tFname.setBounds(300,230,400,30);
        add(tFname);

        /**
         * date of birth
         */
        JLabel dob = new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,270,200,30);
        add(dob);
        /**
         * Calender
         */
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(54,247,176));
        dateChooser.setBounds(300,270,200,30);
        add(dateChooser);
        /**
         * Gender
         */
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,310,200,30);
        add(gender);
        /**
         * radio buttons // male, female and other
         */
        male = new JRadioButton("Male", true);
        male.setFont(new Font("Raleway", Font.BOLD,16));
        male.setBackground(new Color(185,221,252));
        male.setBounds(300, 310, 60,30);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD,16));
        female.setBackground(new Color(185,221,252));
        female.setBounds(400,310,90,30);
        add(female);

        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway", Font.BOLD,16));
        other.setBackground(new Color(185,221,252));
        other.setBounds(530,310,70,30);
        add(other);
        /**
         * Group the buttons
         */
        ButtonGroup groupBtn = new ButtonGroup();
        groupBtn.add(male);
        groupBtn.add(female);
        groupBtn.add(other);
        /**
         * Email ID
         */
        JLabel email = new JLabel("Email ID :");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,350,200,30);
        add(email);

        tEmail = new JTextField();
        tEmail.setFont(new Font("Raleway", Font.BOLD,14));
        tEmail.setBounds(300,350,400,30);
        add(tEmail);
        /**
         * Maried status and it's radio buttons
         */
        JLabel maried = new JLabel("Marital Status :");
        maried.setFont(new Font("Raleway", Font.BOLD,20));
        maried.setBounds(100,390,200,30);
        add(maried);

        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.BOLD,16));
        married.setBackground(new Color(185,221,252));
        married.setBounds(300, 390, 90,30);
        add(married);

        single = new JRadioButton("Single", true);
        single.setFont(new Font("Raleway", Font.BOLD,16));
        single.setBackground(new Color(185,221,252));
        single.setBounds(400,390,90,30);
        add(single);

        other1 = new JRadioButton("Other");
        other1.setFont(new Font("Raleway", Font.BOLD,16));
        other1.setBackground(new Color(185,221,252));
        other1.setBounds(530,390,70,30);
        add(other1);

        ButtonGroup isYes = new ButtonGroup();
        isYes.add(married);
        isYes.add(single);
        isYes.add(other1);
        /**
         * address
         */
        JLabel address = new JLabel("Address Details");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(380,430,200,30);
        add(address);
        /**
         * State
         */
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,470,200,30);
        add(state);

        tState = new JTextField();
        tState.setFont(new Font("Raleway", Font.BOLD, 16));
        tState.setBounds(300,470,300,30);
        add(tState);
        /**
         * city
         */
        JLabel district = new JLabel("District :");
        district.setFont(new Font("Raleway", Font.BOLD, 20));
        district.setBounds(100,510,200,30);
        add(district);

        tDistrict = new JTextField();
        tDistrict.setFont(new Font("Raleway", Font.BOLD, 16));
        tDistrict.setBounds(300,510,300,30);
        add(tDistrict);
        /**
         * district
         */
        JLabel village_area =  new JLabel("Village/Area :");
        village_area.setFont(new Font("Raleway", Font.BOLD,20));
        village_area.setBounds(100,550,200,30);
        add(village_area);

        villageArea = new JTextField();
        villageArea.setFont(new Font("Raleway", Font.BOLD, 16));
        villageArea.setBounds(300, 550, 400, 30);
        add(villageArea);


        JLabel desc = new JLabel("Kindly Fill Your Full Address");
        desc.setFont(new Font("cursive", Font.ITALIC, 13));
        desc.setForeground(new Color(0x030341));
        desc.setBounds(300, 580, 200, 30);
        add(desc);

        /**
         * Pin Code
         */
        JLabel pin = new JLabel("Pin Code :");
        pin.setFont(new Font("Raleway", Font.BOLD,20));
        pin.setBounds(100,610,200,30);
        add(pin);

        tPin = new JTextField();
        tPin.setFont(new Font("Raleway", Font.BOLD,16));
        tPin.setBounds(300,610,225,30);
        add(tPin);
        /**
         * Buttons
         *      1. Next
         *      2. Clear
         */
        next = new JButton("NEXT");
        next.setFont(new Font("Raleway", Font.BOLD, 14));;
        next.setForeground(Color.black);
        next.setBackground(new Color(204,255,204));
        next.addActionListener(this);
        next.setBounds(620,690,100,30);
        add(next);

        clear = new JButton("CLEAR");
        clear.setFont(new Font("Raleway", Font.BOLD,14));
        clear.setForeground(Color.black);
        clear.setBackground(new Color(204,255,204));
        clear.addActionListener(this);
        clear.setBounds(150,690,100,30);
        add(clear);


      getContentPane().setBackground(new Color(185,221,252));
        setLayout(null);
        setSize(850, 950);
        setLocation(200,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == clear) {
                tName.setText("");
                tFname.setText("");
                tEmail.setText("");
                villageArea.setText("");
                tState.setText("");
                tDistrict.setText("");
                tPin.setText("");
                dateChooser.setDate(null);
                JOptionPane.showMessageDialog(null, "All Clear");
                return;
            }
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "@error: " + E);
            return;
        }

        String formNo = newRandomNo;
        String name = tName.getText();
        String father_name = tFname.getText();
        String DOB = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (other.isSelected()) {
            gender = "Others";
        }
        String email = tEmail.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (single.isSelected()) {
            marital = "Single";
        } else if (other1.isSelected()) {
            marital = "Other";
        }
        String state = tState.getText();
        String city = tDistrict.getText();
        String district = villageArea.getText();
        String pinCode = tPin.getText();

        try {
            if (tName.getText().equals("") || tFname.getText().equals("") || dateChooser.getDate().equals("")||tEmail.getText().equals("") || tState.getText().equals("") || tDistrict.getText().equals("") || villageArea.getText().equals("") || tPin.getText().equals("")) {
                JOptionPane.showMessageDialog(null, " @error : Please fill all the fields carefully");
                return;
          } else {
                Cons connection1 = new Cons();
                String query = "insert into SignUp values('"+formNo+"', '"+name+"', '"+father_name+"', '"+DOB+"', '"+gender+"', '"+email+"', '"+marital+"', '"+state+"', '"+city+"', '"+district+"', '"+pinCode+"')";
                connection1.statement.executeUpdate(query);
                new SignUpPage2(formNo);
                setVisible(false);
            }
        } catch (Exception E) {
            System.out.println("Something Went Wrong : Please try again latter " + E);
        }
    }
    public static void main(String[] args) {
        new SignUp();
    }
}