package GUI.Components;

import javax.swing.*;
import java.awt.*;

public class ConfirmedOrderModal {
    private JPanel Main;
    private JLabel Title;
    private JLabel usernameLabel;
    private JLabel productsLabel;
    private JLabel totalLabel;
    private JLabel createdDateLabel;
    private JLabel statusLabel;
    private JLabel username;
    private JTable tableOfConfirmedProducts;
    private JLabel total;
    private JLabel createdDate;
    private JLabel status;
    private JButton btnPrint;
    private JButton homeButton;
    private JLabel idLabel;
    private JLabel ID;

    JFrame frame = new JFrame();
    public ConfirmedOrderModal(){


        frame.setLayout(new GridLayout());

        frame.add(Main);
        frame.setTitle("Invoice");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(480,540);
    }
}
