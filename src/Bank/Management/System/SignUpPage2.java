package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage2 extends JFrame implements ActionListener {
    String formNo;
    JComboBox religiousDropDown, categoryDropDown, Income,qualification,occupition;
    JTextField panNo, aadharNo, phoneNo;
    JRadioButton isSenior, isSeniorNo, existY, existNo;
    JButton next, back;

    public SignUpPage2(String formNo) {
        super("APPLICATION FORM");

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Icons/3dBank.png"));
        Image ii = i.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(ii);
        JLabel bank = new JLabel(i3);
        bank.setBounds(120,20,150,150);
        add(bank);
        /**
         * page no
         */
        JLabel pageNo = new JLabel("Page No : 2");
        pageNo.setFont(new Font("Raleway", Font.BOLD,20));
        pageNo.setBounds(570,8,500,30);
        add(pageNo);

        this.formNo = formNo;
        JLabel form = new JLabel("Form No : " + formNo);
        form.setFont(new Font("Realway", Font.BOLD, 20));
        form.setBounds(570, 35, 300,30);
        add(form);

        /**
         * additional details
         */
        JLabel additinalDetails = new JLabel("Additional Details");
        additinalDetails.setFont(new Font("Realway", Font.BOLD, 22));
        additinalDetails.setBounds(370,100,500,40);
        add(additinalDetails);
        /**
         *Religious and drop down list
         */
        JLabel religious = new JLabel("Religious :");
        religious.setFont(new Font("Realway", Font.BOLD,22));
        religious.setBounds(100, 210, 200, 30);
        add(religious);

        String dropRelig[] = {"Religious", "Indian" ,"Muslim", "Hindu" ,"Sikh", "Christian", "Jain", "Buddha", "Other"};
        religiousDropDown = new JComboBox(dropRelig);
        religiousDropDown.setBackground(new Color(225,225,204));
        religiousDropDown.setFont(new Font("Realway", Font.BOLD, 16));
        religiousDropDown.setBounds(450, 210, 300, 30);
        add(religiousDropDown);

        /**
         * catogary
         */
        JLabel cat = new JLabel("Category :");
        cat.setFont(new Font("Realway", Font.BOLD,22));
        cat.setBounds(100,260,200,30);
        add(cat);

        String categoryarr[] = {"Category", "General", "OBC", "ST/SC", "Other"};
        categoryDropDown = new JComboBox(categoryarr);
        categoryDropDown.setBackground(new Color(225,225,204));
        categoryDropDown.setFont(new Font("Realway", Font.BOLD,16));
        categoryDropDown.setBounds(450,260,300,30);
        add(categoryDropDown);

        /**
         * Income
         */
        JLabel income = new JLabel("Annual Income :");
        income.setFont(new Font("Realway", Font.BOLD,22));
        income.setBounds(100,310,350,30);
        add(income);

        String incomeDet[] = { "N/A","50000", "100000", "200000", "500000", "1000000"};
        Income = new JComboBox(incomeDet);
        Income.setBackground(new Color(225,225,204));
        Income.setFont(new Font("Realway", Font.BOLD,16));
        Income.setBounds(450,310,300,30);
        add(Income);
        /**
         * Education qualification
         */
        JLabel edu = new JLabel("Educationl Details");
        edu.setFont(new Font("Realway", Font.BOLD,24));
        edu.setBounds(225,370,300,30);
        add(edu);

        JLabel Qualification = new JLabel("Qualification :");
        Qualification.setFont(new Font("Realway", Font.BOLD,22));
        Qualification.setBounds(100, 420, 300, 30);
        add(Qualification);

        String quali[] = {"N/A","8th Pass","10th Pass", "12th Pass", "Graduation", "Pursuing Graduation"};
        qualification = new JComboBox(quali);
        qualification.setBackground(new Color(225,225,204));
        qualification.setFont(new Font("Realway", Font.BOLD,16));
        qualification.setBounds(450,420,300,30);
        add(qualification);

        JLabel occup = new JLabel("Occupation :");
        occup.setFont(new Font("Realway", Font.BOLD, 22));
        occup.setBounds(100,460,300,30);
        add(occup);

        String occupation[] = {"Occupation","UnEmployee","Student","Fresher","Salaried", "Self-Employee", "Business", "Retaired", "Other"};
        occupition = new JComboBox(occupation);
        occupition.setBackground(new Color(225,225,204));
        occupition.setFont(new Font("Realway", Font.BOLD,16));
        occupition.setBounds(450,460,300,30);
        add(occupition);



        /**
         * Aadhar No, Pan No and Phone No
         */
        JLabel aadhar = new JLabel("Aadhar No :");
        aadhar.setFont(new Font("Realway", Font.BOLD, 22));
        aadhar.setBounds(100, 500, 250, 30);
        add(aadhar);

        aadharNo = new JTextField();
        aadharNo.setBackground(new Color(225,225,204));
        aadharNo.setFont(new Font("Realway", Font.BOLD,16));
        aadharNo.setBounds(450,500,300,30);
        add(aadharNo);

        JLabel pan = new JLabel("Pan No :");
        pan.setFont(new Font("realway", Font.BOLD,22));
        pan.setBounds(100,540,90,30);
        add(pan);

        panNo = new JTextField();
        panNo.setBackground(new Color(225,225,204));
        panNo.setFont(new Font("Realway", Font.BOLD,16));
        panNo.setBounds(450,540,300,30);
        add(panNo);

        JLabel exist = new JLabel("Phone Number : ");
        exist.setFont(new Font("Realway", Font.BOLD,22));
        exist.setBounds(100, 580, 200,30);
        add(exist);

        phoneNo = new JTextField();
        phoneNo.setFont(new Font("Realway", Font.BOLD, 16));
        phoneNo.setBackground(new Color(225,225,204));
        phoneNo.setBounds(450, 580, 300,30);
        add(phoneNo);
        /**
         * Sinor Citizen with radio buttons : yes / No
         */
        JLabel senior = new JLabel("Senior Citizen");
        senior.setFont(new Font("realway",Font.BOLD,22));
        senior.setBounds(100,620,250,30);
        add(senior);

        isSenior = new JRadioButton("Yes");
        isSenior.setFont(new Font("Realway", Font.BOLD,16));
        isSenior.setBackground(new Color(225,225,204));
        isSenior.setBounds(450,620,60,30);
        add(isSenior);

        isSeniorNo = new JRadioButton("No", true);
        isSeniorNo.setBackground(new Color(225,225,204));
        isSeniorNo.setFont(new Font("Realway", Font.BOLD,16));
        isSeniorNo.setBounds(580,620,60,20);
        add(isSeniorNo);

        ButtonGroup grp = new ButtonGroup();
        grp.add(isSenior);
        grp.add(isSeniorNo);
        /**
         * Buttons : Next / Back
         */

        next = new JButton("Next");
        next.setFont(new Font("Realway", Font.BOLD, 14));
        next.setBackground(Color.GRAY);
        next.setForeground(Color.BLACK);
        next.setBounds(580, 680,100,30);
        next.addActionListener(this);
        add(next);

        back = new JButton("Back");
        back.setFont(new Font("Realway", Font.BOLD,14));
        back.setBackground(Color.GRAY);
        back.setForeground(Color.BLACK);
        back.setBounds(100,680,100,30);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setSize(850,750);
        setLocation(200,0);
        getContentPane().setBackground(new Color(225,225,204));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String religious = (String) religiousDropDown.getSelectedItem();
        String cato = (String) categoryDropDown.getSelectedItem();
        String income = (String) Income.getSelectedItem();
        String education = (String) qualification.getSelectedItem();
        String occup = (String) occupition.getSelectedItem();
        String aadhar_no = (String) aadharNo.getText();
        String pan = (String) panNo.getText().toUpperCase();
        String phoneNO = (String) phoneNo.getText();

        String sCitizen = "";
        if (isSenior.isSelected()) {
            sCitizen = "Yes";
        } else if (isSeniorNo.isSelected()) {
            sCitizen = "No";
        }

        /**
         * Connection Building
         */
        try {
            /**
             * Back Button Events
             */
            if (e.getSource() == back) {
                setVisible(false);
                new SignUp();
                return;
            } else {
                if (aadharNo.getText().equals("") || panNo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                    return;
                } else if (religiousDropDown.equals("Religious")) {
                    JOptionPane.showMessageDialog(null, "Please Select Your Religious");
                    return;
                } else if (categoryDropDown.equals("Category")) {
                    JOptionPane.showMessageDialog(null, "Please Select Your Category");
                    return;
                } else {
                    Cons connection = new Cons();
                    String query = "insert into SignUpPage2 Values('"+formNo+"','"+religious+"', '"+cato+"', '"+income+"', '"+education+"', '"+occup+"', '"+aadhar_no+"', '"+pan+"', '"+sCitizen+"', '"+phoneNO+"')";
                    connection.statement.executeUpdate(query);
                    setVisible(false);
                    new SignUpPage3(formNo);
                }
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "@error: " + exception);
            return;
        }
    }
    public static void main(String[] args) {
        new SignUpPage2("");
    }
}
