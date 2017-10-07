package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jan on 2017-10-01.
 */
public class LogIn {
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JPanel panel2;
    private JButton logInButton;
    private JPanel panel;

    public LogIn() {
        passwordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        passwordField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main(String[] args) {
        JFrame logIn = new JFrame("Log In");
        logIn.setContentPane(new LogIn().getPanel2());
        logIn.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        logIn.pack();
        logIn.setVisible(true);
    }

    public JPanel getPanel2() {
        return panel2;
    }
}



