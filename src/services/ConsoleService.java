package services;

import java.nio.file.Path;
import java.util.Scanner;
import services.PathService.*;

import static services.Consts.*;

public class ConsoleService {
    Scanner scanner;
    PathService pathService;

    public ConsoleService(Scanner scanner, PathService pathService) {
        this.scanner = scanner;
        this.pathService = pathService;
    }

    public String userChoose() {
        System.out.println("Hi, user! I'm caesar descryptor. Enter the number for you task:\n" +
                "1 - encrypt file with key\n" +
                "2 - decrypt file with key\n" +
                "3 - brute force decrypt file\n" +
                "4 - statistic analize descriptor\n" +
                "\"exit\" for finish work program");
        return scanner.nextLine();
    }

    public void inputUserData (String userChooseMethod, String encryptOrCrypt) {
        System.out.println(INPUT_FILE_PATH + encryptOrCrypt);
        pathService.setFileToRead(Path.of(scanner.nextLine()));
        System.out.println(OUTPUT_FILE_PATH);
        pathService.setFileToWrite(Path.of(scanner.nextLine()));
        if (userChooseMethod.equals("1") || userChooseMethod.equals("2")) {
            System.out.println(KEY_CRYPTO);
            int key = scanner.nextInt();
            pathService.setKey(key > ALPHABET.length ? key % ALPHABET.length : key);
            scanner.nextLine();
        }

    }
}
