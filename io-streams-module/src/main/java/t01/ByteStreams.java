package t01;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Задание 1. Работа с байтовыми потоками ввода-вывода
 * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые
 * слова языка Java это код содержит. Выведите эти слова и их количество в
 * другой файл. Используйте только байтовые потоки ввода-вывода.
 */
public class ByteStreams {
    
    private static Set<String> keywords;
    private static String charset = "UTF-8";

    static {
        String words = "abstract, continue, for, new, switch, assert, default, goto, "
                + "package, synchronized, boolean, do, if, private, this, break, "
                + "double, implements, protected, throw, byte, else, import, public, "
                + "throws, case, enum, instanceof, return, transient, catch, extends, "
                + "int, short, try, char, final, interface, static, void, class, "
                + "finally, long, strictfp, volatile, const, float, native, super, while ";
        keywords = new HashSet<>(Arrays.asList(words.split(", ")));
    }

    public static int countWords(String fileNameFrom, String fileNameTo) {
        byte[] bytesReaded;
        int counter = 0;
        try (FileInputStream inFile = new FileInputStream(fileNameFrom)) {
            int bytesAvailable = inFile.available();
            bytesReaded = new byte[bytesAvailable];
            int count = inFile.read(bytesReaded, 0, bytesAvailable);

            try (FileOutputStream outFile = new FileOutputStream(fileNameTo)) {
                for (String str : new String(bytesReaded).split(" ")) {
                    if (keywords.contains(str)) {
                        counter++;
                        outFile.write(str.getBytes(charset));
                        outFile.write("\n".getBytes(charset));
                    }
                }
                outFile.write(("Number of occurrences: " + counter).getBytes(charset));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

}