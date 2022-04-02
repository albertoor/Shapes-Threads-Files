package utils;

import javax.swing.*;

import static constants.MenuMessages.QUESTION_TO_LEAVE;

public class Exit {
    public static void exit() {
        int optionUser = JOptionPane.showConfirmDialog(null, QUESTION_TO_LEAVE);
        if (optionUser == 0) System.exit(0);
    }
}
