package task1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Задание 1. Строковые классы
 * Необходимо создать класс CrazyLogger, ведущий журнал лога, используя как
 * накопитель объект типа StringBuilder. Логгер должен содержать методы поиска
 * определенной информации в таком логе [с возможностью вывода ее в поток ввода вывода].
 * Информацию логгер хранит в форматированном виде: dd-mm-YYYY : hh-mm – message;.
 */
public class CrazyLogger {

    private StringBuilder storage = new StringBuilder();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : HH-mm");
    private static final int PATTERN_LENGTH = 24;

    /**
     * For future search implementation, I decided to append before and after
     * message special symbols which can help me to understand where message starts and ends
     * @param message
     */
    public void log(String message) {
        storage.append("\\^^");
        storage.append(LocalDateTime.now().format(formatter));
        storage.append(" - ");
        storage.append(message);
        storage.append("\\$$");
        String str = "" + (PATTERN_LENGTH + message.length());
        storage.append(str.length() + (PATTERN_LENGTH + message.length()));
    }

    public void search(String searchText) {
        StringBuilder storage = new StringBuilder(this.storage);
        int firstIndex;
        int lastIndex = 0;
        int index = storage.indexOf(searchText);
        if (index > 0) {
            firstIndex = storage.indexOf("\\$$", index) + 2;
        } else {
            System.out.println("There is no occurrences");
            return;
        }
        char i = storage.charAt(firstIndex);
        StringBuilder sb = new StringBuilder();

        while (i != '\\' && firstIndex + 1 < storage.length()) {
            i = storage.charAt(++firstIndex);
            sb.append(i);
        }

        if (firstIndex + 1 != storage.length()) {
            sb.deleteCharAt(sb.length() - 1);
        } else {
            lastIndex--;
        }
        lastIndex += Integer.valueOf(sb.toString());

        int offset = 0;
        if ((firstIndex - lastIndex) == 3) offset = 1;

        System.out.println((storage.subSequence(firstIndex - lastIndex, firstIndex - 5 - offset)).toString());
    }

}