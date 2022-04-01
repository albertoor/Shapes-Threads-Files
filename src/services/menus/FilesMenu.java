package services.menus;

import abstracts.Menu;
import services.files.read.ReadDirService;
import services.files.read.ReadFileService;
import services.files.read.ReadFilesDirService;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import static constants.MenuMessages.SELECT_DIR;
import static constants.PathsMessages.LIST_DIRS;
import static constants.FilesMessages.FILE_DATA;

public class FilesMenu  {

    public static void run() {
        HashMap<Integer, String> dirs = ReadDirService.readDirs();
        String dirPath = getOptionSelected(dirs);
        HashMap<Integer, String> files = ReadFilesDirService.read(dirPath);
        String filePath = getOptionSelected(files);
        String fileContent = ReadFileService.read(filePath);
        String result = String.format(FILE_DATA, filePath, fileContent);
        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }

    public static StringBuilder fillMenuText(HashMap<Integer, String> dirs){
        StringBuilder textMenu = new StringBuilder(SELECT_DIR);
        dirs.forEach((k, v) -> textMenu.append(String.format(LIST_DIRS, k, v)));
        return textMenu;
    }

    public static String getDirPath(HashMap<Integer, String> dirs, int option) {
        for (Map.Entry<Integer, String> dir : dirs.entrySet())
            if (dir.getKey().equals(option))
                return dir.getValue();
        return null;
    }

    public static String getOptionSelected(HashMap<Integer, String> map) {
        String dirPath = "";
        boolean hasDir = false;
        StringBuilder sbMenu = fillMenuText(map);
        do {
            try {
                int option = Integer.parseInt(JOptionPane.showInputDialog(sbMenu));
                dirPath = getDirPath(map, option);
                if (dirPath != null) hasDir = true;
            }catch (NoSuchElementException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no valida");
            }catch (NullPointerException ex) {
                int optionUser = JOptionPane.showConfirmDialog(null,"¿Desea salir de la aplicación?");
                if (optionUser == 0) System.exit(0);
            }
        }while (!hasDir);
        return dirPath;
    }
}
