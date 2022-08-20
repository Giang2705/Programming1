package GUI.Components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductItem implements ActionListener{
    public JPanel productCard;
    public JLabel productName;
    public JLabel productPrice;
    public JButton addToCartButton;

   ProductItem() {
        addToCartButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToCartButton) {
            modalAddToCart modalAddToCart = new modalAddToCart();
            modalAddToCart.productName.setText(productName.getText());
            modalAddToCart.productPrice.setText(productPrice.getText());
        }
    }
}
