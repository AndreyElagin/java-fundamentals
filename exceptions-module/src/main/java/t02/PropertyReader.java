package t02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Задание 2. Обработка исключительных ситуаций
 * Создать “универсальный” класс, позволяющий получить значение из любого
 * properties-файла. Физическое чтение файла должно происходить только один
 * раз. Обработайте следующие исключительные ситуации: нет файла *.properties,
 * нет ключа в properties-файле.
 */
public class PropertyReader {

    private Properties props = new Properties();

    public void read(String path) {
        try {
            props.load(new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) throws NoSuchFieldException {
        String value = props.getProperty(key);
        if (value == null) throw new NoSuchFieldException();
        return value;
    }

    public Set<Object> getKeys() {
        return props.keySet();
    }

}
