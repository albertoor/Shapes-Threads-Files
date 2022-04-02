package services.files.write;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import static constants.FilesMessages.FILE_WRITTEN;

public class WriteFileService {
    public synchronized static void write(String shapeData, String path) {
        try {
            FileWriter fw = new FileWriter(path, StandardCharsets.UTF_8);
            String fileContent = shapeData;
            fw.write(fileContent);
            JOptionPane.showMessageDialog(null, FILE_WRITTEN);
            fw.close();
        }catch (IOException e){
            System.out.println("algo salio mal");
        }
    }
}
