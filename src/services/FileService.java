package services;

import exceptions.FileAccessException;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static services.Consts.NOT_ACCESS_CATALOG;

public class FileService {
    private PathService filesPath;

    public PathService getFilesPath() {
        return filesPath;
    }

    public FileService(PathService filesPath) {
        this.filesPath = filesPath;
    }

    public List<String> fileRead () {

        try {
            return Files.readAllLines(filesPath.getFileToRead());
        } catch (IOException e) {
            throw new FileAccessException(e.getMessage(), e.getCause());
        }
    }

    public void fileWrite (List<String> dataToWrite){
        try{
            if (filesPath.isWritable()){
                Files.write(filesPath.getFileToWrite(), dataToWrite);
            } else {
                System.out.println(NOT_ACCESS_CATALOG);
            }
        } catch (IOException e){
            throw new FileAccessException(e.getMessage(), e.getCause());
        }
    }

}
