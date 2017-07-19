package javase02.t03;

import javase02.t02.supplies.Calendar;
import javase02.t02.supplies.Glue;
import javase02.t02.supplies.Pencil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by daddyingrave on 27/06/2017.
 */
public class NewbieKitTest {

    private NewbieKit newbieKit;

    @Before
    public void preparation() {
        newbieKit = new NewbieKit();
    }

    @Test
    public void addItem() throws Exception {
        newbieKit.addItem(new Calendar(666));
        assertThat(newbieKit.getProducts().size(), is(1));
    }

    @Test
    public void getProducts() throws Exception {
        newbieKit.addItem(new Glue(42));
        newbieKit.addItem(new Pencil(23));
        assertThat(newbieKit.getProducts().get(1).getPrice(), is(23));
    }

}