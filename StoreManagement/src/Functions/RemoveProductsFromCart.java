package Functions;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveProductsFromCart {
    public void removeProductsFromCart(String id){
        ArrayList<String> tempArray = new ArrayList<>();
        try {
            try {
                FileReader fr = new FileReader("Database/cart.csv");
                Scanner reader = new Scanner(fr);
                String line;
                String[] lineArr;

                while ((line=reader.nextLine()) != null) {
                    lineArr = line.split(",");
                    System.out.println(lineArr[0]);
                    System.out.println(id);
                    if(lineArr.length > 1){
                        if(lineArr[0].equals(id)){
                            tempArray.add("");
                        } else {
                            System.out.println(lineArr[0]);
                            tempArray.add(
                                    lineArr[0] + "," +
                                            lineArr[1] + "," +
                                            lineArr[2] + "," +
                                            lineArr[3] + "," +
                                            lineArr[4] + "," +
                                            lineArr[5] + "," +
                                            lineArr[6]
                            );
                            System.out.println(tempArray);
                        }
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
                    System.out.println(tempArray.get(i));
                    pr.println(tempArray.get(i));
                }
                pr.close();
            } catch (Exception e){

            }
        } catch (Exception e) {

        }
    }
}
