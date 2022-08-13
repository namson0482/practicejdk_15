package vunam.file;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObjectToFile {
    private static final String filepath="/Users/macbook/Docs/obj";

    public static void main(String args[]) {

        WriteObjectToFile objectIO = new WriteObjectToFile();

        Student student = new Student("John","Frost",22);
        objectIO.WriteObjectToFile(student);
    }

    public void WriteObjectToFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
