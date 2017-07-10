package t01;

import org.junit.Test;
import t02.SymbolStreams;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ByteStreamsTest {

    @Test
    public void countWords() throws Exception {
        assertThat(ByteStreams.countWordsAndWrite("src/main/resources/javaclass",
                "src/main/resources/javaOutputclass"), is(19));
        assertThat(SymbolStreams.countWordsAndWrite("src/main/resources/javaclass",
                "src/main/resources/javaOutputclass"), is(19));
    }

}