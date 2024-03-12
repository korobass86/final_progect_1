import model.CryptoAnalizer;
import services.ConsoleService;
import services.FileService;
import services.PathService;

import java.util.Scanner;

import static services.Consts.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PathService pathService = new PathService();
        FileService fileService = new FileService(pathService);
        ConsoleService consoleService = new ConsoleService(scanner, pathService);
        //String choose = consoleService.userChoose();

        CryptoAnalizer cryptoAnalizer = new CryptoAnalizer(fileService);
        String choose = null;

        while (!EXIT.equals(choose)) {
            choose = consoleService.userChoose();
            switch (choose) {
                case "1" -> {
                    consoleService.inputUserData(choose, ENCRYPT);
                    cryptoAnalizer.encryptFile();
                }
                case "2" -> {
                    consoleService.inputUserData(choose, DECRYPT);
                    cryptoAnalizer.decryptFile();
                }
                case "3" -> {
                    consoleService.inputUserData(choose, DECRYPT);
                    cryptoAnalizer.decryptBruteForce();
                }
            }
        }

    }
}
