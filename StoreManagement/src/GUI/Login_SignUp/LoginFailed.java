package GUI.Login_SignUp;

import javax.swing.*;

public class LoginFailed {

    public LoginFailed() {
        JFrame modal = new JFrame("Failed");
        modal.setVisible(true);
        JOptionPane.showConfirmDialog(null, "Wrong username or password, please try again!", "FAILED", JOptionPane.DEFAULT_OPTION);
        modal.dispose();
    }
}
