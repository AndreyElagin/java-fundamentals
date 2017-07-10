package t02;

import java.io.*;

import static utils.Keywords.KEYWORDS;

/**
 * Задание 2. Работа с символьными потоками ввода-вывода
 * Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые
 * слова языка Java это код содержит. Выведите эти слова и их количество в
 * другой файл. Используйте только символьные потоки ввода-вывода.
 */
public class SymbolStreams {

    public static int countWordsAndWrite(String fileNameFrom, String fileNameTo) {
        int counter = 0;
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileNameFrom))) {
            StringBuilder sb = new StringBuilder();
            int text;
            while ((text = reader.read()) != -1) {
                sb.append((char) text);
            }
            try (BufferedWriter outFile = new BufferedWriter(new FileWriter(fileNameTo))) {
                for (String str : sb.toString().split("\\s+")) {
                    if (KEYWORDS.contains(str)) {
                        outFile.write(str + "\n");
                        counter++;
                    }
                }
                outFile.write("Number of occurrences: " + counter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return counter;
    }

}