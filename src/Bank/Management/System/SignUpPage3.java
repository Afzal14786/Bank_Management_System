package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.*;

public class SignUpPage3 extends JFrame implements ActionListener {
    String formNo;
    JButton submit, cancle, back;
    JCheckBox infoStatement;
    JRadioButton saving, current,fixDeposit,recDepAcc;
    JLabel atmCard,mobileBanking,internateBanking,chequBook,emailAlerts,eStatement;
        public SignUpPage3(String formNo) {
            super("APPLICATION FORM");
            ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Icons/3dBank.png"));
            Image ii = i.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(ii);
            JLabel bank = new JLabel(i3);
            bank.setBounds(100,5,150,150);
            add(bank);
            /**
             * Page No
             */
            JLabel pageNo = new JLabel("Page No :   3");
            pageNo.setFont(new Font("Realway", BOLD,20));
            pageNo.setBounds(570,12,180,30);
            add(pageNo);
            /**
             * Form No Primary Key
             */
            this.formNo = formNo;
            JLabel form = new JLabel("Form No : " + formNo);
            form.setFont(new Font("Realway", BOLD,20));
            form.setBounds(570,45,180,30);
            add(form);
            /**
             * Account Details
             */
            JLabel accountDet = new JLabel("Account Details");
            accountDet.setFont(new Font("Realway",BOLD,25));
            accountDet.setBounds(320,90, 250,30);
            add(accountDet);
            /**
             * Account Type
             */
            JLabel accType = new JLabel("Account Type :");
            accType.setFont(new Font("Realway", Font.BOLD,22));
            accType.setBounds(100,160,250,30);
            add(accType);
            /**
             * Account Types : Radio Buttons
             *      1. Saving
             *      2. Salary
             *      3. Fixed Deposit
             *      4. Recurring Deposit Account
             */
            saving = new JRadioButton("Saving Account");
            saving.setFont(new Font("Realway",BOLD,16));
            saving.setBackground(new Color(160, 234, 245, 255));
            saving.setBounds(130,190,150,30);
            add(saving);

            current = new JRadioButton("Current Account");
            current.setFont(new Font("Realway",BOLD,16));
            current.setBackground(new Color(160, 234, 245, 255));
            current.setBounds(400,190,200,30);
            add(current);

            fixDeposit = new JRadioButton("Fixed Deposit Account");
            fixDeposit.setFont(new Font("Realway", Font.BOLD,16));
            fixDeposit.setBackground(new Color(160, 234, 245, 255));
            fixDeposit.setBounds(130, 220, 250, 30);
            add(fixDeposit);

            recDepAcc = new JRadioButton("Recurring Deposit Account");
            recDepAcc.setFont(new Font("Realway", BOLD,16));
            recDepAcc.setBackground(new Color(160, 234, 245, 255));
            recDepAcc.setBounds(400,220,300,30);
            add(recDepAcc);
            /**
             * Group the account types
             */
            ButtonGroup group = new ButtonGroup();
            group.add(saving);
            group.add(current);
            group.add(fixDeposit);
            group.add(recDepAcc);
            /**
             * Card and Card No :
             */
            JLabel card = new JLabel("Card No :");
            card.setFont(new Font("Realway", BOLD,22));
            card.setBounds(100,260,100,30);
            add(card);

            JLabel cardDigit = new JLabel("(Your 16-digit Card No)");
            cardDigit.setFont(new Font("Realway", ITALIC,14));
            cardDigit.setBounds(100,285,300,20);
            add(cardDigit);

            JLabel cardNo = new JLabel("XXXX-XXXX-XXXX-2387");
            cardNo.setFont(new Font("Realway",BOLD,18));
            cardNo.setBounds(400,260,300,30);
            add(cardNo);

            JLabel cardMsg = new JLabel("(It would appear in Atm Card, Cheque Book & Mini-Statement)");
            cardMsg.setFont(new Font("Realway", ITALIC,14));
            cardMsg.setBounds(400,285,500,20);
            add(cardMsg);
            /**
             * Atm Pin
             */
            JLabel pin = new JLabel("PIN No :");
            pin.setFont(new Font("Realway",BOLD,22));
            pin.setBounds(100, 315,150,30);
            add(pin);

            JLabel pinMsg = new JLabel("(Your 4-digit ATM Pin)");
            pinMsg.setFont(new Font("Realway", ITALIC,14));
            pinMsg.setBounds(100,340,200,20);
            add(pinMsg);

            JLabel pinNo = new JLabel("XXXX");
            pinNo.setFont(new Font("Realway", BOLD,18));
            pinNo.setBounds(400,315,90,30);
            add(pinNo);
            /**
             * Services You Want
             */
            JLabel services = new JLabel("Our Services :");
            services.setFont(new Font("Realway", BOLD,22));
            services.setBounds(100,360,200,39);
            add(services);
            /**
             * Services like :
             *      1. ATM Card
             *      2. Mobile Banking
             *      3. Internet Banking
             *      4. E-Statement
             *      5 Cheque Book
             *      6 Email Alerts
             */
            atmCard = new JLabel("ATM Card");
            atmCard.setFont(new Font("Realway",BOLD,16));
            atmCard.setBackground(new Color(160, 234, 245, 255));
            atmCard.setBounds(130,395,150,30);
            add(atmCard);

            chequBook = new JLabel("Cheque Book");
            chequBook.setFont(new Font("Realway", BOLD,16));
            chequBook.setBackground(new Color(160, 234, 245, 255));
            chequBook.setBounds(400,395,200,30);
            add(chequBook);

            mobileBanking = new JLabel("Mobile Banking");
            mobileBanking.setFont(new Font("Realway",BOLD,16));
            mobileBanking.setBackground(new Color(160, 234, 245, 255));
            mobileBanking.setBounds(130,425,200,30);
            add(mobileBanking);

            internateBanking = new JLabel("Internet Banking");
            internateBanking.setFont(new Font("Realway",BOLD,16));
            internateBanking.setBackground(new Color(160, 234, 245, 255));
            internateBanking.setBounds(400,425,200,30);
            add(internateBanking);

            emailAlerts = new JLabel("Email Alerts");
            emailAlerts.setFont(new Font("Realway",BOLD,16));
            emailAlerts.setBackground(new Color(160, 234, 245, 255));
            emailAlerts.setBounds(130,455,200,30);
            add(emailAlerts);

            eStatement = new JLabel("E-Statement");
            eStatement.setFont(new Font("Realway",BOLD,16));
            eStatement.setBackground(new Color(160, 234, 245, 255));
            eStatement.setBounds(400,455,250,30);
            add(eStatement);
            /**
             *  check the box, if your information is true
             */
            infoStatement = new JCheckBox("I here by declares that all the above entered information are correct to the best of my knowladge." ,true);
            infoStatement.setFont(new Font("Realway",ITALIC,14));
            infoStatement.setBackground(new Color(160, 234, 245, 255));
            infoStatement.setBounds(100,510,1000,20);
            add(infoStatement);
            /**
             * Buttons :
             *      1. Back
             *      2. Cancle
             *      3. Submit
             */

            back = new JButton("Back");
            back.setFont(new Font("Realway",BOLD,16));
            back.setForeground(Color.BLACK);
            back.setBackground(Color.GRAY);
            back.setBounds(130,580,100,30);
            back.addActionListener(this);
            add(back);

            cancle = new JButton("Cancle");
            cancle.setFont(new Font("Realway", BOLD,16));
            cancle.setForeground(Color.BLACK);
            cancle.setBackground(Color.GRAY);
            cancle.setBounds(570,580,100,30);
            cancle.addActionListener(this);
            add(cancle);

            submit = new JButton("Submit");
            submit.setFont(new Font("Realwaly",BOLD,16));
            submit.setBackground(Color.GRAY);
            submit.setForeground(Color.BLACK);
            submit.setBounds(335,640,100,30);
            submit.addActionListener(this);
            add(submit);
            /**
             * Frame
             */
            getContentPane().setBackground(new Color(160, 234, 245, 255));
            setSize(850,750);
            setLocation(200,0);
            setLayout(null);
            setVisible(true);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Connection Building
         */

        String accountType = "";
        if (saving.isSelected()) {
            accountType = "Saving";
        } else if (current.isSelected()) {
            accountType = "Current Account";
        } else if (fixDeposit.isSelected()) {
            accountType = "Fixed Deposit Account";
        } else if (recDepAcc.isSelected()) {
            accountType = "Recurring Deposit Account";
        }

        try {
            if (e.getSource() == submit) {

                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null,"@error: " + "Please Select Your Account Type");
                    return;
                } else {
                    Cons connection = new Cons();
                    String query = "insert into SignUpPage3 Values('"+formNo+"', '"+accountType+"')";
                    connection.statement.executeUpdate(query);
                    setVisible(false);
                    JOptionPane.showMessageDialog(null,"It Will Take Few Seconds To Generate Your Form\n" + "Kindely Wait 😊");
                    new FinalApplicationForm(formNo);

                }
            } else if (e.getSource() == cancle) {
                int option = JOptionPane.showConfirmDialog(null,"Are You Sure You Want To Cancel SignUp Form ?", "Confirm",JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else if (option == JOptionPane.NO_OPTION) {
                    /**
                     * Do Nothing just stay on the same page
                     */
                }

            } else if (e.getSource() == back) {
                setVisible(false);
                new SignUpPage2(formNo);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "@error: " + exception);
            return;
        }
    }

    public static void main(String[] args) {
        new SignUpPage3("");
    }
}
