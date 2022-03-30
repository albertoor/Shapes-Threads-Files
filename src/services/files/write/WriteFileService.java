package services.files.write;

import interfaces.Shape;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import static constants.FilesMessages.FILE_WRITTEN;

public class WriteFileService {
    public synchronized static boolean write(String shapeData, String path) {
        boolean isFileWritten = false;
        try {
            FileWriter fw = new FileWriter(path);
            String fileContent = shapeData;
            fw.write(fileContent);
            JOptionPane.showMessageDialog(null, String.format(FILE_WRITTEN, path));
            fw.close();
            isFileWritten = true;
        }catch (IOException e){
            System.out.println("algo salio mal");
        }
        return isFileWritten;
    }
}
