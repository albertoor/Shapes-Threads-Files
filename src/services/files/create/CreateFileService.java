package services.files.create;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static constants.FilesMessages.*;
import static constants.MenuMessages.NOT_NULL;

public class CreateFileService {
    private final static String EXTENSION = ".txt";

    public static synchronized String createFile(String path) {
        boolean fileCreated = false;
        File file = null;
        do {
            try{
                String fileName = JOptionPane.showInputDialog(INPUT_FILE_NAME);
                if (fileName == null) throw new NullPointerException();
                file = new File(path + "/" +  fileName + EXTENSION);
                if (file.exists()) {
                    JOptionPane.showMessageDialog(null, String.format(FILE_EXIST, fileName));
                }
                else{
                    fileCreated = file.createNewFile();
                    if (fileCreated) {
                        JOptionPane.showMessageDialog(null, String.format(FILE_CREATED, fileName));
                    }
                }
            }catch (IOException e){
               JOptionPane.showMessageDialog(null, BAD);
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, NOT_NULL);
            }
        } while (!fileCreated);
        return file.getPath();
    }
}