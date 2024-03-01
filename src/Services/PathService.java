package Services;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathService {

    private Path fileToRead;
    private Path fileToWrite;

    public PathService(Path fileToRead, Path fileToWrite) {
        this.fileToRead = fileToRead;
        this.fileToWrite = fileToWrite;
    }

    public boolean isReadable() {
        if(!Files.exists(fileToRead)){
            return false;
        }
        return true;
    }

    public Path getFileToRead() {
        return fileToRead;
    }

    public void setFileToRead(Path fileToRead) {
        this.fileToRead = fileToRead;
    }

    public Path getFileToWrite() {
        return fileToWrite;
    }

    public void setFileToWrite(Path fileToWrite) {
        this.fileToWrite = fileToWrite;
    }
}
