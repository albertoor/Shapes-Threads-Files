package services.files;

import services.files.create.CreateDirService;
import services.files.create.CreateFileService;
import services.files.write.WriteFileService;

public class GenerateFileService  {

    public void generate(String shapeData) {
        Creator creator = new Creator(shapeData);
        Thread t1 = new Thread(creator);
        t1.start();
    }

    private class Creator implements Runnable{
        private String shapeData;
        private String path;

        public Creator(String shapeData) {
            this.shapeData = shapeData;

        }

        @Override
        public void run() {
            String dirPath = CreateDirService.createDir();
            String filePath = CreateFileService.createFile(dirPath);
            WriteFileService.write(shapeData, filePath);
        }
    }
}
