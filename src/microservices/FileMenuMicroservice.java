package microservices;

import utils.Exit;
import utils.Validations;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import static constants.MenuMessages.*;
import static constants.PathsMessages.LIST_DIRS;

public class FileMenuMicroservice {
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
                String option = JOptionPane.showInputDialog(sbMenu);
                if (option == null) throw new NullPointerException();
                dirPath = getDirPath(map, Integer.parseInt(option));
                if (dirPath != null) hasDir = true;
            } catch (NoSuchElementException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, NOT_VALID);
            } catch (NullPointerException ex) {
                Exit.exit();
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
                if (options == null) throw new NullPointerException();
                if (Validations.validateFileFormat(options)){
                    files = filterFilesList(map, options);
                    if (files.size() > 0) hasFiles = true;
                }else{
                    JOptionPane.showMessageDialog(null, NOT_VALID_FORMAT);
                }
            }catch (NullPointerException ex) {
                Exit.exit();
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
