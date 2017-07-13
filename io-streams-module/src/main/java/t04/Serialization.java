package t04;

import java.io.*;
import java.util.List;

/**
 * Задание 4. Сериализация
 * Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в
 * главных ролях (один актер мог сниматься и в нескольких фильмах). Необходимо
 * написать приложение, позволяющее при запуске восстанавливать коллекцию фильмов,
 * позволять ее модифицировать, а по завершении работы приложения – сохранять
 * (в файл). Для восстановления/сохранения коллекции использовать
 * сериализацию/десериализацию.
 */
public class Serialization implements Serializable {

    private FilmCollection filmCollection;

    public Serialization(FilmCollection filmCollection) {
        this.filmCollection = filmCollection;
    }

    public Serialization() {

    }

    public void addFilm(String title) {
        filmCollection.addFilm(title);
    }

    public void addActor(String actorName, String filmTitle) {
        filmCollection.addActor(filmTitle, actorName);
    }

    public List<Film> getFilmsForActor(String actorName) {
        return filmCollection.getActor(actorName).getFilms();
    }

    public void serializeIt(String file, Object object) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file)
        );
        out.writeObject(object);
        out.close();
    }

    public Serialization deserializeIt(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(file));
        return (Serialization) in.readObject();
    }

}