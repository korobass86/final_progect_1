package services;

public class Consts {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '(', ')', '«', '»', '"', '\'', ':', '-', '!', '?', ' '};

    public static final String NOT_ACCESS_CATALOG = "Недостаточно прав для записи в данную папку";
    public static final String INPUT_FILE_PATH = "Введите путь к файлу, который нужно ";
    public static final String ENCRYPT = "зашифровать:";
    public static final String DECRYPT = "расшифровать:";
    public static final String OUTPUT_FILE_PATH = "Введите путь к файлу, в который нужно сохранить результат:";
    public static final String KEY_CRYPTO = "Введите ключ шифрования:";


    public static final String EXIT = "exit";
    public static final String FILE_ENCRYPTED = "Файл успешно зашифрован!";
    public static final String FILE_DECRYPTED = "Файл успешно расшифрован!";
    public static final String PATTERN_ENCRYPT = "*_*";
}
