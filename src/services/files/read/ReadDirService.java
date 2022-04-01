package services.files.read;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;
import static constants.PathsMessages.CALCULATES_ROUTE_TO_ADD;

public class ReadDirService {
    public static HashMap<Integer, String> readDirs() {
        HashMap<Integer, String> dirs = new HashMap<>();
        int count = 0;
        for (final File path : Objects.requireNonNull(new File(CALCULATES_ROUTE_TO_ADD).listFiles())){
            if (path.isDirectory()) {
                dirs.put(count++, String.valueOf(path));
            }
        }
        return dirs;
    }
    //        dirs.forEach((key, value) -> System.out.println(String.format(LIST_DIRS, key, value)));
}
