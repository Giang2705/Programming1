package GUI.Login_SignUp;

import javax.swing.*;

public class AccountExists {

    public AccountExists() {
        JFrame modal = new JFrame("Failed");
        modal.setVisible(true);
        JOptionPane.showConfirmDialog(null, "This account exists, please try again!", "FAILED", JOptionPane.DEFAULT_OPTION);
        modal.dispose();
    }
}
