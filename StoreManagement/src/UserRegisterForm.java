import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            GuestHomePage guestHomePage = new GuestHomePage();
        }
        if (e.getSource() == btnClear){
            usernameField1.setText("");
            passwordField1.setText("");
            fullnameField.setText("");
            phoneField.setText("");
        }
        if (e.getSource() == btnRegister){
            String username = usernameField1.getText();
            String password = passwordField1.getText();
            String fullname = fullnameField.getText();
            String phone = phoneField.getText();

            storeDatabase database = new storeDatabase();
            database.createFolder();
            database.createFile();
            database.count();
            database.register(username, password, fullname, phone);
        }
    }
}
