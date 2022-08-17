import ClassAttribute.Admin;
import ClassAttribute.Category;
import ClassAttribute.Product;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class storeDatabase {
    int line;
    //    Create new file csv
    File f = new File("/C:/StoreManagement/UsersDB");
//    File adminF = new File()
    public void createFolder() {
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    public void createFile() {
        File file = new File("/C:/StoreManagement/UsersDB/users.csv");
        if (!file.exists()){
            try {
                FileWriter fw = new FileWriter("/C:/StoreManagement/UsersDB/users.csv");
                System.out.println("File created!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void createAdminFile() {
        File adminFile = new File("admins.csv");
        if (!adminFile.exists()) {
            try {
                FileWriter fw = new FileWriter("admins.csv");
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
        File categoryFile = new File("categories.csv");
        if (!categoryFile.exists()) {
            try {
                FileWriter fw = new FileWriter("categories.csv");
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
        File categoryFile = new File("products.csv");
        if (!categoryFile.exists()) {
            try {
                FileWriter fw = new FileWriter("products.csv");
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
    void count(){
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
            RandomAccessFile raf = new RandomAccessFile("admins.csv", "rw");
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
            FileWriter fw = new FileWriter("admins.csv", true);
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

    void productCountLine() {
        try {
            line = 1;
            RandomAccessFile raf = new RandomAccessFile("products.csv", "rw");
            for (int i = 0; raf.readLine() != null; i++){
                line++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    void categoryCountLine() {
        try {
            line = 1;
            RandomAccessFile raf = new RandomAccessFile( "categories.csv", "rw");
            for (int i = 0; raf.readLine() != null; i++){
                line++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }



    public void register(String username, String password, String fullname, String phone) {
//        add new data in db
        try {
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
            System.out.println("User created!");
        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // add new product
    public void addNewProduct(Product product) {
        // add new Product in db
        try {
            FileWriter fw = new FileWriter("products.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.printf("%s,%s,%s,%.2f\n", product.getProductId(), product.getProductName(), product.getProductCategory().getCategoryName(),product.getProductPrice());
            pw.flush();
            pw.close();
//            PrintWriter print = new PrintWriter("categories.csv");
//            print.printf("%s,%s\n", category.getCategoryId(), category.getCategoryName());
//            print.close();
            System.out.println("Successfully creating a new product!");
        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // add new category
    public void addNewCategory(Category category) {
        // add new Product in db
        try {
            FileWriter fw = new FileWriter("categories.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.printf("%s\n", category.getCategoryName());
            pw.flush();
            pw.close();
//            PrintWriter print = new PrintWriter("categories.csv");
//            print.printf("%s,%s\n", category.getCategoryId(), category.getCategoryName());
//            print.close();
            System.out.println("Successfully creating a new category!");
        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
