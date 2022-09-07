package Functions;


import ClassAttribute.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchOrder{

    public void searchIdOrder() throws IOException {
        readDatabase readDatabase = new readDatabase();
        List<Order> orders = readDatabase.readOrderFile();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID order: ");
        String dataInput = sc.nextLine();

        List<Order> checkOrder = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++){
            if (dataInput.equals(orders.get(i).getId())){
                checkOrder.add(orders.get(i));
            }
        }
    }
}