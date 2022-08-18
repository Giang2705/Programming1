import javax.swing.*;

public class AccountExists {

    AccountExists() {
        JFrame modal = new JFrame("Failed");
        modal.setVisible(true);
        JOptionPane.showConfirmDialog(null, "This account exists, please try again!", "FAILED", JOptionPane.DEFAULT_OPTION);
        modal.dispose();
    }
}
