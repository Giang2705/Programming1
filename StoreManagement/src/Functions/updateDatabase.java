package Functions;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.Scanner;

public class updateDatabase {
    private Scanner x;
    public void editProduct(String filepath,
                            String editTerm,
                            String newID,
                            String newName,
                            String newCat,
                            String newPrice) {
        String tempfile = "productTemp.csv";
        File oldFile = new File(filepath);
        File newFile = new File(tempfile);
        String ID = "";
        String name = "";
        String cat = "";
        String price = "";
        try {
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                ID = x.next();
                name = x.next();
                cat = x.next();
                price = x.next();
                if (ID.equals(editTerm)) {
                    pw.println(newID + "," + newName + "," + newCat + "," + newPrice);
                } else {
                    pw.println(ID + "," + name + "," + cat + "," + price);
                }
            }
            x.close();;
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
}
