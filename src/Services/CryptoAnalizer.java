package Services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Services.Consts.ALPHABET;

public class CryptoAnalizer {
    FileService filesToAnalysis;

    public CryptoAnalizer(FileService filesToAnalysis) {
        this.filesToAnalysis = filesToAnalysis;
    }

    public void encryptFile (int key) {
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

                newIndex = charToSearchIndex + key;
                if (newIndex > ALPHABET.length - 1) {
                    newIndex -= ALPHABET.length;
                }
                currentString.append(ALPHABET[newIndex]);
            }
            dataToWrite.add(currentString.toString());
        }
        filesToAnalysis.fileWrite(dataToWrite);
    }



    public FileService getFilesToAnalysis() {
        return filesToAnalysis;
    }

    public void setFilesToAnalysis(FileService filesToAnalysis) {
        this.filesToAnalysis = filesToAnalysis;
    }
}
