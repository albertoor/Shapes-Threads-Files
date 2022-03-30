package services.files.create;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static constants.FilesMessages.INPUT_FILE_NAME;
import static constants.FilesMessages.FILE_EXIST;
import static constants.FilesMessages.FILE_CREATED;

public class CreateFileService  {
    private final static String EXTENSION = ".txt";
    public synchronized static String createFile(String path) {
        boolean fileCreated = false;
        File file = null;
        do {
            try{
                String nameFile = JOptionPane.showInputDialog(INPUT_FILE_NAME);
                file = new File(path + "/" +  nameFile + EXTENSION);
                if (file.exists())
                    JOptionPane.showMessageDialog(null, String.format(FILE_EXIST, nameFile));
                else{
                    fileCreated = file.createNewFile();
                    if (fileCreated)
                        JOptionPane.showMessageDialog(null, String.format(FILE_CREATED, nameFile));
                }
            }catch (NullPointerException | IOException e){
                fileCreated = false;
            }
        } while (!fileCreated);
        return file.getPath();
    }
}
