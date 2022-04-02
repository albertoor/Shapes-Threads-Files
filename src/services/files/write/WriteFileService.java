package services.files.write;

import interfaces.Shape;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteFileService {
    public synchronized static void write(String shapeData, String path) {
        try {
            FileWriter fw = new FileWriter(path, StandardCharsets.UTF_8);
            String fileContent = shapeData;
            fw.write(fileContent);
            fw.close();
        }catch (IOException e){
            System.out.println("algo salio mal");
        }
    }
}
