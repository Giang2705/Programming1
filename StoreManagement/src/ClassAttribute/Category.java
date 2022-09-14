package ClassAttribute;

import java.util.Arrays;

public class Category {

//    Attribute
    private String name;
    public Category(String name) {
        this.name = name;
    }

//    Constructor
    public String getCategoryName() {
        return name;
    }

    public void setCategoryName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                '}';
    }

    public String displayCategoryInfo() { return this.toString();}
}

