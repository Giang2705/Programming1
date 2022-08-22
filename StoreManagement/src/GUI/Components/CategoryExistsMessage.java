package GUI.Components;

import javax.swing.*;

public class CategoryExistsMessage {

    public CategoryExistsMessage() {
        JFrame modal = new JFrame("Failed");
        modal.setVisible(true);
        JOptionPane.showConfirmDialog(null, "This category is already existed, please try again!", "FAILED", JOptionPane.DEFAULT_OPTION);
        modal.dispose();
    }
}
