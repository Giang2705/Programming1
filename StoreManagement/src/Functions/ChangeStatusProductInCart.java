package Functions;

import ClassAttribute.Cart;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeStatusProductInCart {
    public void changeStatus(String id, String status){
        ArrayList<String> tempArray = new ArrayList<>();
        try {
            try {
                FileReader fr = new FileReader("Database/cart.csv");
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
                                lineArr[5] + "," +
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
                PrintWriter pr = new PrintWriter("Database/cart.csv");

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
