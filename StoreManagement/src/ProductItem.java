import ClassAttribute.Member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProductItem extends Component {
    public JPanel productCard;
    public JLabel productName;
    public JLabel productPrice;
    public JButton addToCartButton;

    public ProductItem() {
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addToCartButton) {
                    modalAddToCart modalAddToCart = new modalAddToCart();
                    modalAddToCart.productName.setText(productName.getText());
                    modalAddToCart.productPrice.setText(productPrice.getText());
                }
            }
        });
    }
}
