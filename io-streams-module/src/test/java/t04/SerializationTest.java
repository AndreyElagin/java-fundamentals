package t04;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SerializationTest {

    @Test
    public void serializationTest() throws Exception {
        Serialization serialization = new Serialization(new FilmCollection());

        serialization.addFilm("The Shawshank Redemption");
        serialization.addFilm("The Godfather");
        serialization.addFilm("Apocalypse Now");

        serialization.addActor("Marlon Brando", "The Godfather");
        serialization.addActor("Marlon Brando", "Apocalypse Now");
        serialization.addActor("Tim Robbins", "The Shawshank Redemption");

        serialization.getFilmsForActor("Marlon Brando").forEach(System.out::println);
        serialization.getFilmsForActor("Tim Robbins").forEach(System.out::println);

        serialization.serializeIt("src/main/resources/serialized", serialization);
        Serialization serializationNew = serialization.deserializeIt("src/main/resources/serialized");
        serializationNew
                .getFilmsForActor("Marlon Brando")
                .forEach(System.out::println);

        assertThat(serializationNew.getFilmsForActor("Tim Robbins"),
                is(serialization.getFilmsForActor("Tim Robbins")));
    }

}