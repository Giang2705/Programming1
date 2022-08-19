import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserLoginPage implements ActionListener {
    private JPanel Main;
    public JTextField usernameField1;
    private JButton btnLogin;
    private JButton btnClear;
    private JButton btnRegister;
    private JLabel loginTitle;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    public JPasswordField passwordField1;
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
            try {
                GuestHomePage guestHomePage = new GuestHomePage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnClear){
            usernameField1.setText("");
            passwordField1.setText("");
        }
        if (e.getSource() == btnLogin){
            if((usernameField1.getText().length() == 0) || String.valueOf(passwordField1.getPassword()).length() == 0){
                JFrame modal = new JFrame("Unvalidated");
                modal.setVisible(true);
                JOptionPane.showConfirmDialog(null, "Please fill in all fields of the form!", "Unvalidated", JOptionPane.DEFAULT_OPTION);
                modal.dispose();
            } else {
                String username = usernameField1.getText();
                String password = String.valueOf(passwordField1.getPassword());
                Login login = new Login();
                try {
                    login.UserLogin(username, password);
                    frame.dispose();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
