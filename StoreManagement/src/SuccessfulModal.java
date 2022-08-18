import javax.swing.*;

public class SuccessfulModal {


    SuccessfulModal() {
        JFrame modal = new JFrame("Success!");
        modal.setVisible(true);
        JOptionPane.showConfirmDialog(null, "Created Successfully", "SUCCESS", JOptionPane.DEFAULT_OPTION);
        modal.dispose();
    }


}
