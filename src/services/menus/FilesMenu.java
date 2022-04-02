package services.menus;

import microservices.FileMenuMicroservice;
import services.files.open.OpenFileAsync;
import services.files.read.ReadDirService;
import services.files.read.ReadFilesDirService;
import java.util.*;

public class FilesMenu extends Thread {

    public void run() {
        HashMap<Integer, String> dirs = ReadDirService.readDirs();
        String dirPath = FileMenuMicroservice.getOptionSelected(dirs);
        HashMap<Integer, String> files = ReadFilesDirService.read(dirPath);
        List<String> filesPaths = FileMenuMicroservice.getOptionFiles(files);
        new OpenFileAsync().openFile(filesPaths);
    }
}
