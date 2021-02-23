package myFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class File_IO {
    public static void writeObjectToFile(Object serObj, String filepath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Object readFromFile(String filepath) {
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Object obj = objectIn.readObject();
            objectIn.close();
            return obj;
        } catch (Exception ex) {
            System.out.println("File dang chua co thong tin !");
            return null;
        }
    }
}
