package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import static java.awt.Font.BOLD;

public class FinalApplicationForm extends JFrame implements ActionListener{
        // lables
        JLabel jlable, jlable1, jlabel2;
        // text fields
        JButton back, submit;
        String formNo;
        JCheckBox description;
        JLabel name,father_name,DOB,gender,email_id,marital_status,religious, category,
                annual_income,education,occupation,
                addhar_no,pan_no,account_type,state, District, village_area,pinCode, servicesDescription;
        Random random;
    /**
     * lables
     *
     * @param formNo
     */
    FinalApplicationForm(String formNo) {
            super("Details Application");

            /**
             * @pargram
             * Bank Logo image
             */
            ImageIcon bck = new ImageIcon(ClassLoader.getSystemResource("Icons/formDetailsApplication.jpg"));
            Image bckImage = bck.getImage().getScaledInstance(1000,775,Image.SCALE_DEFAULT);
            ImageIcon bckImage2 = new ImageIcon(bckImage);
            JLabel formImage = new JLabel(bckImage2);
            formImage.setBounds(0,0,1000,775);
            add(formImage);

            ImageIcon i =  new ImageIcon(ClassLoader.getSystemResource("Icons/3dBank.png"));
            Image i2 = i.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(10,0,150,150);
            formImage.add(image);

            ImageIcon money = new ImageIcon(ClassLoader.getSystemResource("Icons/3DCARD.png"));
            Image money1 = money.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
            ImageIcon moneyCard = new ImageIcon(money1);
            JLabel moneyCard2 = new JLabel(moneyCard);
            moneyCard2.setBounds(450,290,350,350);
            formImage.add(moneyCard2);

            servicesDescription = new JLabel("(Save Your Savings 💰 In Our Bank 🏧)");
            servicesDescription.setFont(new Font("cursive", Font.ITALIC,15));
            servicesDescription.setBounds(510,580,800,18);
            formImage.add(servicesDescription);

            /**
             * Form No :
             */
            // we need to rediresct the form no from signUp page 3
            this.formNo = formNo;
            JLabel form = new JLabel("Form No : " + formNo);
            form.setFont(new Font("cursive", Font.PLAIN,20));
            form.setBounds(650,30,150,30);
            formImage.add(form);
            /**
             * Lables //
             */
            jlable = new JLabel("WELCOME TO ONLINE ATM SERVICES");
            jlable.setFont( new Font("cursive", BOLD,30));
            jlable.setBounds(210,70,700,40);
            formImage.add(jlable);
            /**
             * Get the informations form database and print it in the final information form
             */
            name = new JLabel();
            name.setFont(new Font("cursive", Font.PLAIN,18));
            name.setBounds(70,160,700,30);
            formImage.add(name);

            state = new JLabel();
            state.setFont(new Font("cursive", Font.PLAIN,18));
            state.setBounds(500,160,400,30);
            formImage.add(state);

            District = new JLabel();
            District.setFont(new Font("cursive", Font.PLAIN,18));
            District.setBounds(500,200,600,30);
            formImage.add(District);

            village_area = new JLabel();
            village_area.setFont(new Font("cursive", Font.PLAIN,18));
            village_area.setBounds(500,240,500,30);
            formImage.add(village_area);

            pinCode = new JLabel();
            pinCode.setFont(new Font("cursive", Font.PLAIN,18));
            pinCode.setBounds(500,280,500,30);
            formImage.add(pinCode);

            father_name = new JLabel();
            father_name.setFont(new Font("cursive", Font.PLAIN,18));
            father_name.setBounds(70,200,700,30);
            formImage.add(father_name);

            DOB = new JLabel();
            DOB.setFont(new Font("cursive", Font.PLAIN,18));
            DOB.setBounds(70,240,300,30);
            formImage.add(DOB);

            gender = new JLabel();
            gender.setFont(new Font("cursive", Font.PLAIN,18));
            gender.setBounds(70,280,300,30);
            formImage.add(gender);

            email_id= new JLabel();
            email_id.setFont(new Font("cursive", Font.PLAIN,18));
            email_id.setBounds(70,320,900,30);
            formImage.add(email_id);

            marital_status= new JLabel();
            marital_status.setFont(new Font("cursive", Font.PLAIN,18));
            marital_status.setBounds(70,360,700,30);
            formImage.add(marital_status);

            annual_income= new JLabel();
            annual_income.setFont(new Font("cursive", Font.PLAIN,18));
            annual_income.setBounds(500,320,600,30);
            formImage.add(annual_income);

            religious= new JLabel();
            religious.setFont(new Font("cursive", Font.PLAIN,18));
            religious.setBounds(70,400,400,30);
            formImage.add(religious);

            education= new JLabel();
            education.setFont(new Font("cursive", Font.PLAIN,18));
            education.setBounds(70,440,800,30);
            formImage.add(education);

            occupation= new JLabel();
            occupation.setFont(new Font("cursive", Font.PLAIN,18));
            occupation.setBounds(70,480,800,30);
            formImage.add(occupation);

            addhar_no= new JLabel();
            addhar_no.setFont(new Font("cursive", Font.PLAIN,18));
            addhar_no.setBounds(70,520,1000,30);
            formImage.add(addhar_no);

            pan_no= new JLabel();
            pan_no.setFont(new Font("cursive", Font.PLAIN,18));
            pan_no.setBounds(70,560,900,30);
            formImage.add(pan_no);

            account_type= new JLabel();
            account_type.setFont(new Font("cursive", Font.PLAIN,18));
            account_type.setBounds(70,600,755,30);
            formImage.add(account_type);
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------>
/**
 * @pargram
 * Inside this line wi try to fatch all the datas form different table and display all the data as final application form
 */
            /**
             * @pargram
             * all the information collected form SignUp DataTable 1
             */

            try {
                    Cons connection = new Cons();
                    ResultSet resultSet = connection.statement.executeQuery("select * from SignUp");
                    while (resultSet.next()) {
                           name.setText("<html><b>Name : <b>" + "<i>" + resultSet.getString("name") + "<i><html>");
                           father_name.setText("<html><b>Father Name : <b>" + "<i>" + resultSet.getString("father_name")+"<i><html>");
                           DOB.setText("<html><b>DOB : <b>" + resultSet.getString("DOB") + "<html>");
                           gender.setText("<html><b>Gender : <b>" + "<i>" + resultSet.getString("gender") + "<i><html>");
                           email_id.setText("<html><b>Email Id :<b> " +"<i>" + resultSet.getString("email_id") + "<i><html>");
                           marital_status.setText("<html><b>Marital Status :<b>" +"<i>"+ resultSet.getString("marital_status")+ "<i><html>");
                           state.setText("<html><b>State : <b>" + "<i>" + resultSet.getString("state") + "<i><html>");
                           District.setText("<html><b>District : <b>"+"<i>"+ resultSet.getString("district") + "<i><html>");
                           village_area.setText("<html><b>Village/Area :<b> " +"<i>" + resultSet.getString("village_area") + "<i><html>");
                           pinCode.setText("<html><b>Pin Code : " + resultSet.getString("pin_code") +"<b><html>");
                    }
            }catch (Exception E) {
                    JOptionPane.showMessageDialog(null,"@error: " + E);
                    return;
            }
            /**
             * @pargram
             * all the information collect from SignUp DataTable 2
             */
            try {
                    Cons connection = new Cons();
                    ResultSet resultSet = connection.statement.executeQuery("select * from SignUpPage2");
                    while (resultSet.next()) {
                            religious.setText("<html><b>Religious : <b>" + "<i>" + resultSet.getString("religious") + "<i><html>");
                            annual_income.setText("<html><b>Annual Income :<b>" +"<i>" + resultSet.getString("annual_income") + "<i><html>");
                            education.setText("<html><b>Education :<b>" +"<i>"+ resultSet.getString("qualification") + "<i><html>");
                            occupation.setText("<html><b>Profession :<b>" +"<i>"+ resultSet.getString("occupation") + "<i><html>");
                            addhar_no.setText("<html><b>Aadhar No :<b>" +"<i>"+ resultSet.getString("aadhar_no")+"<i><html>");
                            pan_no.setText("<html><b>Pan No :<b>" +"<i>"+ resultSet.getString("pan_no") + "<i><html>");
                    }

            } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "@error: " + exception);
                    return;
            }

            /**
             * @pargram
             *   get all the information of signUp DataTable 3
             */
            try {
                    Cons connection = new Cons();
                    ResultSet resultSet = connection.statement.executeQuery("select * from SignUpPage3");
                    while (resultSet.next()) {
                            account_type.setText("<html><b>Account Type :<b>" +"<i>"+ resultSet.getString("account_type") + "<i><html>");
                    }
            } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "@error: " + ex);
                    return;
            }
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------>
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------>
/**
 * @pargarm
         * inside this line we try to implement buttons and checked description
 */
            description = new JCheckBox("check the box If all the information mantion above, are correct from your knowledge, and proceed" );
            description.setFont(new Font("cursive",Font.ITALIC,12));
            description.setBackground(null);
            description.setBounds(110,640,560,20);
            formImage.add(description);
            /**
             * Back Button
             */
            back = new JButton("BACK");
            back.setFont(new Font("Arial", BOLD,18));
            back.setBounds(130,680,100,30);
            back.addActionListener(this);
            formImage.add(back);

            submit = new JButton("SUBMIT");
            submit.setFont(new Font("Arial", BOLD,18));
            submit.setBounds(600,680,120,30);
            submit.addActionListener(this);
            formImage.add(submit);
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------>
/**
 * @pargram
                 *"The Frame Layout"
 */
            setLayout(null);
            setSize(1000, 775);
            setLocation(200, 0);
            setVisible(true);
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------>
        }
    @Override
    public void actionPerformed(ActionEvent e) {
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------>
/**
 * @pargram
                 * Randon card No and Random Pin No  and a User ID Generating
                 *      and Select the services and store it in database
 */
            random = new Random();
            /**
             * @pargram
             * Account Number with some unique number
             */
            String firstUniqueDigits = "502000";
            String lastUniqueDigits = "6500";
            int randonAcccountNumber = random.nextInt(90000) + 10000;
            String accountNumber = firstUniqueDigits + randonAcccountNumber + lastUniqueDigits;
            /**
             * @pargram
             * Random Card Number :
             */
            long randon_card_no = (random.nextLong() % 9000000000000L) + 5892000000006500L;
            String card_no = "" + Math.abs(randon_card_no);

            /**
             * @pargram
             * Card Pin Will be 6 Digits
             */
            long random_pin_no = (random.nextInt() % 900000) + 100000;
            String pin_no = "" + Math.abs(random_pin_no);
            /**
             * IFSC CODE
             */

            String ifsc = "OAS0001177";


//<------------------------------------------------------------------------------------------------------------------------------------------------------------------>
/**
 * @pargram
         * Button Implementations
 */
            /**
             * @pergram
             * Submit Button Event and Store all the data in a new data table, name as Customer_Infornation
             */
            try {
                if (e.getSource() == submit) {
                        if (!description.isSelected()) {
                                JOptionPane.showMessageDialog(null,"Please Checked The Box If \n All The Information Entered By You Is Correct");
                                return;
                        } else {

                                Cons connection = new Cons();
                                connection.statement.executeUpdate("insert into customer_details Values('"+card_no+"', '"+pin_no+"', '"+accountNumber+"', '"+ifsc+"')");
                                connection.statement.executeUpdate("insert into Login Values('"+card_no+"', '"+pin_no+"')");
                                JOptionPane.showMessageDialog(null,"Please Note Down Your Account Number, Card Number & Pin No\n" + "Account Number : " + accountNumber + "\n Card Number : " + card_no + "\n Pin No : " + pin_no);
                                JOptionPane.showMessageDialog(null, "Thanking   🙏   For Being A Part Of Our Orgenisation\n Please Login Your Self For Making Your First Deposit");
                                setVisible(false);
                                new WelcomeFrame(pin_no);
                        }

                } else {
                        if (e.getSource() == back) {
                                int option = JOptionPane.showConfirmDialog(null,"Are You Sure You Want To Go Back","Confirmation",JOptionPane.YES_NO_OPTION);
                                if (option == JOptionPane.YES_OPTION) {
                                        setVisible(false);
                                        new SignUpPage3(formNo);
                                }
                        }
                }
        } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "@Error  " + e1);
                e1.printStackTrace();
                return;
        }
//<------------------------------------------------------------------------------------------------------------------------------------------------------------------>
    }
    public static void main(String[] args) {
        new FinalApplicationForm("");
    }
}
