package GUI.Components;

import ClassAttribute.Member;
import ClassAttribute.Order;
import Functions.readDatabase;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ListUsersAdmin {
    public JPanel getMain() {
        return Main;
    }

    private JPanel Main;
    private JTable tableOfUsers;
    private JPanel ListOfUsers;


    JFrame frame = new JFrame();

    private static class Table extends AbstractTableModel {
        List<Member> members;
        private String[] Headers = {"Id", "Username", "Password", "Fullname", "Phone", "Membership", "Spending"};

        private Table (List<Member> members){
            this.members = members;
        }

        @Override
        public int getRowCount() {
            return members.size();
        }

        @Override
        public int getColumnCount() {
            return Headers.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return switch (columnIndex){
                case 0 -> members.get(rowIndex).getId();
                case 1 -> members.get(rowIndex).getUsername();
                case 2 -> members.get(rowIndex).getPassword();
                case 3 -> members.get(rowIndex).getFullname();
                case 4 -> members.get(rowIndex).getPhone();
                case 5 -> members.get(rowIndex).getMembership();
                case 6 -> members.get(rowIndex).getTotalSpending();
                default -> "-";
            };
        }

        @Override
        public String getColumnName(int column){
            return Headers[column];
        }
    }

    public ListUsersAdmin() throws IOException {
        readDatabase readDatabase = new readDatabase();
        List<Member> members = readDatabase.readUserFile();
        Table table = new Table(members);
        tableOfUsers.setModel(table);
        tableOfUsers.setAutoCreateRowSorter(true);
    }
}
