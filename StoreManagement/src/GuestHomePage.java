import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestHomePage implements ActionListener {
    private JPanel Main;
    private JButton btnLogin;
    private JButton btnRegister;
    private JButton btnGoBack;
    private JLabel goBack;

    JFrame frame = new JFrame();
    GuestHomePage(){
        btnLogin.addActionListener(this);
        btnRegister.addActionListener(this);
        btnGoBack.addActionListener(this);

        frame.add(Main);
        frame.setTitle("Guest Homepage");
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

        if (e.getSource() == btnRegister){
            frame.dispose();
            UserRegisterForm userRegisterForm = new UserRegisterForm();
        }
        if (e.getSource()==btnGoBack){
            frame.dispose();
            WelcomeScreen welcomeScreen = new WelcomeScreen();
        }
    }
}
