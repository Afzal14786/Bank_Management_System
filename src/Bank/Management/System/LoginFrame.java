package Bank.Management.System;

import com.mysql.cj.log.Log;

import javax.management.remote.SubjectDelegationPermission;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class LoginFrame extends JFrame implements ActionListener {
    JLabel welcome, card, pin;
    JTextField cardNo;
    JPasswordField pinNo;
    JButton clear, signIn, back;
    String pin_No;

    LoginFrame(String pin_No) {
        super("Login With Us");

        this.pin_No = pin_No;
        ImageIcon welcomeImg = new ImageIcon(ClassLoader.getSystemResource("Icons/loginBackgroundImage.jpg"));
        Image img = welcomeImg.getImage().getScaledInstance(900,600, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(img);
        JLabel welcomeImage = new JLabel(image);
        welcomeImage.setBounds(0,0,900,600);
        add(welcomeImage);

        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("Icons/3DATM.png"));
        Image atmImg = atm.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon atmImg1 = new ImageIcon(atmImg);
        JLabel atmImg2 = new JLabel(atmImg1);
        atmImg2.setBounds(0,60,400,400);
        welcomeImage.add(atmImg2);

        welcome = new JLabel("<html><b>Welcome \n Thank You For Joining Us<b><html>");
        welcome.setFont(new Font("Arial", Font.BOLD,22));
        welcome.setForeground(new Color(67));
        welcome.setBounds(20,20,400,30);
        welcomeImage.add(welcome);


        card = new JLabel("Card No :");
        card.setFont(new Font("Arial", Font.BOLD,20));
        card.setForeground(new Color(0x0F8148));
        card.setBounds(500,210,100,30);
        welcomeImage.add(card);

        cardNo = new JTextField();
        cardNo.setFont(new Font("Arial", Font.BOLD,16));
        cardNo.setForeground(Color.BLACK);
        cardNo.setBounds(600,210,200,30);
        welcomeImage.add(cardNo);

        pin = new JLabel("Pin No :");
        pin.setFont(new Font("Arial", Font.BOLD,20));
        pin.setForeground(new Color(0x0F8148));
        pin.setBounds(500,250,100,30);
        welcomeImage.add(pin);

        pinNo = new JPasswordField();
        pinNo.setFont(new Font("Arial", Font.BOLD,16));
        pinNo.setForeground(Color.BLACK);
        pinNo.setBounds(600,250,200,30);
        welcomeImage.add(pinNo);



        back = new JButton("BACK");
        back.setFont(new Font("Releway", Font.BOLD,14));
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(204,255,204));
        back.setBounds(690,310,100,30);
        back.addActionListener(this);
        welcomeImage.add(back);

        clear = new JButton("CLEAR");
        clear.setFont(new Font("Raleway", Font.BOLD,14));
        clear.setForeground(Color.black);
        clear.setBackground(new Color(204,255,204));
        clear.setBounds(560,310,100,30);
        clear.addActionListener(this);
        welcomeImage.add(clear);

        signIn = new JButton("SIGN IN");
        signIn.setBounds(630,350,100,30);
        signIn.setFont(new Font("Arial", Font.BOLD,14));
        signIn.setBackground(new Color(204,255,204));
        signIn.setForeground(Color.BLACK);
        signIn.addActionListener(this);
        welcomeImage.add(signIn);



        setLayout(null);
        setSize(900,600);
        setLocation(150,100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Login(pin_No);
        }
        if (e.getSource() == clear) {
            cardNo.setText("");
            pinNo.setText("");
        }
        try {
            String card_number = (String) cardNo.getText();
            String pin_number =  (String) pinNo.getText();
            if (e.getSource() == signIn) {
                if (cardNo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Your Card Number");
                    return;
                }
                if (pinNo.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter Your Pin");
                    return;
                }
                Cons connection = new Cons();
                ResultSet resultSet = connection.statement.executeQuery("SELECT * FROM Login WHERE card_number='"+card_number+"' AND pin_no='"+pin_number+"'");
                if (resultSet.next()) {
                    setVisible(false);
                    new MainInterface(pin_No);
                } else {
                    if (!card_number.equals(card_number) || pin_number.equals(pin_number)) {
                        JOptionPane.showMessageDialog(null, "Wrong Card Number or Pin Number\n Kindly Check And\n Re-Enter Your Card Number & Pin Number");
                        return;
                    }
                }
            }
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Exception : " + E);
            return;
        }
    }
    public static void main(String[] args) {
        new LoginFrame("");
    }
}
