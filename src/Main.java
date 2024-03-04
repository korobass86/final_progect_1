import Services.CryptoAnalizer;
import Services.FileService;
import Services.PathService;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hi, user! I'm caesar descryptor. Choose you task:\n" +
                "1 - encrypt file with key\n" +
                "2 - decrypt file with key\n" +
                "3 - brute force decrypt file\n" +
                "4 - statistic analize descriptor");

        Scanner scanner = new Scanner(System.in);
        PathService pathService = new PathService(scanner);
        FileService fileService = new FileService(pathService);
        CryptoAnalizer cryptoAnalizer = new CryptoAnalizer(fileService);
        cryptoAnalizer.encryptFile(5);

    }
}
