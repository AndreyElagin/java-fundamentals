package t01;

import java.io.*;

import static utils.Keywords.CHARSET;
import static utils.Keywords.KEYWORDS;

/**
 * Задание 1. Работа с байтовыми потоками ввода-вывода
 * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые
 * слова языка Java это код содержит. Выведите эти слова и их количество в
 * другой файл. Используйте только байтовые потоки ввода-вывода.
 */
public class ByteStreams {

    public static int countWordsAndWrite(String fileNameFrom, String fileNameTo) {
        byte[] bytesReaded;
        int counter = 0;
        try (FileInputStream inFile = new FileInputStream(fileNameFrom)) {
            int bytesAvailable = inFile.available();
            bytesReaded = new byte[bytesAvailable];
            int count = inFile.read(bytesReaded, 0, bytesAvailable);
            try (FileOutputStream outFile = new FileOutputStream(fileNameTo)) {
                for (String str : new String(bytesReaded).split("\\s+")) {
                    if (KEYWORDS.contains(str)) {
                        counter++;
                        outFile.write(str.getBytes(CHARSET));
                        outFile.write("\n".getBytes(CHARSET));
                    }
                }
                outFile.write(("Number of occurrences: " + counter).getBytes(CHARSET));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

}