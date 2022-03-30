package services.menus;

import abstracts.Menu;
import constants.MenuMessages;
import enums.MenuEnum;
import enums.ProcessEnum;
import exceptions.InterruptedProcessException;
import javax.swing.JOptionPane;
import java.util.NoSuchElementException;
import java.util.stream.Stream;


public class MainMenu extends Menu {
    @Override
    public void run() {
        MenuEnum menuEnum;
        StringBuilder sbMenu = fillMenuText();
        boolean isProcessCompleted = false;
        do {
            try {
                menuEnum = getSelectedOption(String.valueOf(sbMenu));
                if (menuEnum !=null){
                    switch (menuEnum) {
                        case NEW_FIGURE:
                            new ShapesMenu().run();
                            break;
                        case OPEN_FILE:
                            System.out.println("Open file");
                            break;
                        case EXIT:
                            System.out.println("Adios");
                            break;
                    }
                }
                isProcessCompleted = true;
            }catch (InterruptedProcessException ex){
                if (ex.getMessage() != null)
                    JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }while (!isProcessCompleted);
    }

    @Override
    public StringBuilder fillMenuText() {
        StringBuilder textMenu = new StringBuilder(MenuMessages.SELECT_MENU_OPTION);
        for(MenuEnum m : MenuEnum.values()) {
            textMenu.append(String.format(MenuMessages.SELECT_OPTION, m.getOption(), m.getOptionName()));
        }
        return textMenu;
    }

    public static MenuEnum getSelectedOption(String prompt) throws InterruptedProcessException {
        boolean valid = false;
        MenuEnum menuEnum;
        do {
            try {
                String menuOption = JOptionPane.showInputDialog(prompt);
                if (menuOption == null) throw new NullPointerException();

                int option = Integer.parseInt(menuOption);
                menuEnum = getOptionName(option);
                if(menuEnum != null) return menuEnum;
            }catch (NoSuchElementException | NumberFormatException ex){
                throw new InterruptedProcessException("Option invalid", ProcessEnum.MAIN_MENU);
            }catch (NullPointerException ex) {
                int optionUser = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?");
                if (optionUser == 0) System.exit(0);
                throw new InterruptedProcessException(ProcessEnum.MAIN_MENU);
            }
        }while (!valid);
        return menuEnum;
    }

    public static MenuEnum getOptionName(int option) {
        return Stream.of(MenuEnum.values())
            .filter(o -> o.getOption() == option).findFirst().orElse(null);
    }

//    public static MenuEnum getSelectedOption(int option) {
//        return Stream.of(MenuEnum.values())
//            .filter(o -> o.getOption() == option).findFirst().orElse(null);
//    }

//    @Override
//    public void run() throws InterruptedProcessException {
//        MenuEnum menuEnum;
//        StringBuilder sbMenu = fillMenuText();
//        do {
////            int option = ReadInputUtil.readInteger(String.valueOf(sbMenu));
//            menuEnum = getSelectedOption(String.valueOf(sbMenu));
//            switch (menuEnum) {
//                case NEW_FIGURE -> new ShapesMenu().run();
//                case OPEN_FILE -> System.out.println("open file");
//                case EXIT -> System.out.println("EXIt");
//                default -> System.out.println("Not valid");
//            }
//        } while (!Objects.equals(menuEnum, MenuEnum.EXIT));
//    }
}
