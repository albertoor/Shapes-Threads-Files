package services.files.create;

import utils.DateFormatUtil;
import java.io.File;
import static constants.FilesMessages.DIR_CREATED;
import static constants.PathsMessages.CALCULATES_ROUTE_TO_ADD;

public class CreateDirService {
    private static final String PATH = CALCULATES_ROUTE_TO_ADD;
    public static String createDir() {
        String nameDir = new DateFormatUtil().getCurrentDate();
        File dir = new File(PATH + nameDir);
        System.out.println(dir.getPath());
        boolean isDirCreated = dir.mkdir();
        if (isDirCreated) System.out.printf((DIR_CREATED) + "%n", nameDir);
        return dir.getPath();
    }
}
