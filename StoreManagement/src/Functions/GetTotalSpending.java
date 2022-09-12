package Functions;

import ClassAttribute.Member;
import ClassAttribute.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetTotalSpending {
    readDatabase readDatabase = new readDatabase();
    List<Order> orders = readDatabase.readOrderFile();

    public GetTotalSpending() throws IOException {
    }

    public List<Order> memberOrders(String id) {
        List<Order> memberOrders = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++){
            if(orders.get(i).getCart().get(0).getMember().getId().equals(id)){
                memberOrders.add(orders.get(i));
            }
        }
        return memberOrders;
    }

    public Double totalSpending(String id, Order newOrder) throws IOException {
        Member member = null;
        List<Member> members = readDatabase.readUserFile();
        for (int i = 0; i<members.size(); i++){
            if(members.get(i).getId().equals(id)){
                member = members.get(i);
                break;
            }
        }

        double totalSpending = member.getTotalSpending();
        totalSpending += newOrder.getTotal();

        return totalSpending;
    }
}
