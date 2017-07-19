package t01;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LittleFinderTest {

    private LittleFinder lf;
    private String testPath = "src/test/resources";

    @Before
    public void init() {
        lf = new LittleFinder();
    }

    @Test
    public void write() throws Exception {
        String path = testPath + "/example";
        lf.write(path, "Привет", StandardOpenOption.TRUNCATE_EXISTING);
        lf.write(path, "Пока", StandardOpenOption.APPEND);
        FileChannel fc = new FileInputStream(path).getChannel();
        ByteBuffer bf = ByteBuffer.allocate((int) fc.size());
        fc.read(bf);
        bf.flip();
        assertThat(new String(bf.array()), is("Привет\nПока\n"));
    }

    @Test
    public void list() throws Exception {
        String testFile = testPath + "/test";
        assertThat(lf.list(testFile), is("hello"));
        assertThat(lf.list(testPath), is("example\nnotexisthere\nt02.properties\ntest\n"));
    }

    @Test
    public void createFile() throws Exception {
        lf.createFile(testPath + "/notexisthere");
    }

    @Test
    public void deleteFile() throws Exception {
        String path = testPath + "/fordeletion";
        lf.createFile(path);
        assertTrue(Files.exists(Paths.get(path)));
        lf.deleteFile(path);
        assertFalse(Files.exists(Paths.get(path)));
    }

}