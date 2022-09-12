package GUI.Screen;

import Functions.GenerateID;
import Functions.storeDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserRegisterForm implements ActionListener{

    JFrame frame = new JFrame();
    private JPanel Main;
    private JPanel registerForm;
    private JLabel registerTitle;
    private JLabel usernameLabel;
    private JTextField usernameField1;
    private JLabel passwordLabel;
    private JTextField passwordField1;
    private JButton btnRegister;
    private JButton btnClear;
    private JLabel dha;
    private JButton btnCancel;
    private JButton btnLogin;
    private JButton btnHome;
    private JTextField fullnameField;
    private JTextField phoneField;
    private JLabel fullnameLabel;
    private JLabel phoneLabel;
    private JLabel membershipLabel;
    private JTextPane membershipRule;

    UserRegisterForm(){
        btnLogin.addActionListener(this);
        btnHome.addActionListener(this);
        btnClear.addActionListener(this);
        btnCancel.addActionListener(this);
        btnRegister.addActionListener(this);

        frame.setTitle("Register");
        frame.add(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin){
            frame.dispose();
            UserLoginPage userLoginPage = new UserLoginPage();
        }
        if (e.getSource() == btnHome || e.getSource() == btnCancel){
            frame.dispose();
            try {
                GuestHomePage guestHomePage = new GuestHomePage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnClear){
            usernameField1.setText("");
            passwordField1.setText("");
            fullnameField.setText("");
            phoneField.setText("");
        }
        if (e.getSource() == btnRegister){
            String id = "M.00" + GenerateID.getID(3);
            String username = usernameField1.getText();
            String password = passwordField1.getText();
            String fullname = fullnameField.getText();
            String phone = phoneField.getText();
            String membership = "MEMBERSHIP";
            double totalSpending = 0;
            String status = "loged out";

//            validation
            if((username.length() == 0) || (password.length() == 0) || (fullname.length() == 0) || (phone.length() == 0)){
                JFrame modal = new JFrame("Unvalidated");
                modal.setVisible(true);
                JOptionPane.showConfirmDialog(null, "Please fill in all fields of the form!", "Unvalidated", JOptionPane.DEFAULT_OPTION);
                modal.dispose();
                System.out.println("False");
            } else {
                storeDatabase database = new storeDatabase();
                database.createFolder();
                database.createFile();
                database.count();
                database.register(username, password, fullname, phone, id, membership, totalSpending, status);

                usernameField1.setText("");
                passwordField1.setText("");
                fullnameField.setText("");
                phoneField.setText("");
//                SuccessfulModal successfulModal = new SuccessfulModal();
            }
        }
    }
}
