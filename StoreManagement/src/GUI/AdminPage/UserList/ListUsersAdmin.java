package GUI.AdminPage.UserList;

import ClassAttribute.Member;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ListUsersAdmin {
    public JPanel Main;
    private JScrollPane scrollpane;
    private JPanel ListOfUsers;

    JFrame frame = new JFrame();

    public ListUsersAdmin(List<Member> members) throws IOException {
        ListOfUsers.setLayout(new GridLayout(members.size(), 1));
        for (int i = 0; i < members.size(); i++) {
            UserItemAdmin userItemAdmin = new UserItemAdmin();
            userItemAdmin.getUserID().setText(members.get(i).getId());
            userItemAdmin.getUserName().setText(members.get(i).getFullname());
            userItemAdmin.getUserPhone().setText(members.get(i).getPhone());
            userItemAdmin.getUserTotalSpend().setText("0");
            userItemAdmin.getUserMembership().setText(members.get(i).getMembership());
            ListOfUsers.add(userItemAdmin.getMain());
        }

//        frame.add(Main);
//        frame.setTitle("List Of Products");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        frame.setSize(960, 720);
    }
}
