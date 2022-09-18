package Functions;

import ClassAttribute.Category;
import ClassAttribute.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByCategory {

    readDatabase readDatabase = new readDatabase();
    List<Product> proByCat = new ArrayList<>();

    public SortByCategory() throws IOException {
    }

    public List<Product> sortByCategory(String category) throws IOException {
        List<Product> products = readDatabase.readProductFile();
        for (Product i : products) {
            if(i.getProductCategory().getCategoryName().equals(category)){
                proByCat.add(i);
            }
        }
        products = proByCat;
        return products;
    }
}
