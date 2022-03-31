package abstracts;

import exceptions.InterruptedProcessException;

public abstract class Menu {
    public abstract void run() throws InterruptedProcessException, InterruptedException;
    public abstract StringBuilder fillMenuText();
}
