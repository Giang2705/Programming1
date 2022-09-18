package Functions;

import ClassAttribute.Member;
import ClassAttribute.Product;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddNewProductToCategory {
    public void AddNewProduct(String cateName, Product product) throws IOException {
//        take array of members and admins
        ArrayList<String> tempArray = new ArrayList<>();
        readDatabase readDatabase = new readDatabase();
        List<Member> members = readDatabase.readUserFile();
        String path = "Database/categories.csv";
        try {
            try {
                FileReader fr = new FileReader(path);
                Scanner reader = new Scanner(fr);
                String line;
                String[] lineArr;

                while ((line=reader.nextLine()) != null) {
                    lineArr = line.split(",");
                    if(lineArr[0].equals(cateName)){
//                            add new database into temp array
                            tempArray.add(
                                    lineArr[0] + "," +
                                            lineArr[1] + product.getProductId() + "-" +
                                            product.getProductName() + "+"
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
//                print database of temp array into new file
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
