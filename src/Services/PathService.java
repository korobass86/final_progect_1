package Services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class PathService {
    Scanner scanner;
    private Path fileToRead;
    private Path fileToWrite;

    public PathService(Scanner scanner) {
        this.scanner = scanner;
        this.fileToRead = Path.of(scanner.nextLine());
        this.fileToWrite = Path.of(scanner.nextLine());
    }

    public boolean isReadable() {
        if(!Files.exists(fileToRead)){
            return false;
        }
        return true;
    }

    public boolean isWritable () {
        if (fileToWrite.startsWith("C:\\Windows")){
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
