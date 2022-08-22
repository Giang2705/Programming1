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

//    read database (add elements into object array)

//    array members
    public List<Member> readUserFile() throws IOException {
        BufferedReader b = null;
        String line = "";
        String delimiter = ", ";

        try {
            FileReader fr = new FileReader("StoreManagement/Database/users.csv");
            b = new BufferedReader(fr);

            while ((line = b.readLine()) != null) {
                String[] file = line.split(delimiter);

                if (file.length > 1) {
                    Member mem = new Member();
                    //   set value for member's attribute
                    mem.setUsername(file[0]);
                    mem.setPassword(file[1]);
                    mem.setFullname(file[2]);
                    mem.setPhone(file[3]);
                    mem.setId(file[4]);
                    mem.setMembership(file[5]);
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
            FileReader fr = new FileReader("StoreManagement/Database/admins.csv");
            b = new BufferedReader(fr);

            while ((line = b.readLine()) != null) {
                String[] file = line.split(delimiter);

                if (file.length > 1) {
                    Admin ad = new Admin();
                    //   set value for admin's attribute
                    ad.setAdminUsername(file[0]);
                    ad.setAdminPassword(file[1]);
                    ad.setAdminId(file[2]);

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
            FileReader reader = new FileReader("StoreManagement/Database/categories.csv");
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
            FileReader reader = new FileReader("StoreManagement/Database/products.csv");
            BufferedReader reader1 = new BufferedReader(reader);
            reader1.readLine();
            String line;
            line = reader1.readLine();

//            boolean firstLine = true;
            while (line != null) {
                String[] array = line.split(",");
                Product temp = new Product(array[0],array[1],new Category(array[2]), Integer.parseInt(array[3]));
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
        BufferedReader b = null;
        String line = "";
        String delimiter = ",";

        try {
            FileReader fr = new FileReader("StoreManagement/Database/cart.csv");
            b = new BufferedReader(fr);

            while ((line = b.readLine()) != null) {
                String[] file = line.split(delimiter);

                if (file.length > 1) {
                    Member member = new Member();
                    Product product = null;

                    List<Member> members = readUserFile();
                    List<Product> products = readProductFile();

                    for (int i = 0; i < members.size(); i++){
                        if (file[1].equals(members.get(i).getUsername())){
                            member = members.get(i);
                        }
                    }

                    for (int i = 0; i < products.size(); i++){
                        if (file[2].equals(products.get(i).getProductName())){
                            product = products.get(i);
                        }
                    }

                    Cart cart = new Cart(member, product, Integer.parseInt(file[2]), Integer.parseInt(file[3]));
                    //   set value for member's attribute
                    carts.add(cart);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return carts;
    }
}
