package GUI.Components;

import ClassAttribute.Order;
import ClassAttribute.Product;
import Functions.readDatabase;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ListOrdersAdmin {
    public JPanel getMain() {
        return Main;
    }

    private JPanel Main;
    private JPanel ListOfOrders;

    JFrame frame = new JFrame();

    public ListOrdersAdmin() throws IOException {
        readDatabase readDatabase = new readDatabase();
        List<Order> orders = readDatabase.readOrderFile();
        ListOfOrders.setLayout(new GridLayout(orders.size(), 1));
        for (int i = 0; i < orders.size(); i++) {
            OrderItem orderItem = new OrderItem();
            orderItem.getId().setText(orders.get(i).getId());
            orderItem.getMember().setText(orders.get(i).getCart().get(0).getMember().getUsername());
            orderItem.getTotal().setText(String.valueOf(orders.get(i).getTotal()));
            orderItem.getDate().setText(orders.get(i).getCreatedDate());
            orderItem.getStatus().setText(orders.get(i).getStatus());
            ListOfOrders.add(orderItem.getMain());
        }
    }
}
