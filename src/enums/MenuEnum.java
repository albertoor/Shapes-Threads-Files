package enums;
import constants.MenuMessages;

public enum MenuEnum {
    NEW_FIGURE(MenuMessages.NEW_FIGURE, 1),
    OPEN_FILE(MenuMessages.OPEN_FILE, 2),
    EXIT(MenuMessages.EXIT, 3);

    private final String optionName;
    private final int option;

    MenuEnum(String optionName, int option) {
        this.optionName = optionName;
        this.option = option;
    }

    public String getOptionName() {
        return optionName;
    }

    public int getOption() {
        return option;
    }
}
