package javase01.t06;

/**
 * Created by daddyingrave on 16/06/2017.
 * Спроектировать и разработать классы Запись в блокноте и Блокнот
 * (записи блокнота хранятся в массиве). Реализовать методы: Добавить запись,
 * Удалить запись, Редактировать запись, Посмотреть все записи. Написать для
 * данного кода javadoc-документацию.
 */
public class TaskSix {
    public static void main(String[] args) {
        Notebook notebook = new Notebook(5);
        notebook.addEntry("Tomorrow i have to go to work :(");
        notebook.addEntry("Primary aim for near future", "Be effective in education");
        notebook.addEntry("3", "Hello neighbours!");
        notebook.addEntry("4", "Hello Martians!");
        notebook.addEntry("This world is so cruel, and I don't know why we are here :(");
        notebook.viewAllEntries();
        notebook.deleteEntryByTitle("4");
        notebook.viewAllEntries();
    }
}


