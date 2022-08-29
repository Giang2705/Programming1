package GUI.Components;

import GUI.Screen.MemberHomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProductItem implements ActionListener {
    public JPanel productCard;
    public JLabel productName;
    public JLabel productPrice;
    public JButton addToCartButton;

    public JLabel username;

    JFrame frame = new JFrame();
    public JLabel getUsername() {
        return username;
    }

    public void setUsername(JLabel username) {
        this.username = username;
    }

    ProductItem() {
        addToCartButton.addActionListener(this);
        username.setVisible(false);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToCartButton) {
            modalAddToCart modalAddToCart = new modalAddToCart();
            modalAddToCart.productName.setText(productName.getText());
            modalAddToCart.productPrice.setText(productPrice.getText());
            modalAddToCart.username.setText(username.getText());
        }
    }
}
