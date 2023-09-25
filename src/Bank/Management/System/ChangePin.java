package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ChangePin extends JFrame implements ActionListener {
    String pin_no;
    JPasswordField currentPin , newPin, reEnterPin;
    JButton submit,back;
    ChangePin(String pin_no) {
        this.pin_no = pin_no;
        /**
         * Atm Image
         */
        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("Icons/Atm.png"));
        Image i = atm.getImage().getScaledInstance(1366,768,Image.SCALE_DEFAULT);
        ImageIcon ii = new ImageIcon(i);
        JLabel atmImage = new JLabel(ii);
        atmImage.setBounds(0,0,1366,768);
        add(atmImage);
        /**
         * Change pin lables
         */
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(410,180,400,30);
        text.setFont(new Font("System",Font.BOLD,30));
        text.setForeground(Color.WHITE);
        atmImage.add(text);

        JLabel pin = new JLabel("CURRENT PIN :");
        pin.setBounds(370,250,150,25);
        pin.setFont(new Font("System",Font.BOLD,18));
        pin.setForeground(Color.WHITE);
        atmImage.add(pin);

        currentPin = new JPasswordField();
        currentPin.setBounds(595,250,150,30);
        currentPin.setFont(new Font("Raleway",Font.BOLD,18));
        currentPin.setBackground(new Color(153, 221, 238));
        currentPin.setForeground(Color.BLACK);
        atmImage.add(currentPin);

        JLabel newPinLable = new JLabel("ENTER NEW PIN :");
        newPinLable.setBounds(370,290,200,25);
        newPinLable.setFont(new Font("System",Font.BOLD,18));
        newPinLable.setForeground(Color.WHITE);
        atmImage.add(newPinLable);

        newPin = new JPasswordField();
        newPin.setBounds(595,290,150,30);
        newPin.setFont(new Font("Raleway",Font.BOLD,18));
        newPin.setBackground(new Color(153, 221, 238));
        newPin.setForeground(Color.BLACK);
        atmImage.add(newPin);

        JLabel reEnterPinLable = new JLabel("RE-ENTER PIN :");
        reEnterPinLable.setBounds(370,335,200,25);
        reEnterPinLable.setFont(new Font("System",Font.BOLD,18));
        reEnterPinLable.setForeground(Color.WHITE);
        atmImage.add(reEnterPinLable);

        reEnterPin = new JPasswordField();
        reEnterPin.setBounds(595,335,150,30);
        reEnterPin.setFont(new Font("Raleway",Font.BOLD,18));
        reEnterPin.setBackground(new Color(153, 221, 238));
        reEnterPin.setForeground(Color.BLACK);
        atmImage.add(reEnterPin);
        /**
         * Buttons ::
         *      1. Submit
         *      2. Back
         */
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Raelway",Font.BOLD,16));
        submit.setBounds(595,375,150,35);
        submit.setForeground(Color.BLACK);
        submit.setBackground(new Color(153, 221, 238));
        submit.addActionListener(this);
        atmImage.add(submit);

        back = new JButton("BACK");
        back.setFont(new Font("Raelway",Font.BOLD,16));
        back.setBounds(370,375,150,35);
        back.setBackground(new Color(153, 221, 238));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        atmImage.add(back);

        setLayout(null);
        setSize(1366,768);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new MainInterface(pin_no);
        }

        try {
            String pin1 = newPin.getText();
            String pin2 = reEnterPin.getText();

            if (e.getSource() == submit) {

                if (newPin.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New Pin");
                    return;
                }
                if (reEnterPin.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New Pin");
                    return;
                }
                if (!pin1.equals(pin2)) {
                    JOptionPane.showMessageDialog(null, "Entered New Pin Does Not Match");
                    return;
                }
                if (!currentPin.getText().equals(pin_no)) {
                    JOptionPane.showMessageDialog(null, "Your Old Pin Does Not Match");
                    return;
                }

                Cons connection = new Cons();
                String update1 = "update Login set pin_no='" + pin1 + "' where pin_no='" + pin_no + "'";
                String update2 = "update deposit set pin_no='" + pin1 + "' where pin_no='" + pin_no + "'";
                String update3 = "update SignUpPage3 set pin_number='" + pin1 + "' where pin_number='" + pin_no + "'";

                connection.statement.executeUpdate(update1);
                connection.statement.executeUpdate(update2);
                connection.statement.executeUpdate(update3);

                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
                setVisible(false);
                new MainInterface(pin1);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ChangePin("");

    }
}
