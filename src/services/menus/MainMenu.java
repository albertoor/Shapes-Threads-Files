package services.menus;

import abstracts.Menu;
import enums.MenuEnum;
import exceptions.InterruptedProcessException;
import javax.swing.JOptionPane;
import java.util.stream.Stream;
import static constants.MenuMessages.SELECT_MENU_OPTION;
import static constants.MenuMessages.SELECT_OPTION;
import static constants.MenuMessages.BYE;

public class MainMenu extends Menu {
    @Override
    public void run() {
        MenuEnum menuEnum = null;
        StringBuilder sbMenu = fillMenuText();
        boolean isProcessCompleted = false;
        do {
            try {
                menuEnum = (MenuEnum) getOptionSelected(String.valueOf(sbMenu), menuEnum);
                if (menuEnum !=null){
                    switch (menuEnum) {
                        case NEW_FIGURE:
                            new ShapesMenu().run();
                            break;
                        case OPEN_FILE:
                            new FilesMenu().run();
                            break;
                        case EXIT:
                            JOptionPane.showMessageDialog(null, BYE);
                            System.exit(0);
                            break;
                    }
                }
                isProcessCompleted = true;
            }catch (InterruptedProcessException ex){
                if (ex.getMessage() != null)
                    JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (!isProcessCompleted);
    }

    @Override
    public StringBuilder fillMenuText() {
        StringBuilder textMenu = new StringBuilder(SELECT_MENU_OPTION);
        for(MenuEnum m : MenuEnum.values())
            textMenu.append(String.format(SELECT_OPTION, m.getOption(), m.getOptionName()));
        return textMenu;
    }


    @Override
    public MenuEnum getOptionName(int option) {
        return Stream.of(MenuEnum.values())
            .filter(o -> o.getOption() == option).findFirst().orElse(null);
    }
}
