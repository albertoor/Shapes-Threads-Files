import exceptions.InterruptedProcessException;
import services.menus.MainMenu;

public class Main {
    public static void main(String[] args) throws InterruptedProcessException {
        new MainMenu().run();
    }
}
