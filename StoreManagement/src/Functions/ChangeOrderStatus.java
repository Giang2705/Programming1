package Functions;

import ClassAttribute.Member;
import ClassAttribute.Order;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeOrderStatus {
    public void ChangeOrderStatus(String id, String status) throws IOException {
        ArrayList<String> tempArray = new ArrayList<>();
        readDatabase readDatabase = new readDatabase();
        List<Order> orders = readDatabase.readOrderFile();
        String path = "Database/orders.csv";
        try {
            try {
                FileReader fr = new FileReader(path);
                Scanner reader = new Scanner(fr);
                String line;
                String[] lineArr;

                while ((line=reader.nextLine()) != null) {
                    lineArr = line.split(",");
                    if(lineArr[0].equals(id)){
                        tempArray.add(
                                lineArr[0] + "," +
                                        lineArr[1] + "," +
                                        lineArr[2] + "," +
                                        lineArr[3] + "," +
                                        lineArr[4] + "," +
                                        status
                        );
                    } else  {
                        tempArray.add(line);
                    }
                }

                fr.close();
            } catch (Exception e){

            }
        } catch (Exception e){

        }
        try {
            try {
                PrintWriter pr = new PrintWriter(path);

                for (int i = 0; i<tempArray.size(); i++) {
                    pr.println(tempArray.get(i));
                }
                pr.close();
            } catch (Exception e){

            }
        } catch (Exception e) {

        }
    }

}
