package Functions;

import ClassAttribute.Member;
import ClassAttribute.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetTotalSpending {
    readDatabase readDatabase = new readDatabase();

    public GetTotalSpending() throws IOException {
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
