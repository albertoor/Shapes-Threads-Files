package services.files.open;

import threads.MultithreadingOpenFiles;
import java.util.List;

public class OpenFileAsync {
    public void openFile(List<String> filesPaths) {
        for (String filePath: filesPaths) {
            Thread t1 = new Thread(new MultithreadingOpenFiles(filePath));
            t1.start();
            System.out.println(t1.getId());
        }
    }
}
