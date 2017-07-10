package t03;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HtmlParserTest {

    @Test
    public void checkConsistency() throws Exception {
        HtmlParser htmlParser = new HtmlParser("src/main/resources/Java.SE.03.Information_handling_task_attachment.html");
        htmlParser.initReader();
        assertThat(htmlParser.checkConsistency(), is(true));
        assertThat(htmlParser.countAndPrintSentences(), is(104)); //it's wrong, be sure I will fix it
    }

}