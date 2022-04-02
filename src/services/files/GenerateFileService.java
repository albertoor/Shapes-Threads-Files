package services.files;

import services.files.create.CreateDirService;
import threads.CreateWriteFileService;

public class GenerateFileService  {
    public static void generate(String shapeData) throws InterruptedException {
        String path = CreateDirService.createDir();
        CreateWriteFileService createWriteFileService = new CreateWriteFileService(path, shapeData);
        Thread t1 = new Thread(createWriteFileService);
        t1.start();
        t1.join();
    }
}
