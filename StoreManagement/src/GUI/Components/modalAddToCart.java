package GUI.Components;

import ClassAttribute.Cart;
import ClassAttribute.Category;
import ClassAttribute.Member;
import ClassAttribute.Product;
import Functions.*;
import GUI.Screen.MemberHomePage;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class modalAddToCart implements ChangeListener, ActionListener {
    private JLabel productNameTitle;
    private JLabel productPriceTitle;
    public JLabel productName;
    public JLabel productPrice;
    public JSpinner amountChange;
    public JTextField textField1;
    private JButton submitButton;
    private JButton cancelButton;
    public JPanel ModalAddToCart;
    public JLabel username;

    readDatabase readDatabase = new readDatabase();
    List<Member> members = readDatabase.readUserFile();
    List<Product> products = readDatabase.readProductFile();

    JFrame frame = new JFrame();
    public modalAddToCart() throws IOException {
        amountChange.addChangeListener(this);
        submitButton.addActionListener(this);
        cancelButton.addActionListener(this);

        frame.setLayout(new GridLayout());

        frame.add(ModalAddToCart);
        frame.setTitle("Add to cart");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(480,540);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        textField1.setText(""+(Integer)(amountChange.getValue())*Double.parseDouble(productPrice.getText()));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton){
            String id = "C.00" + GenerateID.getID(3);
            String status = "unpaid";
            Member member = new Member();
            Product product = null;

            for(int i = 0; i < members.size(); i++){
                if (members.get(i).getStatus().equals("loged in")){
                    member = members.get(i);
                    break;
                }
            }

            for(int i = 0; i< products.size(); i++){
                if (products.get(i).getProductName().equals(productName.getText())){
                    product = products.get(i);
                    break;
                }
            }

            if (textField1.getText().equals("")) {
                JFrame modal = new JFrame("Unvalidated");
                modal.setVisible(true);
                JOptionPane.showConfirmDialog(null, "Please choose amount more than 0!", "Unvalidated", JOptionPane.DEFAULT_OPTION);
                modal.dispose();
            } else {
                Cart cart = new Cart(id, member, product, (Integer)(amountChange.getValue()), Double.parseDouble(textField1.getText()), GetDate.GetDate(), status);
//                validation
                if(cart.getAmount() <= 0){
                    JFrame modal = new JFrame("Unvalidated");
                    modal.setVisible(true);
                    JOptionPane.showConfirmDialog(null, "Please choose amount more than 0!", "Unvalidated", JOptionPane.DEFAULT_OPTION);
                    modal.dispose();
                } else {
                    storeDatabase database = new storeDatabase();
                    database.createFolder();
                    database.createCartsFile();
                    database.cartCountLine();
                    database.addProductToCart(cart);
                    JFrame modal = new JFrame("Successful!");
                    modal.setVisible(true);
                    JOptionPane.showConfirmDialog(null, "Product added to cart!", "Successful", JOptionPane.DEFAULT_OPTION);
                    modal.dispose();
                    frame.dispose();
                }
            }

        }
        if (e.getSource() == cancelButton){
            frame.dispose();
        }
    }
}
