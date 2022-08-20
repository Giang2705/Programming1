package GUI.Components;

import ClassAttribute.Product;
import Functions.readDatabase;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ListProducts {
    public JPanel productList;

    public ListProducts(boolean btnActive) throws IOException {
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
            productItem.addToCartButton.setEnabled(btnActive);
            productList.add(productItem.productCard);
        }
    }
}
