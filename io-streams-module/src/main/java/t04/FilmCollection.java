package t04;

import java.io.Serializable;
import java.util.*;

public class FilmCollection implements Serializable {

    private Map<String, Film> filmStorage = new HashMap<>();
    private Map<String, Actor> actorStorage = new HashMap<>();

    public void addFilm(String title) {
        filmStorage.put(title, new Film(title));
    }

    public void addActor(String filmTitle, String actorName) {
        Film film = filmStorage.get(filmTitle);
        if (film != null) {
            Actor actor = actorStorage.get(actorName);
            if (actor == null) {
                actor = new Actor(actorName);
            }
            actor.addFilm(film);
            actorStorage.put(actorName, actor);
            film.addActor(actor);
        }
    }

    public Film getFilm(String title) {
        return filmStorage.get(title);
    }

    public Actor getActor(String actorName) {
        return actorStorage.get(actorName);
    }

}

class Actor implements Serializable {

    private String name;
    private List<Film> films = new ArrayList<>();;

    public Actor(String name) {
        this.name = name;
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public String getName() {
        return name;
    }

    public List<Film> getFilms() {
        return films;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;

        Actor actor = (Actor) o;

        return name.equals(actor.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Actor{" + "name='" + name + '\'' + '}';
    }

}

class Film implements Serializable {

    private String title;
    private List<Actor> actors = new ArrayList<>();;

    public Film() {}

    public Film(String title) {
        this.title = title;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public String getTitle() {
        return title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;

        Film film = (Film) o;

        return title.equals(film.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return "Film{" + "title='" + title + '\'' + '}';
    }

}