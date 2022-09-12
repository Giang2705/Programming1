package GUI.Screen;

import ClassAttribute.Cart;
import ClassAttribute.Order;
import Functions.readDatabase;
import GUI.Components.ProductInCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryScreen implements ActionListener{

    private JLabel Main;
    private JLabel username;
    private JPanel ListOfAddedProducts;
    JFrame frame = new JFrame();

    public List<Order> getMemberOrder() throws IOException {
        readDatabase readDatabase = new readDatabase();
        List<Order> historyOrder = readDatabase.readOrderFile();

        List<Order> memberOrder = new ArrayList<>();
        if (historyOrder != null) {
            for (Order order : historyOrder) {
                for (int j = 0; j < order.getCart().size(); j++) {
                    if (order.getCart().get(j).getMember().getUsername().equals(username.getText())) {
                        memberOrder.add(order);
                    }
                }
            }
        }
        return historyOrder;
    }

    public OrderHistoryScreen(String id) throws IOException{
        username.setText(id);
        
        getMemberOrder();

        ListOfAddedProducts.setLayout(new GridLayout(getMemberOrder().size(), 1));
        for (int i = 0; i < getMemberOrder().size(); i++) {
            if(getMemberOrder().get(i).getStatus().equals("paid")){

                ProductInCart productInCart = new ProductInCart();

                productInCart.getProductName().setText(getMemberOrder().get(i).getCart().get(0).getProduct().getProductName());
                productInCart.getPrice().setText(String.valueOf(getMemberOrder().get(i).getCart().get(0).getProduct().getProductPrice()));
                productInCart.getAmount().setText(String.valueOf(getMemberOrder().get(i).getCart().get(0).getAmount()));
                productInCart.getTotal().setText(String.valueOf(getMemberOrder().get(i).getTotal()));
                productInCart.getID().setText(getMemberOrder().get(i).getId());
                ListOfAddedProducts.add(productInCart.Main);
            }
        }

        frame.add(Main);
        frame.setTitle("History of order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(960, 720);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
