import ClassAttribute.Admin;
import ClassAttribute.Member;

import javax.swing.*;
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

                        for (int i = 0; i < members.size()-1; i++){
                            if (members.get(i).getUsername() == username){
                                memberHomePage.getBtnAccount().setText(members.get(i).getUsername());
                            }
                        }
                    }

//                    else {
//                        MemberHomePage modal = new MemberHomePage();
//                        if(JOptionPane.showConfirmDialog(modal, "Wrong username or password! Please try again", "Failed", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
//                            System.exit(0);
//                        }
//                    }
                }
            }
//            System.out.println(members.size());
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    public void readAdminFile(String id, String username, String password) throws IOException {
        BufferedReader b = null;
        String line = "";
        String delimiter = ", ";

        try {
            List<Admin> admins = new ArrayList<Admin>();
            FileReader fr = new FileReader("/C:/StoreManagement/UsersDB/admins.csv");
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
                        MemberHomePage memberHomePage = new MemberHomePage();
                        memberHomePage.getBtnAccount().setText(ad.getAdminUsername());
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
