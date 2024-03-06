package model;
import services.FileService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static services.Consts.ALPHABET;

public class CryptoAnalizer {
    FileService filesToAnalysis;

    public CryptoAnalizer(FileService filesToAnalysis) {
        this.filesToAnalysis = filesToAnalysis;
    }

    public void encryptFile () {
        List<String> dataToWrite = new ArrayList<>();
        int newIndex = 0;
        int charToSearchIndex = 0;
        for (String string : filesToAnalysis.fileRead()) {
            StringBuilder currentString = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                charToSearchIndex = new String(ALPHABET).indexOf(string.toLowerCase().charAt(i));
                if (charToSearchIndex < 0) {
                    continue;
                }

                newIndex = charToSearchIndex + filesToAnalysis.getFilesPath().getKey();
                if (newIndex > ALPHABET.length - 1) {
                    newIndex -= ALPHABET.length;
                }
                currentString.append(ALPHABET[newIndex]);
            }
            dataToWrite.add(currentString.toString());
        }
        filesToAnalysis.fileWrite(dataToWrite);
        System.out.println("Файл успешно зашифрован!");
    }

    public void decryptFile () {
        filesToAnalysis.fileWrite(decriptorByKey(filesToAnalysis.getFilesPath().getKey()));
        System.out.println("Файл успешно расшифрован!");
    }

    public void decryptBruteForce () {
        int maxFrequency = 0;
        int key = 0;
        for (int i = 1; i < ALPHABET.length - 1; i++) {
            int frequency = textAnalysis(decriptorByKey(i)).get("*_*");
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                key = i;
            }
        }
        filesToAnalysis.fileWrite(decriptorByKey(key));
    }

    private List<String> decriptorByKey(int key) {
        List<String> dataToWrite = new ArrayList<>();
        int newIndex;
        int charToSearchIndex;
        for (String string : filesToAnalysis.fileRead()) {
            StringBuilder currentString = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                charToSearchIndex = new String(ALPHABET).indexOf(string.toLowerCase().charAt(i));
                if (charToSearchIndex < 0) {
                    continue;
                }

                newIndex = charToSearchIndex - key;
                if (newIndex < 0) {
                    newIndex += ALPHABET.length;
                }
                currentString.append(ALPHABET[newIndex]);
            }
            dataToWrite.add(currentString.toString());
        }
        return dataToWrite;
    }

    private HashMap<String, Integer> textAnalysis (List <String> dataToAnalysis) {
        HashMap <String, Integer> outputFrequencySymbols = new HashMap<>();
        outputFrequencySymbols.put("*_*", 0);
        int frequency = 0;
        for (String toAnalysis : dataToAnalysis) {

            for (int i = 1; i < toAnalysis.length() - 1; i++) {
                if (toAnalysis.toLowerCase().charAt(i) == ' ' &&
                        Character.isLetter(toAnalysis.toLowerCase().charAt(i - 1)) &&
                        Character.isLetter(toAnalysis.toLowerCase().charAt(i + 1))
                ) {
                    frequency++;
                }
            }

        }
        outputFrequencySymbols.put("*_*", frequency);
        return outputFrequencySymbols;
    }


    public FileService getFilesToAnalysis() {
        return filesToAnalysis;
    }

    public void setFilesToAnalysis(FileService filesToAnalysis) {
        this.filesToAnalysis = filesToAnalysis;
    }
}
