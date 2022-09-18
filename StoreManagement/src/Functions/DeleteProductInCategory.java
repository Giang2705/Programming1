package Functions;

import ClassAttribute.Product;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DeleteProductInCategory {

    public DeleteProductInCategory(Product product) {
        List<Product> deletedProducts = new ArrayList<>();
        ArrayList<String> tempArray = new ArrayList<>();
        String path = "Database/categories.csv";
            try {
                String deletedProductsString = "+";
                try {
                    FileReader fr = new FileReader(path);
                    Scanner reader = new Scanner(fr);
                    String line;
                    line = reader.nextLine();
                    String[] lineArr;

                    while (line != null) {
                        lineArr = line.split(",");
                        if(lineArr.length > 1 && lineArr[1] != null){
                            String[] productsArr = lineArr[1].replace("+", "-").split("-");

                            for(int i = 1; i < productsArr.length; i++){
                                if (product.getProductId().equals(productsArr[i])){
                                    deletedProducts.add(product);
                                }
                                i += 1;
                            }

                            for(int i = 0; i < deletedProducts.size(); i++){
                                deletedProductsString += deletedProducts.get(i).getProductId() + "-" + deletedProducts.get(i).getProductName();
                            }

                            if(lineArr[0].equals(product.getProductCategory().getCategoryName())){
                                tempArray.add(
                                        lineArr[0] + "," +
                                                lineArr[1].replace(deletedProductsString, "")
                                );
                            } else  {
                                tempArray.add(line);
                            }
                        }

                        line = reader.nextLine();
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
