package ClassAttribute;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Admin {
    private String id;
    private String username;
    private String password;

    public Admin() {}

    public Admin (String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public void addNewAdminAccount() {
        try {
            FileWriter fw = new FileWriter("admins.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(id + "," + username + "," + password);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null, "Record saved");
        }
        catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Record not saved");
        }
    }

    public String displayAdminInfo() { return this.toString();}


    public String getAdminId() {
        return id;
    }

    public void setAdminId(String id) {
        this.id = id;
    }

    public String getAdminUsername() {
        return username;
    }

    public void setAdminUsername(String username) {
        this.username = username;
    }

    public String getAdminPassword() {
        return password;
    }

    public void setAdminPassword(String password) {
        this.password = password;
    }

}


