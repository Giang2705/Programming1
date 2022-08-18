import javax.swing.*;

public class LoginFailed {

    LoginFailed() {
        JFrame modal = new JFrame("Failed");
        modal.setVisible(true);
        JOptionPane.showConfirmDialog(null, "Wrong username or password, please try again!", "FAILED", JOptionPane.DEFAULT_OPTION);
        modal.dispose();
    }
}
