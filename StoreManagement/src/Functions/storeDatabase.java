package Functions;

import ClassAttribute.*;
import GUI.Components.AccountExists;
import GUI.Components.CategoryExistsMessage;
import GUI.Components.ProductExists;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class storeDatabase {
    int line;
    //    Create new file csv
    File f = new File("Database");
    public void createFolder() {
        if (!f.exists()) {
            f.mkdirs();
        }
    }

//    create user database
    public void createFile() {
        File file = new File("Database/users.csv");
        if (!file.exists()){
            try {
                FileWriter fw = new FileWriter("Database/users.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("id,username,password,fullname,phone,membership,spending,status");
                pw.flush();
                pw.close();
                System.out.println("User File created!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    //    create admin database
    public void createAdminFile() {
        File adminFile = new File("Database/admins.csv");
        if (!adminFile.exists()) {
            try {
                FileWriter fw = new FileWriter("Database/admins.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("id,username,password,status");
                pw.flush();
                pw.close();

                System.out.println("Admin file created!");
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //    create category database
    public void createCategoryFile() {
        File categoryFile = new File("Database/categories.csv");
        if (!categoryFile.exists()) {
            try {
                FileWriter fw = new FileWriter("Database/categories.csv");
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
    //    create products database
    public void createProductFile() {
        File productFile = new File("Database/products.csv");
        if (!productFile.exists()) {
            try {
                FileWriter fw = new FileWriter("Database/products.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("id,name,category,price");
                pw.flush();
                pw.close();
                System.out.println("Product file created!");
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //    create cart database
    public void createCartsFile(){
        File cartFile = new File("Database/cart.csv");
        if (!cartFile.exists()) {
            try {
                FileWriter fw = new FileWriter("Database/cart.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("id,member's name,product's name,amount,total,created date,status");
                pw.flush();
                pw.close();
                System.out.println("Carts file created!");
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //    create order database
    public void createOrdersFile(){
        File ordersFile = new File("Database/orders.csv");
        if (!ordersFile.exists()) {
            try {
                FileWriter fw = new FileWriter("Database/orders.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("id,member's name,products,total,created date,status");
                pw.flush();
                pw.close();
                System.out.println("Orders file created!");
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

//    void adminCountLine() {
//        try {
//            line = 1;
//            RandomAccessFile raf = new RandomAccessFile("Database/admins.csv", "rw");
//            for (int i = 0; raf.readLine() != null; i++){
//                line++;
//            }
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex){
//            ex.printStackTrace();
//        }
//    }

//    public void addNewAdmin(Admin admin) {
//        // add new Product in db
//        try {
//            FileWriter fw = new FileWriter("Database/admins.csv", true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter pw = new PrintWriter(bw);
//            pw.printf("%s,%s,%s\n", admin.getAdminId(),admin.getAdminUsername(),admin.getAdminPassword(),admin.getStatus());
//            pw.flush();
//            pw.close();
//            System.out.println("Successfully creating a new admin!");
//        } catch (FileNotFoundException e) {
//            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
//        } catch (IOException e) {
//            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }

    public void productCountLine() {
        try {
            line = 1;
            RandomAccessFile raf = new RandomAccessFile("Database/products.csv", "rw");
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
            RandomAccessFile raf = new RandomAccessFile( "Database/categories.csv", "rw");
            for (int i = 0; raf.readLine() != null; i++){
                line++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void cartCountLine(){
        try {
            line = 1;
            RandomAccessFile raf = new RandomAccessFile("Database/cart.csv", "rw");
            for (int i = 0; raf.readLine() != null; i++){
                line++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void ordersCountLine(){
        try {
            line = 1;
            RandomAccessFile raf = new RandomAccessFile("Database/orders.csv", "rw");
            for (int i = 0; raf.readLine() != null; i++){
                line++;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }



    public void register(JFrame frame, String username, String password, String fullname, String phone, String id, String membership, Double totalSpending, String status) {
        BufferedReader b = null;
        String rl = "";
        String delimiter = ",";

//        add new data in db
        try {
//            condition
            List<Member> members = new ArrayList<Member>();
            FileReader fr = new FileReader("Database/users.csv");
            b = new BufferedReader(fr);
            boolean checked = true;

            while ((rl = b.readLine()) != null) {
                String[] file = rl.split(delimiter);

                if (file.length > 1) {
                    if(file[1].equals(username)){
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
                raf.writeBytes(id);
                raf.writeBytes(",");
                raf.writeBytes(username);
                raf.writeBytes(",");
                raf.writeBytes(password);
                raf.writeBytes(",");
                raf.writeBytes(fullname);
                raf.writeBytes(",");
                raf.writeBytes(phone);
                raf.writeBytes(",");
                raf.writeBytes(membership);
                raf.writeBytes(",");
                raf.writeBytes(String.valueOf(totalSpending));
                raf.writeBytes(",");
                raf.writeBytes(status);

                JFrame modal = new JFrame("Successful");
                modal.setVisible(true);
                JOptionPane.showMessageDialog(frame, "Your account is registered!");
                modal.dispose();

                System.out.println("User created!");
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // add new product
    public void addNewProduct(JFrame frame, Product product) {
        // add new Product in db
        String rl = "";
        String delimiter = ",";
        try {
            FileReader fr = new FileReader("Database/products.csv");
            BufferedReader b = new BufferedReader(fr);
            boolean proChecked = true;

            while ((rl = b.readLine()) != null) {
                String[] file = rl.split(delimiter);

                if (file.length > 1) {
                    if(file[1].equals(product.getProductName())){
                        System.out.println("False");
                        proChecked = false;
                        ProductExists productExists = new ProductExists();
                        break;
                    }
                }
            }
            if (proChecked) {
                FileWriter fw = new FileWriter("Database/products.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.printf("%s,%s,%s,%s\n", product.getProductId(), product.getProductName(), product.getProductCategory().getCategoryName(),product.getProductPrice());
                pw.flush();
                pw.close();

                JFrame modal = new JFrame("Successful");
                modal.setVisible(true);
                JOptionPane.showMessageDialog(frame, "Product added successfully!");
                modal.dispose();
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
            FileReader fr = new FileReader("Database/categories.csv");
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
                FileWriter fw = new FileWriter("Database/categories.csv", true);
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
    public void addProductToCart(Cart cart) {
        BufferedReader b = null;
        String rl = "";
        String delimiter = ",";

//        add new data in db
        try {
//            condition
            List<Cart> carts = new ArrayList<Cart>();
            FileReader fr = new FileReader("Database/cart.csv");
            b = new BufferedReader(fr);

            while ((rl = b.readLine()) != null) {
                String[] file = rl.split(delimiter);
            }
            RandomAccessFile raf = new RandomAccessFile(f + "/cart.csv", "rw");

            for(int i = 0; i<line; i++){
                raf.readLine();
            }

            raf.writeBytes("\r\n");
            raf.writeBytes(cart.getId());
            raf.writeBytes(",");
            raf.writeBytes(cart.getMember().getUsername());
            raf.writeBytes(",");
            raf.writeBytes(cart.getProduct().getProductName());
            raf.writeBytes(",");
            raf.writeBytes(String.valueOf(cart.getAmount()));
            raf.writeBytes(",");
            raf.writeBytes(String.valueOf(cart.getTotal()));
            raf.writeBytes(",");
            raf.writeBytes(GetDate.GetDate());
            raf.writeBytes(",");
            raf.writeBytes(cart.getStatus());

            System.out.println("Product added successfully!");


        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void addOrder(Order order, List<Cart> cart) throws IOException {
        readDatabase readDatabase = new readDatabase();

        BufferedReader b = null;
        String rl = "";
        String delimiter = ",";

//        add new data in db
        try {
//            condition
            List<Order> orders = new ArrayList<Order>();
            FileReader fr = new FileReader("Database/orders.csv");
            b = new BufferedReader(fr);

            while ((rl = b.readLine()) != null) {
                String[] file = rl.split(delimiter);
            }
            RandomAccessFile raf = new RandomAccessFile(f + "/orders.csv", "rw");

            for(int i = 0; i<line; i++){
                raf.readLine();
            }

            raf.writeBytes("\r\n");
            raf.writeBytes(order.getId());
            raf.writeBytes(",");
            raf.writeBytes(order.getCart().get(0).getMember().getUsername());
            raf.writeBytes(",");
            for (int i = 0; i < cart.size(); i++){
                raf.writeBytes(cart.get(i).getId());
                raf.writeBytes("-");
                raf.writeBytes(cart.get(i).getProduct().getProductName());
                raf.writeBytes("-");
                raf.writeBytes(String.valueOf(cart.get(i).getAmount()));
                if (i != cart.size()-1){
                    raf.writeBytes("+");
                }
            }
            raf.writeBytes(",");
            raf.writeBytes(String.valueOf(order.getTotal()));
            raf.writeBytes(",");
            raf.writeBytes(GetDate.GetDate());
            raf.writeBytes(",");
            raf.writeBytes(order.getStatus());

            System.out.println("Order confirmed successfully!");


        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}