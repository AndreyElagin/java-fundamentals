package javase02.t06;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by daddyingrave on 30/06/2017.
 */
public class NuclearSubmarineTest {

    public NuclearSubmarine ns;

    @Before
    public void prepare() {
        ns = new NuclearSubmarine();
    }

    @Test
    public void goNavigation() throws Exception {
        ns.goNavigation();
        assertThat(ns.isInNavigation(), is(true));
    }

    @Test
    public void stopNavigation() throws Exception {
        ns.goNavigation();
        ns.stopNavigation();
        assertThat(ns.isInNavigation(), is(false));
    }

}