package javase02.t04;

import javase02.t02.supplies.*;
import javase02.t03.StationeryProduct;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daddyingrave on 27/06/2017.
 */
public class NewbieKitSorterTest {

    private List<StationeryProduct> products = new ArrayList<>();

    @Before
    public void fillProducts() {
        Calendar product1 = new Calendar(3);
        Glue product2 = new Glue(5);
        Pen product3 = new Pen(8);
        Pencil product4 = new Pencil(3);
        Puncher product5 = new Puncher(15);
        product1.setName("Calendar");
        product2.setName("Glue");
        product3.setName("Pen");
        product4.setName("Pencil");
        product5.setName("Puncher");
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
    }

    @Test
    public void sortByPrice() throws Exception {
        products.forEach((elem) -> System.out.print(elem.getPrice() + " "));
        System.out.println();
        NewbieKitSorter.sortByPrice(products);
        products.forEach((elem) -> System.out.print(elem.getPrice() + " "));
    }

    @Test
    public void sortByName() throws Exception {
        System.out.println();
        products.forEach((elem) -> System.out.print(elem.getName() + " "));
        System.out.println();
        NewbieKitSorter.sortByName(products);
        products.forEach((elem) -> System.out.print(elem.getName() + " "));
    }

    @Test
    public void sortByPriceAndName() throws Exception {
        products.forEach((elem) -> System.out.print("*** " + elem.getPrice() + " " + elem.getName() + " ***"));
        System.out.println();
        NewbieKitSorter.sortByPriceAndName(products);
        products.forEach((elem) -> System.out.print("*** " + elem.getPrice() + " " + elem.getName() + " ***"));
    }

}