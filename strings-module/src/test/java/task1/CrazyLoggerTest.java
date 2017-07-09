package task1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CrazyLoggerTest {

    private CrazyLogger crazyLogger;

    @Before
    public void preparing() {
        crazyLogger = new CrazyLogger();
        crazyLogger.log("Exception in thread \"main\" java.lang.NullPointerException\n" +
                "        at com.example.myproject.Book.getTitle(Book.java:16)\n" +
                "        at com.example.myproject.Author.getBookTitles(Author.java:25)\n" +
                "        at com.example.myproject.Bootstrap.main(Bootstrap.java:14)");

        crazyLogger.log("Стоит ли рассамтривать данную ошибку как нечто критичное?");
        crazyLogger.log("Caused by: java.sql.SQLException: Violation of unique constraint MY_ENTITY_UK_1: duplicate value(s) for column(s) MY_COLUMN in statement [...]\n" +
                "    at org.hsqldb.jdbc.Util.throwError(Unknown Source)\n" +
                "    at org.hsqldb.jdbc.jdbcPreparedStatement.executeUpdate(Unknown Source)\n" +
                "    at com.mchange.v2.c3p0.impl.NewProxyPreparedStatement.executeUpdate(NewProxyPreparedStatement.java:105)\n" +
                "    at org.hibernate.id.insert.AbstractSelectingDelegate.performInsert(AbstractSelectingDelegate.java:57)\n" +
                "    ... 54 more");
    }

    @Test
    public void search() throws Exception {
        String searchQuery1 = "Author.getBookTitles";
        String searchQuery2 = "рассамтривать";
        String searchQuery3 = "v2.c3p0.impl.NewProxyPreparedStatement";
        crazyLogger.search(searchQuery1);
        crazyLogger.search(searchQuery2);
        crazyLogger.search(searchQuery3);
        crazyLogger.search("Я пошел в лес и там потерялся");
    }

}