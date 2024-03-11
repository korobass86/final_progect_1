package services;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathService {
    private Path fileToRead;
    private Path fileToWrite;
    private int key;

    public PathService() {

    }

    public boolean isReadable() {
        return Files.exists(fileToRead);
    }

    public boolean isWritable () {
        return !fileToWrite.startsWith("C:\\Windows");
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

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
