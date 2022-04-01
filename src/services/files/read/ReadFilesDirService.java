package services.files.read;

import java.io.File;
import java.util.HashMap;

public class ReadFilesDirService {
    public static HashMap<Integer, String> read(String dirPath) {
        HashMap<Integer, String> filesPath = new HashMap<>();
        int count = 0;
        for (final File filePath : new File(dirPath).listFiles()){
            if (filePath.isFile()){
                filesPath.put(count++, String.valueOf(filePath));
            }
        }
        return filesPath;
    }
}
