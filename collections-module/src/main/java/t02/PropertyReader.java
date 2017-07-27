package t02;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Задание 2. Использование Map
 * Создать “универсальный” класс, позволяющий получить значение из любого properties-
 * файла. Физическое чтение файла должно происходить только один раз. Результаты чтения
 * храните в коллекции типа Map. Ответьте на вопрос: как ведет себя map-коллекция если в нее
 * добавить элемент с ключом, который уже присутствует?
 */
public class PropertyReader {

    private Properties props = new Properties();
    private Map<String, String> mapProps = new HashMap<>();

    public void read(String path) {
        try {
            props.load(new FileReader(path));
            props.keySet().forEach(prop ->
                    mapProps.put(prop.toString(), props.getProperty(prop.toString()))); // ¯\_(ツ)_/¯
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) throws NoSuchFieldException {
        String value = mapProps.get(key);
        if (value == null) throw new NoSuchFieldException();
        return value;
    }

    public Set<String> getKeys() {
        return mapProps.keySet();
    }

}
