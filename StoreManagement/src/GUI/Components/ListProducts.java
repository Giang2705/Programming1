package GUI.Components;

import ClassAttribute.Category;
import ClassAttribute.Product;
import Functions.SortByCategory;
import Functions.SortByPrice;
import Functions.readDatabase;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ListProducts {
    public JPanel productList;
    readDatabase readDatabase = new readDatabase();
    List<Category> categoriesList = readDatabase.readCategoryFile();
    List<Product> products = readDatabase.readProductFile();
    List<String> categories = new ArrayList<>();
    SortByPrice sortByPrice = new SortByPrice();

    SortByCategory sortByCategory = new SortByCategory();

    public List<Product> sortByPrice (String sortPrice, List<Product> productsArr) throws IOException {
        if (sortPrice.equals("default")){
            return productsArr;
        } else if (sortPrice.equals("ascending")){
            productsArr = sortByPrice.Ascending(productsArr);
        } else if (sortPrice.equals("descending")){
            productsArr = sortByPrice.Descending(productsArr);
        }
        return productsArr;
    }

    public ListProducts(boolean btnActive, String username, String sortPrice, String sortCategory) throws IOException {
        for (int i = 0; i < categoriesList.size(); i++){
            categories.add(categoriesList.get(i).getCategoryName());
        }

        if (sortCategory.equals("default")){
            sortByPrice(sortPrice, products);
        }
        for (int i = 0; i < categories.size(); i++){
            if (sortCategory.equals(categories.get(i))){
                products = sortByCategory.sortByCategory(categories.get(i));
                sortByPrice(sortPrice, products);
            } else {
                sortByPrice(sortPrice, products);
            }
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
