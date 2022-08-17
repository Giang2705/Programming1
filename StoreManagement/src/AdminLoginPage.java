import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminLoginPage implements ActionListener {
    private JPanel Main;
    private JTextField usernameField1;
    private JButton btnLogin;
    private JButton btnClear;

    private JLabel loginTitle;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordField1;
    private JPanel loginForm;
    private JButton btnHome;

    JFrame frame = new JFrame();
    AdminLoginPage(){

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
        if (e.getSource() == btnHome){
            frame.dispose();
            GuestHomePage guestHomePage = new GuestHomePage();
        }
        if (e.getSource() == btnClear){
            usernameField1.setText("");
            passwordField1.setText("");
        }
        if (e.getSource() == btnLogin){

            String username = usernameField1.getText();
            String password = String.valueOf(passwordField1.getPassword());
            try {
                new readDatabase().readAdminFile("",username, password);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.dispose();
            AdminHomePage adminHomePage = new AdminHomePage();
        }
    }
}
