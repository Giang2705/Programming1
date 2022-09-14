package Functions;

import ClassAttribute.Product;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class deleteDatabase {
    private static Scanner x;

    public void removeRecord(String filepath, Product deleteProduct) {
        String tempfile = "productTemp.csv";
        File oldFile = new File(filepath);
        File newFile = new File(tempfile);
        String rl = "";
        String delimiter = ",";
        try {
            FileReader fr = new FileReader("Database/products.csv");
            BufferedReader b = new BufferedReader(fr);
            FileWriter fw = new FileWriter(tempfile);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            while ((rl = b.readLine()) != null) {
                String[] file = rl.split(delimiter);
                if (file.length > 0) {
                    if(!file[0].equals(deleteProduct.getProductId())){
                        pw.println(rl);
                    }
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
}
