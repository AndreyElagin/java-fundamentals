package javase01.t04;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by daddyingrave on 15/06/2017.
 */
public class TaskFourTest {

    @Test
    public void getMax() throws Exception {
        double[] testArray = {10, 2, 3, 4, 5, 6, 7, 8};
        TaskFour taskFour = new TaskFour();
        assertThat(taskFour.getMax(testArray), is(18.));
    }

}