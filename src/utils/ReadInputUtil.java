package utils;

import javax.swing.*;
import static constants.MenuMessages.OPTION_NOT_VALID;
import static constants.MenuMessages.QUESTION_TO_LEAVE;

public class ReadInputUtil {
    // Read Double value
    public static double readDouble(String str1, String str2) {
        boolean valid = false;
        double input = 0.0;
        String choice;

        do {
            try {
                choice = JOptionPane.showInputDialog(String.format(str1, str2));
                input = Double.parseDouble(choice);
                if (input == 0.0)
                    JOptionPane.showMessageDialog(null,"El valor no puede ser 0");
                else
                    return input;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, OPTION_NOT_VALID);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            } catch (NullPointerException ex) {
                int choiceUs = JOptionPane.showConfirmDialog(null, QUESTION_TO_LEAVE);
                if (choiceUs == 0) {
                    System.exit(0);
                }
//                throw new ProcesoInterrupidoException(ProcesosEnum.INGRESO_VALORES);
            }
        } while (!valid);
        return input;
    }
}
