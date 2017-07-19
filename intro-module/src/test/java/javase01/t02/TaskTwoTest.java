package javase01.t02;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by daddyingrave on 14/06/2017.
 */
public class TaskTwoTest {

    @Test
    public void findSequenceElement() throws Exception {
        double answer = TaskTwo.findSequenceElement(0.001);
        assertThat(answer, is(0.00097656250000000000));
    }

}