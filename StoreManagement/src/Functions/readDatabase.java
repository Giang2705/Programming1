package Functions;

import ClassAttribute.*;

import java.io.*;
import java.util.*;

public class readDatabase {
//    Create Object array
    List<Admin> admins = new ArrayList<Admin>();
    List<Member> members = new ArrayList<Member>();
    List<String> categoryNames = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    List<Cart> carts = new ArrayList<>();
    List<Order> orders = new ArrayList<>();


//    read database (add elements into object array)

//    array members
    public List<Member> readUserFile() throws IOException {
        BufferedReader b = null;
        String line = "";
        String delimiter = ",";

        try {
            FileReader fr = new FileReader("Database/users.csv");
            b = new BufferedReader(fr);
            b.readLine();

            while ((line = b.readLine()) != null) {
                String[] file = line.split(delimiter);

                if (file.length > 1) {
                    Member mem = new Member();
                    //   set value for member's attribute
                    mem.setId(file[0]);
                    mem.setUsername(file[1]);
                    mem.setPassword(file[2]);
                    mem.setFullname(file[3]);
                    mem.setPhone(file[4]);
                    mem.setMembership(file[5]);
                    mem.setTotalSpending(Double.parseDouble(file[6]));
                    mem.setStatus(file[7]);
                    members.add(mem);
                }
            }

        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }

        return members;
    }

//    array admins
    public List<Admin> readAdminFile() throws IOException {
        BufferedReader b = null;
        String line = "";
        String delimiter = ",";

        try {
            FileReader fr = new FileReader("Database/admins.csv");
            b = new BufferedReader(fr);

            while ((line = b.readLine()) != null) {
                String[] file = line.split(delimiter);

                if (file.length > 1) {
                    Admin ad = new Admin();
                    //   set value for admin's attribute
                    ad.setAdminId(file[0]);
                    ad.setAdminUsername(file[1]);
                    ad.setAdminPassword(file[2]);
                    ad.setStatus(file[3]);

                    admins.add(ad);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admins;
    }

//    array Categories
    public List<String> readCategoryFile() throws IOException {
        try {
            FileReader reader = new FileReader("Database/categories.csv");
            BufferedReader reader1 = new BufferedReader(reader);
            reader1.readLine();
            String line;
            line = reader1.readLine();

//            boolean firstLine = true;
            while (line != null) {
//                String[] array = line.split(",");
                categoryNames.add(line);
                line = reader1.readLine();;
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return categoryNames;
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }

//  array products
public List<Product> readProductFile() throws IOException {
    try {
        FileReader reader = new FileReader("Database/products.csv");
        BufferedReader reader1 = new BufferedReader(reader);
        reader1.readLine();
        String line;
        line = reader1.readLine();

//            boolean firstLine = true;
        while (line != null) {
            String[] array = line.split(",");
            Product temp = new Product(array[0],array[1],new Category(array[2]), Double.parseDouble(array[3]));
//                if (array[0] != "id" && array[1] != "name") {
//                    System.out.printf("ProId: " + temp.getProductId() + ", ProName: " + temp.getProductName() + ", ProCat: " + temp.getProductCategory().getCategoryName() + ", ProPrice: " + temp.getProductPrice() + "\n");
            products.add(temp);
            line = reader1.readLine();
        }
        reader.close();

    } catch (IOException e) {
        e.printStackTrace();
    }

    return products;
}

//    array product in cart
public List<Cart> readCartFile() throws IOException {
    List<Member> members = readUserFile();
    List<Product> products = readProductFile();

    try {
        FileReader reader = new FileReader("Database/cart.csv");
        BufferedReader reader1 = new BufferedReader(reader);
        reader1.readLine();
        String line;
        line = reader1.readLine();

//            boolean firstLine = true;
        while (line != null) {
            Member member = new Member();
            Product product = null;

            String[] file = line.split(",");
            if (file.length > 1){
                for (int i = 0; i < members.size(); i++){
                    if (members.get(i).getUsername().equals(file[1])){
                        member = members.get(i);
                    }
                }
                for (int i = 0; i < products.size(); i++){
                    if (products.get(i).getProductName().equals(file[2])){
                        product = products.get(i);
                    }
                }

                Cart cart = new Cart(file[0], member, product, Double.parseDouble(file[3]), Double.parseDouble(file[4]), file[5], file[6]);
                carts.add(cart);
            }
            line = reader1.readLine();
        }
        reader.close();

    } catch (IOException e) {
        return carts = null;
    }
    return carts;
}

    //    array orders

    public List<Order> readOrderFile() throws IOException {
        List<Cart> carts = readCartFile();
        List<Member> members = readUserFile();
        List<Member> membersArr = new ArrayList<>();

        try {
            FileReader reader = new FileReader("Database/orders.csv");
            BufferedReader reader1 = new BufferedReader(reader);
            reader1.readLine();
            String line;
            line = reader1.readLine();

//            boolean firstLine = true;
            while (line != null) {
                List<Cart> cartInOrder = new ArrayList<>();
                String[] file = line.split(",");

                if (file.length > 1){
                    Member member = new Member();

                    for (int i = 0; i < members.size(); i++){
                        if (members.get(i).getUsername().equals(file[1])){
                            member = members.get(i);
                        }
                        membersArr.add(member);
                    }

                    String[] productsArr = file[2].replace("+", "-").split("-");

                    for (int i = 0; i < carts.size(); i++){
                        int j = 0;
                        while (j < productsArr.length){
                            if(carts.get(i).getId().equals(productsArr[j])){
                                cartInOrder.add(carts.get(i));
                            }
                            j += 3;
                        }
                    }

                    Order order = new Order(file[0], cartInOrder, Double.parseDouble(file[3]), file[4], file[5]);
                    orders.add(order);
                }
                line = reader1.readLine();
            }
            reader.close();

        } catch (IOException e) {
            return orders = null;
        }

        return orders;
    }
}