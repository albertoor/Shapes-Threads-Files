package services.files.create;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static constants.FilesMessages.*;

public class CreateFileService {
    private final static String EXTENSION = ".txt";

    public static synchronized String createFile(String path) {
        boolean fileCreated = false;
        File file = null;
        do {
            try{
                String nameFile = JOptionPane.showInputDialog(INPUT_FILE_NAME);
                file = new File(path + "/" +  nameFile + EXTENSION);
                if (file.exists()) {
                    JOptionPane.showMessageDialog(null, String.format(FILE_EXIST, nameFile));
                }
                else{
                    fileCreated = file.createNewFile();
                    if (fileCreated) {
                        JOptionPane.showMessageDialog(null, String.format(FILE_CREATED, nameFile));
                    }
                }
            }catch (NullPointerException | IOException e){
               JOptionPane.showMessageDialog(null, BAD);
            }
        } while (!fileCreated);
        return file.getPath();
    }
}