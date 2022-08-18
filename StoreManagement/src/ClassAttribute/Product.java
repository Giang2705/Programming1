package ClassAttribute;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String id;
    private String name;
    private Category category;
    private double price;

    public static List<Product> List_product = new ArrayList<>();


    public Product(String id, String name, Category category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category.getCategoryName() +
                ", price=" + price +
                '}';
    }

    public String displayProductInfo() { return this.toString(); }

    public static List<Product> getList() {
        return List_product;
    }

    // getter and setter
    public String getProductId() {
        return id;
    }

    public void setProductId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public Category getProductCategory() {
        return category;
    }

    public void setProductCategory(Category category) {
        this.category = category;
    }

    public double getProductPrice() {
        return price;
    }

    public void setProductPrice(double price) {
        this.price = price;
    }
}

