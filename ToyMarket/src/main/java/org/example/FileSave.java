package org.example;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public interface FileSave {
    public static void createFile(ArrayList<String> prizeList) throws Exception {
        File myFile = new File("Won Toys");
        myFile.createNewFile();
        FileWriter outputStream = new FileWriter(myFile);
        outputStream.write("Призовая игрушка: \n");
        for(Object str: prizeList) {
            outputStream.write(str.toString() + System.lineSeparator());
        }
        outputStream.close();
    }
}
