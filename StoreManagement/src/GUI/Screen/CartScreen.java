package GUI.Screen;

import ClassAttribute.Cart;
import ClassAttribute.Order;
import Functions.*;
import GUI.Components.ProductInCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartScreen implements ActionListener {
    private JPanel Main;
    private JLabel usernameLabel;
    private JLabel username;
    private JButton btnHome;
    private JButton btnConfirm;
    private JButton btnDelete;
    private JPanel ListOfAddedProducts;
    JFrame frame = new JFrame();

    public List<Cart> getMemberCart() throws IOException {
        readDatabase readDatabase = new readDatabase();
        List<Cart> carts = readDatabase.readCartFile(username.getText());

        List<Cart> memberCart = new ArrayList<>();
        if (carts != null){
            for (int i = 0; i < carts.size(); i++) {
                if (carts.get(i).getMember().getUsername() != null) {
                    memberCart.add(carts.get(i));
                }
            }
        }

        return memberCart;
    }

    public CartScreen(String name) throws IOException {
        btnHome.addActionListener(this);
        btnConfirm.addActionListener(this);
        btnDelete.addActionListener(this);
        username.setText(name);

        getMemberCart();

        ListOfAddedProducts.setLayout(new GridLayout(getMemberCart().size(), 1));
        for (int i = 0; i < getMemberCart().size(); i++) {
            if(getMemberCart().get(i).getStatus().equals("unpaid")){
                ProductInCart productInCart = new ProductInCart(username.getText());
                productInCart.getProductName().setText(getMemberCart().get(i).getProduct().getProductName());
                productInCart.getPrice().setText(String.valueOf(getMemberCart().get(i).getProduct().getProductPrice()));
                productInCart.getAmount().setText(String.valueOf(getMemberCart().get(i).getAmount()));
                productInCart.getTotal().setText(String.valueOf(getMemberCart().get(i).getTotal()));
                productInCart.getID().setText(getMemberCart().get(i).getId());
                ListOfAddedProducts.add(productInCart.Main);
            }
        }

        frame.add(Main);
        frame.setTitle("Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960, 720);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHome) {
            frame.dispose();
            try {
                MemberHomePage memberHomePage = new MemberHomePage(username.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnConfirm) {
            List<Cart> productsOrder = new ArrayList<>();
            int total = 0;
            try {
                for(int i = 0; i<getMemberCart().size(); i++){
                    if(getMemberCart().get(i).getStatus().equals("paid")){
                        productsOrder.add(getMemberCart().get(i));
                        ChangeStatusProductInCart changeStatusProductInCart = new ChangeStatusProductInCart();
                        changeStatusProductInCart.changeStatus(getMemberCart().get(i).getId(), "confirm");
                    }
                }
                String id = GenerateID.getID(10);
                for (int i = 0; i < productsOrder.size(); i++) {
                    total += productsOrder.get(i).getTotal();
                }

                String createdDate = GetDate.GetDate();
                String status = "Confirmed";

                Order order = new Order(id, productsOrder, total, createdDate, status);

                storeDatabase storeDatabase = new storeDatabase();
                storeDatabase.createFolder();
                storeDatabase.createOrdersFile();
                storeDatabase.ordersCountLine();
                storeDatabase.addOrder(order, productsOrder);


                frame.dispose();
                CartScreen cartScreen = new CartScreen(username.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == btnDelete) {
            try {
                for(int i = 0; i<getMemberCart().size(); i++){
                    if(getMemberCart().get(i).getStatus().equals("delete")){
                        RemoveProductsFromCart removeProductsFromCart = new RemoveProductsFromCart();
                        removeProductsFromCart.removeProductsFromCart(getMemberCart().get(i).getId());
                    }
                }
                frame.dispose();
                CartScreen cartScreen = new CartScreen(username.getText());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}