import ClassAttribute.Admin;
import ClassAttribute.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class readDatabase {
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


}
