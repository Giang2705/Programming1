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
}
