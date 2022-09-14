package GUI.Components;

import Functions.ChangeOrderStatus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ModalOrderDetails implements ActionListener {
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

    public JLabel getTotal() {
        return total;
    }

    public void setTotal(JLabel discount) {
        this.total = discount;
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
    private JLabel total;
    private JLabel totalLabel;
    private JLabel statusLabel;
    private JTextField status;
    private JButton updateButton;

    public JTable getTableOfConfirmedProducts() {
        return tableOfConfirmedProducts;
    }

    public void setTableOfConfirmedProducts(JTable tableOfConfirmedProducts) {
        this.tableOfConfirmedProducts = tableOfConfirmedProducts;
    }

    private JTable tableOfConfirmedProducts;

    JFrame frame = new JFrame();

    public ModalOrderDetails(){
        updateButton.addActionListener(this);

        frame.add(Main);
        frame.setTitle("Order Details");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(920,720);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton) {
            ChangeOrderStatus changeOrderStatus = new ChangeOrderStatus();
            try {
                changeOrderStatus.ChangeOrderStatus(id.getText(), status.getText());
                JFrame modal = new JFrame("Update successful");
                modal.setVisible(true);
                JOptionPane.showMessageDialog(frame, "Successfully change order's status");
                modal.dispose();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
