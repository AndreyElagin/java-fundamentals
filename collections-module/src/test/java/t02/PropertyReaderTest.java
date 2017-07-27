package t02;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PropertyReaderTest {

    private PropertyReader pr;

    @Before
    public void init() {
        pr = new PropertyReader();
        pr.read("src/test/resources/t02.properties");
    }

    @Test
    public void getValue() throws Exception {
        assertThat(pr.getValue("prop1"), is("hello"));
        assertThat(pr.getValue("prop2"), is("good day"));
    }

}