package abstracts;

import exceptions.InterruptedProcessException;

public abstract class Menu {
    public abstract void run() throws InterruptedProcessException;
    public abstract StringBuilder fillMenuText();
}
