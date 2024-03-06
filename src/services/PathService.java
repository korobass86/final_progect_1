package services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static services.Consts.ALPHABET;

public class PathService {
    private Path fileToRead;
    private Path fileToWrite;
    private int key;

    public PathService() {

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

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
