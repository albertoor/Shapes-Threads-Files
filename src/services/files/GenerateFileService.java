package services.files;

import services.files.create.CreateDirService;
import services.files.create.CreateFileService;
import services.files.write.WriteFileService;

public class GenerateFileService  {

    public void generate(String shapeData) throws InterruptedException {
        // Hacerlo async (un solo hilo)
        String path = CreateDirService.createDir();
        CreateFileService createFileService = new CreateFileService(path);
        Thread t1 = new Thread(createFileService);
        t1.start();
        t1.join();
        WriteFileService.write(shapeData, createFileService.getFilePath());
    }
}
