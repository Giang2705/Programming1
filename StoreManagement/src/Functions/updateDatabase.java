package Functions;

import ClassAttribute.Product;
import GUI.Components.ProductExists;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class updateDatabase {

//    Have your txt file 1 record per line.
//    Separate each field by separator.
//    Create another temporary text file in memory.
//    Modify the records and save the records in the temporary file.
//    Delete the original file.
//    Rename the temporary file with original file name.
    private Scanner x;
    public void editProduct(String filepath,
                            Product newUpdated) {
        String tempfile = "productTemp.csv";
        File oldFile = new File(filepath);
        File newFile = new File(tempfile);
//        String ID = "";
//        String name = "";
//        String cat = "";
//        String price = "";
        String rl = "";
        String delimiter = ",";
        try {
            FileReader fr = new FileReader("Database/products.csv");
            BufferedReader b = new BufferedReader(fr);
//            boolean proChecked = true;
            FileWriter fw = new FileWriter(tempfile);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            while ((rl = b.readLine()) != null) {
                String[] file = rl.split(delimiter);
                if (file.length > 0) {
                    if(file[0].equals(newUpdated.getProductId())){
                        System.out.println("False");
//                        proChecked = false;
                        pw.println(newUpdated.getProductId() + "," +  newUpdated.getProductName()+ "," + newUpdated.getProductCategory().getCategoryName()+ "," +newUpdated.getProductPrice());
                        System.out.println(oldFile.getAbsoluteFile());
                    }
                    else {
                        pw.println(rl);
                    }
                }
            }
//            x.close();;
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
