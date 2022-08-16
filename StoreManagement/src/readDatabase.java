import ClassAttribute.Admin;
import ClassAttribute.Category;
import ClassAttribute.Member;
import ClassAttribute.Product;

import java.io.*;
import java.util.*;

public class readDatabase {
    List<String> categoryNames = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    public void readFile(String username, String password, String fullname, String phone) throws IOException {
        BufferedReader b = null;
        String line = "";
        String delimiter = ", ";

        try {
            List<Member> members = new ArrayList<Member>();
            FileReader fr = new FileReader("/C:/StoreManagement/UsersDB/users.csv");
            b = new BufferedReader(fr);
            while ((line = b.readLine()) != null) {
                String[] file = line.split(delimiter);

                if (file.length > 0){
                    Member mem = new Member();
                    //   set value for member's attribute
                        mem.setUsername(username);
                        mem.setPassword(password);
                        mem.setFullname(fullname);
                        mem.setPhone(phone);
                        members.add(mem);

                    if (file[0].equals(username) && file[1].equals(password)) {
                        MemberHomePage memberHomePage = new MemberHomePage();
                        memberHomePage.getBtnAccount().setText(mem.getUsername());
                    }
                }
            }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public void readAdminFile(String id, String username, String password) throws IOException {
        BufferedReader b = null;
        String line = "";
        String delimiter = ",";

        try {
            List<Admin> admins = new ArrayList<Admin>();
            FileReader fr = new FileReader("admins.csv");
            b = new BufferedReader(fr);
            while ((line = b.readLine()) != null) {
                String[] file = line.split(delimiter);

                if (file.length > 0){
                    Admin ad = new Admin();
                    //   set value for member's attribute
                    ad.setAdminId(id);
                    ad.setAdminUsername(username);
                    ad.setAdminPassword(password);

                    admins.add(ad);

                    if (file[0].equals(username) && file[1].equals(password)) {
                        AdminHomePage adminHomePage = new AdminHomePage();
                        adminHomePage.getBtnAccount().setText(ad.getAdminUsername());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCategoryFile() throws IOException {
        try {
            FileReader reader = new FileReader("categories.csv");
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
// day dung k
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }

// read product File
    public void readProductFile() throws IOException {
        try {
            FileReader reader = new FileReader("products.csv");
            BufferedReader reader1 = new BufferedReader(reader);
            reader1.readLine();
            String line;
            line = reader1.readLine();

//            boolean firstLine = true;
            while (line != null) {
                String[] array = line.split(",");
                Product temp = new Product(array[0],array[1],new Category(array[2]),Double.parseDouble(array[3]));
//                if (array[0] != "id" && array[1] != "name") {
                    System.out.printf("ProId: " + temp.getProductId() + ", ProName: " + temp.getProductName() + ", ProCat: " + temp.getProductCategory().getCategoryName() + ", ProPrice: " + temp.getProductPrice() + "\n");
                products.add(temp);
                line = reader1.readLine();;
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
// day dung k
    }

    public List<Product> getProductsList() {
        return products;
    }

}
