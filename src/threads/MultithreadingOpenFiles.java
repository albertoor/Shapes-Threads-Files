package threads;

import java.io.IOException;
import java.util.List;

public class MultithreadingOpenFiles implements Runnable {
    private String filePath;

    public MultithreadingOpenFiles(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public void run() {
        openFile(filePath);
    }

    public void openFile(String filePath) {
        try {
            Runtime.getRuntime().exec("open -a TextEdit " + filePath);
        }catch (Exception e){
            System.out.println("No");
        }
    }
}
