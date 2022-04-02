package threads;

import services.files.create.CreateFileService;
import services.files.write.WriteFileService;

public class CreateWriteFileService implements Runnable{
    private String dirPath;
    private String shapeDate;

    public CreateWriteFileService(String dirPath, String shapeDate) {
        this.dirPath = dirPath;
        this.shapeDate = shapeDate;
    }

    @Override
    public void run() {
        String filePath = CreateFileService.createFile(dirPath);
        if (!filePath.isEmpty() && !shapeDate.isEmpty()) {
            WriteFileService.write(shapeDate, filePath);
        }
    }
}
