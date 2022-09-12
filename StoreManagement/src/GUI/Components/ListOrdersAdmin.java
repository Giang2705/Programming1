package GUI.Components;

import ClassAttribute.Order;
import ClassAttribute.Product;
import Functions.SearchOrder;
import Functions.readDatabase;
import GUI.Screen.ListOrders;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ListOrdersAdmin {
    public ListOrdersAdmin() throws IOException {
    }

    public JPanel getMain() {
        return Main;
    }

    private JPanel Main;
    private JPanel ListOfOrders;

    readDatabase readDatabase = new readDatabase();
    List<Order> orders = readDatabase.readOrderFile();

    JFrame frame = new JFrame();

    public void ListOrdersAdmin() {

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

    public void ListUserOrdersAdmin(String id) throws IOException {
        SearchOrder searchOrder = new SearchOrder();
        List<Order> memberOrders = searchOrder.searchOrderByMemberID(id);

        ListOfOrders.setLayout(new GridLayout(memberOrders.size(), 1));
        for (int i = 0; i < memberOrders.size(); i++) {
            OrderItem orderItem = new OrderItem();
            orderItem.getId().setText(memberOrders.get(i).getId());
            orderItem.getMember().setText(memberOrders.get(i).getCart().get(0).getMember().getUsername());
            orderItem.getTotal().setText(String.valueOf(memberOrders.get(i).getTotal()));
            orderItem.getDate().setText(memberOrders.get(i).getCreatedDate());
            orderItem.getStatus().setText(memberOrders.get(i).getStatus());
            ListOfOrders.add(orderItem.getMain());
        }
    }
}
