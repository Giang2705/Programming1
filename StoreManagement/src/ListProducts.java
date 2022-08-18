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

    ListProducts() {
        //        Products List
        List<Product> products = new ArrayList<Product>();
        try {
            FileReader reader = new FileReader("StoreManagement/Database/products.csv");
            BufferedReader reader1 = new BufferedReader(reader);
            reader1.readLine();
            String line;
            line = reader1.readLine();

            if (line == null){
                productList.setLayout(new GridLayout(1, 1));
                productList.add(new JLabel("There is no products!"));
            } else {
                //            boolean firstLine = true;
                while (line != null) {
                    String[] array = line.split(",");
                    Product temp = new Product(array[0],array[1],new Category(array[2]), Integer.valueOf(array[3]));
//                if (array[0] != "id" && array[1] != "name") {
//                System.out.printf("ProId: " + temp.getProductId() + ", ProName: " + temp.getProductName() + ", ProCat: " + temp.getProductCategory().getCategoryName() + ", ProPrice: " + temp.getProductPrice() + "\n");
                    products.add(temp);
                    line = reader1.readLine();
                }
                reader.close();

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
                    productItem.productPrice.setText(String.valueOf(products.get(i).getProductPrice()) + "VND");
                    productList.add(productItem.productCard);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
