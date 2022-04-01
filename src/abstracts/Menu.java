package abstracts;

import enums.ProcessEnum;
import exceptions.InterruptedProcessException;
import javax.swing.*;
import java.util.NoSuchElementException;
import static constants.MenuMessages.QUESTION_TO_LEAVE;
import static constants.MenuMessages.OPTION_NOT_VALID;

public abstract class Menu <E extends Enum>{
    public abstract void run() throws InterruptedProcessException, InterruptedException;
    public abstract StringBuilder fillMenuText();
    public abstract E getOptionName (int option);
    public E getOptionSelected(String prompt,  Object e) throws InterruptedProcessException {
        boolean valid = false;
        do {
            try {
                String menuOption = JOptionPane.showInputDialog(prompt);
                if (menuOption == null) throw new NullPointerException();
                int option = Integer.parseInt(menuOption);
                e = getOptionName(option);
                if (e != null) return (E) e;
            } catch (NoSuchElementException | NumberFormatException ex) {
                throw new InterruptedProcessException(OPTION_NOT_VALID, ProcessEnum.MAIN_MENU);
            } catch (NullPointerException ex) {
                int optionUser = JOptionPane.showConfirmDialog(null, QUESTION_TO_LEAVE);
                if (optionUser == 0) System.exit(0);
                throw new InterruptedProcessException(ProcessEnum.MAIN_MENU);
            }
        }while (!valid);
        return (E) e;
    }
}
