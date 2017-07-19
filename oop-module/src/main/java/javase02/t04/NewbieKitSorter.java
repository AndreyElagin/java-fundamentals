package javase02.t04;

import javase02.t03.StationeryProduct;

import java.util.Comparator;
import java.util.List;

/**
 * Created by daddyingrave on 27/06/2017.
 */
public class NewbieKitSorter {

    public static void sortByPrice(List<StationeryProduct> products) {
        products.sort((elem1, elem2) -> elem1.getPrice() == elem2.getPrice()
                ? 0 : elem1.getPrice() > elem2.getPrice()
                ? 1 : -1);
    }

    public static void sortByName(List<StationeryProduct> products) {
        products.sort(Comparator.comparing(elem -> elem.getName()));
    }

    public static void sortByPriceAndName(List<StationeryProduct> products) {
        products.sort((elem1, elem2) -> {
            int result = elem1.getPrice() == elem2.getPrice()
                    ? 0 : elem1.getPrice() > elem2.getPrice()
                    ? 1 : -1;
            if (result != 0) {
                return result;
            } else {
                return elem1.getName().compareTo(elem2.getName());
            }
        });
    }

}
