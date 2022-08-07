import ClassAttribute.Member;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class storeDatabase {
    int line;
    //    Create new file csv
    File f = new File("/C:/StoreManagement/UsersDB");
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
}
