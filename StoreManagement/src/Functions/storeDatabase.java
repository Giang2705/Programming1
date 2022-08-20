package Functions;

import ClassAttribute.Admin;
import ClassAttribute.Category;
import ClassAttribute.Member;
import ClassAttribute.Product;
import GUI.Components.AccountExists;
import GUI.Components.CategoryExistsMessage;
import GUI.Components.ProductExists;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class storeDatabase {
    int line;
    //    Create new file csv
    File f = new File("StoreManagement/Database");
//    File adminF = new File()
    public void createFolder() {
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    public void createFile() {
        File file = new File("StoreManagement/Database/users.csv");
        if (!file.exists()){
            try {
                FileWriter fw = new FileWriter("StoreManagement/Database/users.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("username, password, fullname, phone, id, membership");
                pw.flush();
                pw.close();
                System.out.println("File created!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void createAdminFile() {
        File adminFile = new File("StoreManagement/Database/admins.csv");
        if (!adminFile.exists()) {
            try {
                FileWriter fw = new FileWriter("StoreManagement/Database/admins.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("id,username,password");
                pw.flush();
                pw.close();

                System.out.println("Admin file created!");
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createCategoryFile() {
        File categoryFile = new File("StoreManagement/Database/categories.csv");
        if (!categoryFile.exists()) {
            try {
                FileWriter fw = new FileWriter("StoreManagement/Database/categories.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("name");
                pw.flush();
                pw.close();

                System.out.println("Category file created!");
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createProductFile() {
        File categoryFile = new File("StoreManagement/Database/products.csv");
        if (!categoryFile.exists()) {
            try {
                FileWriter fw = new FileWriter("StoreManagement/Database/products.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("id,name,category,price");
                pw.flush();
                pw.close();
//                PrintWriter print = new PrintWriter(categoryFile);
//                print.println("id,name");
//                print.close();
                System.out.println("Product file created!");
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



//    count line
public void count(){
        try {
            line = 1;
            RandomAccessFile raf = new RandomAccessFile(f + "/users.csv", "rw");
            for (int i = 0; raf.readLine() != null; i++){
                line++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    // count line for Product file

    void adminCountLine() {
        try {
            line = 1;
            RandomAccessFile raf = new RandomAccessFile("StoreManagement/Database/admins.csv", "rw");
            for (int i = 0; raf.readLine() != null; i++){
                line++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void addNewAdmin(Admin admin) {
        // add new Product in db
        try {
            FileWriter fw = new FileWriter("StoreManagement/Database/admins.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.printf("%s,%s,%s\n", admin.getAdminId(),admin.getAdminUsername(),admin.getAdminPassword());
            pw.flush();
            pw.close();
//            PrintWriter print = new PrintWriter("categories.csv");
//            print.printf("%s,%s\n", category.getCategoryId(), category.getCategoryName());
//            print.close();
            System.out.println("Successfully creating a new admin!");
        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void productCountLine() {
        try {
            line = 1;
            RandomAccessFile raf = new RandomAccessFile("StoreManagement/Database/products.csv", "rw");
            for (int i = 0; raf.readLine() != null; i++){
                line++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void categoryCountLine() {
        try {
            line = 1;
            RandomAccessFile raf = new RandomAccessFile( "StoreManagement/Database/categories.csv", "rw");
            for (int i = 0; raf.readLine() != null; i++){
                line++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }



    public void register(String username, String password, String fullname, String phone, String id, String membership) {
        BufferedReader b = null;
        String rl = "";
        String delimiter = ", ";

//        add new data in db
        try {
//            condition
            List<Member> members = new ArrayList<Member>();
            FileReader fr = new FileReader("StoreManagement/Database/users.csv");
            b = new BufferedReader(fr);
            boolean checked = true;

            while ((rl = b.readLine()) != null) {
                String[] file = rl.split(delimiter);

                if (file.length > 0) {
                    if(file[0].equals(username)){
                        System.out.println("False");
                        checked = false;
                        AccountExists accountExists = new AccountExists();
                        break;
                    }
                }
            }

//            available
            if(checked){
                RandomAccessFile raf = new RandomAccessFile(f + "/users.csv", "rw");

                for(int i = 0; i<line; i++){
                    raf.readLine();
                }

                raf.writeBytes("\r\n");
                raf.writeBytes(username);
                raf.writeBytes(", ");
                raf.writeBytes(password);
                raf.writeBytes(", ");
                raf.writeBytes(fullname);
                raf.writeBytes(", ");
                raf.writeBytes(phone);
                raf.writeBytes(", ");
                raf.writeBytes(id);
                raf.writeBytes(", ");
                raf.writeBytes(membership);

                System.out.println("User created!");
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // add new product
    public void addNewProduct(Product product) {
        // add new Product in db
        String rl = "";
        String delimiter = ",";
        try {

            FileReader fr = new FileReader("StoreManagement/Database/products.csv");
            BufferedReader b = new BufferedReader(fr);
            boolean proChecked = true;

            while ((rl = b.readLine()) != null) {
                String[] file = rl.split(delimiter);

                if (file.length > 0) {
                    if(file[0].equals(product.getProductName())){
                        System.out.println("False");
                        proChecked = false;
                        ProductExists productExists = new ProductExists();
                        break;
                    }
                }
            }
            if (proChecked) {
                FileWriter fw = new FileWriter("StoreManagement/Database/products.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.printf("%s,%s,%s,%s\n", product.getProductId(), product.getProductName(), product.getProductCategory().getCategoryName(),product.getProductPrice());
                pw.flush();
                pw.close();
//            PrintWriter print = new PrintWriter("categories.csv");
//            print.printf("%s,%s\n", category.getCategoryId(), category.getCategoryName());
//            print.close();
                System.out.println("Successfully creating a new product!");
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // add new category
    public void addNewCategory(Category category) {
        // add new Product in db
        String rl = "";
        try {
            FileReader fr = new FileReader("StoreManagement/Database/categories.csv");
            BufferedReader b = new BufferedReader(fr);
            boolean catChecked = true;

            while ((rl = b.readLine()) != null) {
                if(rl.equals(category.getCategoryName())){
                    System.out.println("False");
                    catChecked = false;
                    CategoryExistsMessage categoryExistsMessage = new CategoryExistsMessage();
                    break;
                }
            }
            if (catChecked) {
                FileWriter fw = new FileWriter("StoreManagement/Database/categories.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.printf("%s\n", category.getCategoryName());
                pw.flush();
                pw.close();
                System.out.println("Successfully creating a new category!");
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
