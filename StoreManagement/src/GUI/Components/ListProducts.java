package GUI.Components;

import ClassAttribute.Product;
import Functions.SortByPrice;
import Functions.readDatabase;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class ListProducts {
    public JPanel productList;
    List<Product> products = null;
    readDatabase readDatabase = new readDatabase();
    SortByPrice sortByPrice = new SortByPrice();

    public ListProducts(boolean btnActive, String username, String sort) throws IOException {
        if (sort.equals("default")){
            products = readDatabase.readProductFile();
        } else if (sort.equals("ascending")){
            products = sortByPrice.Ascending();
        } else if (sort.equals("descending")){
            products = sortByPrice.Descending();
        }

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
            double price = products.get(i).getProductPrice();
            DecimalFormat df = new DecimalFormat("#.##");
            String printPrice = df.format(price);
            productItem.productPrice.setText(printPrice);
            productItem.addToCartButton.setEnabled(btnActive);
            productItem.getUsername().setText(username);
            productList.add(productItem.productCard);
        }
    }
}
