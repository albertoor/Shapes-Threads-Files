package abstracts;

import utils.Exit;

import javax.swing.*;
import java.util.NoSuchElementException;

import static constants.MenuMessages.*;

public abstract class Menu <E extends Enum>{
    public abstract void run() throws InterruptedException;
    public abstract StringBuilder fillMenuText();
    public abstract E getOptionName (int option);
    public E getOptionSelected(String prompt,  Object e)  {
        boolean valid = false;
        do {
            try {
                String menuOption = JOptionPane.showInputDialog(prompt);
                if (menuOption == null) throw new NullPointerException();
                int option = Integer.parseInt(menuOption);
                e = getOptionName(option);
                if (e != null) return (E) e;
            } catch (NoSuchElementException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, NOT_VALID);
            } catch (NullPointerException ex) {
                Exit.exit();
            }
        }while (!valid);
        return (E) e;
    }
}
