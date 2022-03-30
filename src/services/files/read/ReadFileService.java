package services.files.read;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileService {
    public static String read(String path) {
        char [] array = new char[150];
        try{
            FileReader fr = new FileReader(path);
            fr.read(array);
            fr.close();
        }catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }catch (IOException e){
            System.out.println("Algo salio mal");
        }
        return String.valueOf(array);
    }
}
