import ClassAttribute.Admin;
import ClassAttribute.Category;
import ClassAttribute.Member;
import ClassAttribute.Product;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class readDatabase {
    List<String> categoryNames = new ArrayList<>();
    List<Product> products = new ArrayList<>();
    public void readFile(String username, String password, String fullname, String phone, String id, String membership) throws IOException {
        BufferedReader b = null;
        String line = "";
        String delimiter = ", ";

        try {
            List<Member> members = new ArrayList<Member>();
            FileReader fr = new FileReader("StoreManagement/Database/users.csv");
            b = new BufferedReader(fr);
            boolean checked = false;

            while ((line = b.readLine()) != null) {
                String[] file = line.split(delimiter);

                    if (file.length > 0) {
                        Member mem = new Member();
                        //   set value for member's attribute
                        mem.setUsername(username);
                        mem.setPassword(password);
                        mem.setFullname(fullname);
                        mem.setPhone(phone);
                        mem.setId(id);
                        mem.setMembership(membership);

                        members.add(mem);

                        if (file[0].equals(username) && file[1].equals(password)) {
                            MemberHomePage memberHomePage = new MemberHomePage();

                            for (int i = 0; i < members.size() - 1; i++) {
                                if (members.get(i).getUsername() == username) {
                                    memberHomePage.getBtnAccount().setText(members.get(i).getUsername());
                                }
                            }
                            checked = true;
                            break;
                        }
                    }
                }
            if (checked == false) {
                System.out.println(false);
                LoginFailed loginFailed = new LoginFailed();
                UserLoginPage userLoginPage = new UserLoginPage();
            }

//            System.out.println(members.size());
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public void readAdminFile(String id, String username, String password) throws IOException {
//        BufferedReader b = null;
//        String line = "";
//        String delimiter = ",";
        try {
            List<Admin> admins = new ArrayList<Admin>();
            FileReader fr = new FileReader("admins.csv");
            BufferedReader b = new BufferedReader(fr);
//            b.readLine();
            String line;
            line = b.readLine();

            while (line != null) {
                String[] file = line.split(",");

//                if (file.length > 0){
                Admin ad = new Admin();
                    //   set value for member's attribute
                ad.setAdminId(id);
                ad.setAdminUsername(username);
                ad.setAdminPassword(password);
                admins.add(ad);
                line = b.readLine();
                if (file[0].equals(username) && file[1].equals(password)) {
                    AdminHomePage adminHomePage = new AdminHomePage();
                    adminHomePage.getBtnAccount().setText(ad.getAdminUsername());
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
                line = reader1.readLine();
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
