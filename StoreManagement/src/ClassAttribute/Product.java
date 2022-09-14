package ClassAttribute;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Product implements Comparable<Product> {
//    Attribute
    private String id;
    private String name;
    private Category category;
    private double price;
    private int amount;

//    Constructor
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static List<Product> List_product = new ArrayList<>();


    public Product(String id, String name, Category category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
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

    public void setProductPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id +
        ", name='" + name +
        ", category=" + category.getCategoryName() +
                ", price=" + price +
                '}';
    }

    public String displayProductInfo() { return this.toString(); }

//    Sort product by price
    @Override
    public int compareTo(Product o){
        if (this.price > o.getProductPrice()){
            return 1;
        } else if (this.price < o.getProductPrice()){
            return -1;
        }else {
            return 0;
        }
    }
}