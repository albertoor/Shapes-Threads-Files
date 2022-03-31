package services.files.write;

import interfaces.Shape;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

import static constants.FilesMessages.FILE_WRITTEN;

public class WriteFileService implements Runnable{
    private String shapeData;
    private String path;

    public WriteFileService(String shapeData, String path) {
        this.shapeData = shapeData;
        this.path = path;
    }

    @Override
    public void run() {
        write(shapeData, path);
    }

    public static void write(String shapeData, String path) {
        try {
            FileWriter fw = new FileWriter(path);
            String fileContent = shapeData;
            fw.write(fileContent);
            JOptionPane.showMessageDialog(null, String.format(FILE_WRITTEN, path));
            fw.close();
        }catch (IOException e){
            System.out.println("algo salio mal");
        }
    }
}
