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
//        File adminFile = new File("/C:/StoreManagement/UsersDB/admin.csv");
        File productFile = new File("/C:/StoreManagement/UsersDB/products.csv");
        File categoryFile = new File("/C:/StoreManagement/UsersDB/categories.csv");

        if (!file.exists()){
            try {
                FileWriter fw = new FileWriter("/C:/StoreManagement/UsersDB/users.csv");
                System.out.println("File created!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
//        if (!adminFile.exists()){
//            try {
//                FileWriter fw = new FileWriter("/C:/StoreManagement/UsersDB/users.csv");
//                BufferedWriter bw = new BufferedWriter(fw);
//                PrintWriter pw = new PrintWriter(bw);
//                pw.println("id,username,password");
//                pw.flush();
//                pw.close();
//                System.out.println("File created!");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        if (!productFile.exists()){
            try {
                FileWriter fw = new FileWriter("/C:/StoreManagement/UsersDB/products.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("id,name,category,price");
                pw.flush();
                pw.close();
                System.out.println("File created!");
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (!categoryFile.exists()) {
            try {
                FileWriter fw = new FileWriter("/C:/StoreManagement/UsersDB/categories.csv");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("id,name");
                pw.flush();
                pw.close();
                System.out.println("File created!");
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

    void productCountLine() {
        try {
            line = 1;
            RandomAccessFile raf = new RandomAccessFile(f + "/products.csv", "rw");
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
            RandomAccessFile raf = new RandomAccessFile(f + "/categories.csv", "rw");
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


    public void addNewProduct(String id,
                              String name,
//                              Category category,
                              double price) {
        // add new Product in db
        try {
            RandomAccessFile raf = new RandomAccessFile(f + "/products.csv", "rw");

            for(int i = 0; i<line; i++){
                raf.readLine();
            }

            raf.writeBytes("\r\n");
            raf.writeBytes(id);
            raf.writeBytes(", ");
            raf.writeBytes(name);
            raf.writeBytes(", ");
//            raf.writeBytes(category.getCategoryName());
//            raf.writeBytes(", ");
            raf.writeBytes(String.valueOf(price));
            System.out.println("Product created!");
        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    public void addNewCategory(String id, String name) {
        // add new Product in db
        try {
            RandomAccessFile raf = new RandomAccessFile(f + "/categories.csv", "rw");

            for(int i = 0; i<line; i++){
                raf.readLine();
            }

            raf.writeBytes("\r\n");
            raf.writeBytes(id);
            raf.writeBytes(", ");
            raf.writeBytes(name);
            System.out.println("Category created!");
        } catch (FileNotFoundException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
            Logger.getLogger(storeDatabase.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
