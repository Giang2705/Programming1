package Functions;


import ClassAttribute.Order;
import GUI.Screen.ListOrders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchOrder{

    public List<Order> searchIdOrder(String id, String foundOrder) throws IOException {
        List<Order> orders = searchOrderByMemberID(id);
        List<Order> checkOrder = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++){
            if (foundOrder.equals(orders.get(i).getId())){
                checkOrder.add(orders.get(i));
            }
        }

        return checkOrder;
    }

    public List<Order> searchOrderByMemberID(String id) throws IOException {
        readDatabase readDatabase = new readDatabase();
        List<Order> orders = readDatabase.readOrderFile();
        List<Order> memberOrders = new ArrayList<Order>();

        for (int i = 0; i < orders.size(); i++){
            if (id.equals(orders.get(i).getCart().get(0).getMember().getId())){
                memberOrders.add(orders.get(i));
            }
        }

        return memberOrders;
    }
}