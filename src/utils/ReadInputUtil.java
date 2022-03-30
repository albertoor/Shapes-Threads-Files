package utils;

import javax.swing.*;
import java.util.InputMismatchException;

public class ReadInputUtil {
    public static int readInteger(String prompt) {
        int input = 0;
        try {
            input = Integer.parseInt(JOptionPane.showInputDialog(prompt));
        }catch (InputMismatchException e){
            System.out.println("Cuidado! No has ingresado un numero");
        }
        return input;
    }

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
                JOptionPane.showMessageDialog(null, "Ingresa un numero valido");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            } catch (NullPointerException ex) {
                int choiceUs = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?");
                if (choiceUs == 0) {
                    System.exit(0);
                }
//                throw new ProcesoInterrupidoException(ProcesosEnum.INGRESO_VALORES);
            }
        } while (!valid);
        return input;
    }
}
