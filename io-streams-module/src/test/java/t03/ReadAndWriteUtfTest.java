package t03;

import org.junit.Test;

public class ReadAndWriteUtfTest {

    @Test
    public void countWordsAndWrite() throws Exception {
        ReadAndWriteUtf.write("src/main/resources/zloyrusskiyfile",
                "src/main/resources/zloyrusskiyfileUTF-16");
    }

}