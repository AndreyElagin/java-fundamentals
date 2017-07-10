package t03;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задание 3. Регулярные выражения
 * Необходимо определить в тексте статьи* (html-файл), ссылается ли автор на рисунки
 * последовательно или нет, а также выделить все предложения, в которых встречаются
 * ссылки на рисунки. Для разбора текста использовать регулярные выражения.
 * *Статья приведена в приложении к данному файлу заданий.
 */
public class HtmlParser {

    private BufferedReader reader;
    private String fileName;
    private StringBuilder sb = new StringBuilder();
    private String body;

    public HtmlParser(String fileName) {
        this.fileName = fileName;
    }

    public void initReader() {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "windows-1251"));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            String text;
            while ((text = reader.readLine()) != null) {
                sb.append(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        body = sb.toString();
    }

    public boolean checkConsistency() throws IOException {
        Matcher matcher = Pattern.compile("(pic(\\d+))")
                .matcher(body);

        Boolean isConsistent = true;
        int i = 1;
        while (matcher.find() && isConsistent) {
            if (Integer.valueOf(matcher.group(2)) != i) isConsistent = false;
            i++;
        }
        return isConsistent;
    }

    public int countAndPrintSentences() {
        Matcher matcher = Pattern.compile("(\\(([Рр])ис\\. +\\d+\\))")
                .matcher(body);
        System.out.println(matcher.find());
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        return 0;
    }

}
