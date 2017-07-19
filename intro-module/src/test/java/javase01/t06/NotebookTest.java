package javase01.t06;

import org.junit.Test;
import sun.management.MethodInfo;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Created by daddyingrave on 19/06/2017.
 */
public class NotebookTest {

    @Test
    public void addEntryWithTitle() throws Exception {
        Notebook notebook = new Notebook(4);
        notebook.addEntry("1", "lorem ipsum");
        notebook.addEntry("2", "lorem ipsum2");
        notebook.addEntry("3", "lorem ipsum3");
        assertThat(notebook.getCount(), is(3));
        assertThat(notebook.getEntriesLength(), is(4));
        notebook.viewAllEntries();
        System.out.println();
    }

    @Test
    public void addEntry() throws Exception {
        Notebook notebook = new Notebook(4);
        notebook.addEntry("lorem ipsum");

        Method method = Notebook.class.getDeclaredMethod("getEntry", String.class);
        method.setAccessible(true);
        assertThat(((Entry) method.invoke(notebook, "No Title")).getTitle(), is("No Title"));
        notebook.viewAllEntries();
        System.out.println();
    }

    @Test
    public void deleteEntryByIndex() throws Exception {
        Notebook notebook = new Notebook(4);
        notebook.addEntry("lorem ipsum");
        notebook.addEntry("lorem ipsum2");
        notebook.addEntry("lorem ipsum3");
        notebook.deleteEntryByIndex(4);
        assertThat(notebook.getCount(), is(3));
        notebook.deleteEntryByIndex(3);
        assertThat(notebook.getCount(), is(2));
        notebook.viewAllEntries();
        System.out.println();
    }

    @Test
    public void deleteEntryByTitle() throws Exception {
        Notebook notebook = new Notebook(4);
        notebook.addEntry("1", "lorem ipsum");
        notebook.addEntry("2", "lorem ipsum2");
        notebook.addEntry("3", "lorem ipsum3");
        notebook.deleteEntryByTitle("42");
        assertThat(notebook.getCount(), is(3));
        notebook.deleteEntryByTitle("3");
        assertThat(notebook.getCount(), is(2));
        notebook.viewAllEntries();
        System.out.println();
    }

    @Test
    public void editEntryByIndex() throws Exception {
        Notebook notebook = new Notebook(4);
        notebook.addEntry("1", "lorem ipsum");
        notebook.addEntry("2", "lorem ipsum2");
        notebook.addEntry("3", "lorem ipsum3");
        notebook.editEntryByIndex(1, "hello", "42");

        Method method = Notebook.class.getDeclaredMethod("getEntry", String.class);
        method.setAccessible(true);
        assertThat(((Entry) method.invoke(notebook, "hello")).getTitle(), is("hello"));
        assertThat(((Entry) method.invoke(notebook, "hello")).getContent(), is("42"));
        notebook.viewAllEntries();
        System.out.println();
    }

    @Test
    public void editEntryByTitle() throws Exception {
        Notebook notebook = new Notebook(4);
        notebook.addEntry("1", "lorem ipsum");
        notebook.addEntry("2", "lorem ipsum2");
        notebook.addEntry("3", "lorem ipsum3");
        notebook.editEntryByTitle("3", "hell", null);

        Method method = Notebook.class.getDeclaredMethod("getEntry", String.class);
        method.setAccessible(true);
        assertThat(((Entry) method.invoke(notebook, "hell")).getTitle(), is("hell"));
        assertThat(((Entry) method.invoke(notebook, "hell")).getContent(), is("lorem ipsum3"));
    }

}