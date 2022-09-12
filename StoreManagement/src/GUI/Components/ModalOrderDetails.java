package GUI.Components;

import javax.swing.*;

public class ModalOrderDetails {
    private JPanel Main;

    public JPanel getMain() {
        return Main;
    }

    public void setMain(JPanel main) {
        Main = main;
    }

    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public JLabel getMemberName() {
        return memberName;
    }

    public void setMemberName(JLabel memberName) {
        this.memberName = memberName;
    }

    public JTable getTableProducts() {
        return tableProducts;
    }

    public void setTableProducts(JTable tableProducts) {
        this.tableProducts = tableProducts;
    }

    public JLabel getDiscount() {
        return discount;
    }

    public void setDiscount(JLabel discount) {
        this.discount = discount;
    }

    public JTextField getStatus() {
        return status;
    }

    public void setStatus(JTextField status) {
        this.status = status;
    }

    private JLabel orderIDLabel;
    private JLabel id;
    private JLabel memberLabel;
    private JLabel memberName;
    private JLabel productsLabel;
    private JTable tableProducts;
    private JLabel discount;
    private JLabel discountLabel;
    private JLabel statusLabel;
    private JTextField status;
    private JButton updateButton;
}
