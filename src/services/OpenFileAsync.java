package services;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpenFileAsync {
    public static void openFile(String filePath) {
        try {
            Runtime.getRuntime().exec("open -a TextEdit " + filePath);
        }catch (IOException e){
            System.out.println("No");
        }
    }

//    public static void main(String[] args) {
//        openFile("./Calculos/2022-03-30/este.txt");
//    }
}
