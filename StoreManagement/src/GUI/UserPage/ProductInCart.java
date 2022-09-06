package GUI.UserPage;

import ClassAttribute.Cart;
import Functions.ChangeStatusProductInCart;
import Functions.readDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductInCart implements ActionListener {
    public JPanel Main;
    private JLabel productNameLabel;

    public JLabel getPrice() {
        return Price;
    }

    public void setPrice(JLabel price) {
        Price = price;
    }

    public JLabel getProductName() {
        return productName;
    }

    public void setProductName(JLabel productName) {
        this.productName = productName;
    }

    public JLabel getAmount() {
        return amount;
    }

    public void setAmount(JLabel amount) {
        this.amount = amount;
    }

    public JLabel getTotal() {
        return total;
    }

    public void setTotal(JLabel total) {
        this.total = total;
    }

    public JCheckBox getSelect() {
        return select;
    }

    public void setSelect(JCheckBox select) {
        this.select = select;
    }

    private JLabel Price;
    private JLabel productName;
    private JLabel PriceLabel;
    private JLabel AmountLabel;
    private JLabel amount;
    private JLabel TotalLabel;
    private JLabel total;
    private JCheckBox select;
    private JLabel IDLabel;

    public JLabel getID() {
        return ID;
    }

    public void setID(JLabel ID) {
        this.ID = ID;
    }

    private JLabel ID;
    private JCheckBox delete;

    List<Cart> carts = new ArrayList<>();
    public ProductInCart() throws IOException {
        readDatabase readDatabase = new readDatabase();
        carts = readDatabase.readCartFile();

        select.addActionListener(this);
        delete.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == select){
            if(select.isSelected()){
                delete.setEnabled(false);
                for(int i = 0; i<carts.size(); i++){
                    if (carts.get(i).getId().equals(ID.getText())){
                        select.setText("Paid");
                        carts.get(i).setStatus("paid");
                        ChangeStatusProductInCart changeStatusProductInCart = new ChangeStatusProductInCart();
                        changeStatusProductInCart.changeStatus(ID.getText(), "paid");
                    }
                }
            } else {
                delete.setEnabled(true);
                for(int i = 0; i<carts.size(); i++){
                    if (carts.get(i).getId().equals(ID.getText())){
                        select.setText("Unpaid");
                        carts.get(i).setStatus("unpaid");
                        ChangeStatusProductInCart changeStatusProductInCart = new ChangeStatusProductInCart();
                        changeStatusProductInCart.changeStatus(ID.getText(), "unpaid");
                    }
                }
            }
        }
        if(e.getSource() == delete){
            if(delete.isSelected()){
                select.setEnabled(false);
                for(int i = 0; i<carts.size(); i++){
                    if (carts.get(i).getId().equals(ID.getText())){
                        carts.get(i).setStatus("delete");
                        ChangeStatusProductInCart changeStatusProductInCart = new ChangeStatusProductInCart();
                        changeStatusProductInCart.changeStatus(ID.getText(), "delete");
                    }
                }
            } else {
                select.setEnabled(true);
            }
        }
    }
}
