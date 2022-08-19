import ClassAttribute.Category;
import ClassAttribute.Product;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListProducts {
    public JPanel productList;

    ListProducts() throws IOException {
        readDatabase readDatabase = new readDatabase();
        List<Product> products = readDatabase.readProductFile();

        //        Products List
        int rows;
        if(products.size() % 3 != 0){
            rows = products.size()/3 + 1;
        } else {
            rows = products.size()/3;
        }

        productList.setLayout(new GridLayout(rows, 3));
        for (int i = 0; i < products.size(); i++){
            ProductItem productItem = new ProductItem();
            productItem.productName.setText(products.get(i).getProductName());
            productItem.productPrice.setText(String.valueOf(products.get(i).getProductPrice()));
            productList.add(productItem.productCard);
        }
    }
}
