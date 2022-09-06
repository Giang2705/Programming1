package GUI.AdminPage.NewProduct;

import javax.swing.*;

public class ProductExists {

    public ProductExists() {
        JFrame modal = new JFrame("Failed");
        modal.setVisible(true);
        JOptionPane.showConfirmDialog(null, "This product is already existed, please try again!", "FAILED", JOptionPane.DEFAULT_OPTION);
        modal.dispose();
    }
}
