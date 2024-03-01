package Services;

import Exceptions.FileAccessException;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileService {
    private PathService filesPath;

    public FileService(PathService filesPath) {
        this.filesPath = filesPath;
    }

    public List<String> fileRead (PathService filesPath) {

        try {
            List<String> readBuffer = Files.readAllLines(filesPath.getFileToRead());
            return readBuffer;
        } catch (IOException e) {
            throw new FileAccessException(e.getMessage(), e.getCause());
        }
    }

    public void fileWrite (PathService filesPath, List<String> dataToWrite){
        try{
            if (filesPath.isReadable()){
                Files.write(filesPath.getFileToWrite(), dataToWrite);
            }
        } catch (IOException e){

        }
    }
}
