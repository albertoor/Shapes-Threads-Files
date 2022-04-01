package services.menus;

import services.files.open.OpenFileAsync;
import services.files.read.ReadDirService;
import services.files.read.ReadFilesDirService;
import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import static constants.MenuMessages.SELECT_DIR;
import static constants.PathsMessages.LIST_DIRS;

public class FilesMenu extends Thread {

    public void run() {
        HashMap<Integer, String> dirs = ReadDirService.readDirs();
        String dirPath = getOptionSelected(dirs);
        HashMap<Integer, String> files = ReadFilesDirService.read(dirPath);
        List<String> filesPaths = getOptionFiles(files);
        long start = System.nanoTime();
        new OpenFileAsync().openFile(filesPaths);
        long end = System.nanoTime();
        System.out.println(end - start);
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

    public static List<String> getOptionFiles(HashMap<Integer, String> map) {
        List<String> files = new ArrayList<>();
        boolean hasFiles = false;
        StringBuilder sbMenu = fillMenuText(map);
        do {
            try {
                String options = JOptionPane.showInputDialog(sbMenu);
                files = filterFilesList(map, options);
                if (files.size() > 0) hasFiles = true;
            }catch (NullPointerException ex) {
                int optionUser = JOptionPane.showConfirmDialog(null,"¿Desea salir de la aplicación?");
                if (optionUser == 0) System.exit(0);
            }
        }while (!hasFiles);
        return files;
    }

    public static List<String> filterFilesList(HashMap<Integer, String> map, String fileOptions) {
        List<Integer> options = Arrays.asList(fileOptions.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        List<String> filesPaths = new ArrayList<>();
        for (Map.Entry<Integer, String> dir : map.entrySet())
            for (int o : options)
                if (dir.getKey() == o) filesPaths.add(dir.getValue());
        return filesPaths;
    }
}
