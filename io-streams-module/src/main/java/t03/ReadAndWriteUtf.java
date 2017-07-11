package t03;

import java.io.*;

import static utils.Keywords.CHARSET;
import static utils.Keywords.CHARSET_16;

/**
 * Задание 3. Работа с байтовыми и символьными потоками ввода-вывода
 * Дан файл, содержащий буквы текст на кириллице. Кодировка файла utf-8.
 * Прочитайте информацию из файла и перепишите ее в файл с кодировкой utf-16.
 */
public class ReadAndWriteUtf {

    public static void write(String fileNameFrom, String fileNameTo)
            throws FileNotFoundException, UnsupportedEncodingException {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileNameFrom), CHARSET))) {
            StringBuilder sb = new StringBuilder();
            int text;
            while ((text = reader.read()) != -1) {
                sb.append((char) text);
            }
            try (BufferedWriter outFile = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(fileNameTo), CHARSET_16))) {
                outFile.write(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}