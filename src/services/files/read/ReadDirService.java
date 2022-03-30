package services.files.read;

import constants.PathsMessages;

import java.io.File;
import java.util.HashMap;

import static constants.PathsMessages.CALCULATE_ABSOLUTE_ROUTE;

public class ReadDirService {
    public static HashMap<Integer, String> readDirs() {
        HashMap<Integer, String> dirs = new HashMap<>();
        int count = 0;
        for (final File path : new File(CALCULATE_ABSOLUTE_ROUTE).listFiles()){
            if (path.isDirectory()) {
                dirs.put(count++, String.valueOf(path));
                System.out.println(path);
            }
        }
        return dirs;
    }
    //        dirs.forEach((key, value) -> System.out.println(String.format(LIST_DIRS, key, value)));
}
