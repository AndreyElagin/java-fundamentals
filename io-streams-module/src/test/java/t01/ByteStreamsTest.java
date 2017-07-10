package t01;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ByteStreamsTest {

    @Test
    public void countWords() throws Exception {
        assertThat(ByteStreams.countWords("src/main/resources/javaclass",
                "src/main/resources/javaOutputclass"), is(197));
    }

}