package services.files.create;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static constants.FilesMessages.INPUT_FILE_NAME;
import static constants.FilesMessages.FILE_EXIST;
import static constants.FilesMessages.FILE_CREATED;

public class CreateFileService implements Runnable {
    private final static String EXTENSION = ".txt";
    private String path;
    private String shapeData;
    private String filePath;

//    public CreateFileService(String path, String shapeData) {
//        this.path = path;
//        this.shapeData = shapeData;
//    }

    public CreateFileService(String path) {
        this.path = path;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        setFilePath(createFile(path));
//        boolean isCreated = createFile(path);
//        if (isCreated) {
//            Thread t1 = new Thread(new WriteFileService(shapeData, path));
//            t1.start();
//        }
        // despues escribir archivo
    }

    public synchronized String createFile(String path) {
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
                    if (fileCreated){
                        JOptionPane.showMessageDialog(null, String.format(FILE_CREATED, nameFile));
//                        setFilePath(file.getPath());
                    }

                }
            }catch (NullPointerException | IOException e){
                System.out.println("Error");
            }
        } while (!fileCreated);
        return file.getPath();
//        return fileCreated;
    }


}