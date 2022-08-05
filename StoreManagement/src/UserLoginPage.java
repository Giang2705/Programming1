import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginPage implements ActionListener {
    private JPanel Main;
    private JTextField usernameField1;
    private JButton btnLogin;
    private JButton btnClear;
    private JButton btnRegister;
    private JLabel loginTitle;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordField1;
    private JLabel dha;
    private JPanel loginForm;
    private JButton btnHome;

    JFrame frame = new JFrame();
    UserLoginPage(){
        btnRegister.addActionListener(this);
        btnHome.addActionListener(this);
        btnClear.addActionListener(this);
        btnLogin.addActionListener(this);

        frame.setTitle("Log In");
        frame.add(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960,720);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister){
            frame.dispose();
            UserRegisterForm userRegisterForm = new UserRegisterForm();
        }
        if (e.getSource() == btnHome){
            frame.dispose();
            GuestHomePage guestHomePage = new GuestHomePage();
        }
        if (e.getSource() == btnClear){
            usernameField1.setText("");
            passwordField1.setText("");
        }
        if (e.getSource() == btnLogin){
            frame.dispose();
            MemberHomePage memberHomePage = new MemberHomePage();
        }
    }
}
