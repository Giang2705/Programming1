package ClassAttribute;

import java.util.Arrays;
import java.util.List;

public class Category {

//    Attribute
    private String name;
    private List<Product> products;
    public Category(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Category() {

    }

    //    Constructor
    public String getCategoryName() {
        return name;
    }

    public void setCategoryName(String name) {
        this.name = name;
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    @Override
    public String toString() {
        return "{" +
                "name='" + name +
                ", products=" + products +
                '}';
    }

    public String displayCategoryInfo() { return this.toString();}
}

