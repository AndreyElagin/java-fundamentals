package javase02.t03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daddyingrave on 26/06/2017.
 *
 * Задание 3. Наследование Разработайте иерархию канцелярских товаров.
 * Создайте “набор новичка”, используя созданную иерархию.
 */
public class NewbieKit {

    private List<StationeryProduct> products = new ArrayList<>();
    private static final int THRESHOLD = 5;

    public void addItem(StationeryProduct product) throws Exception {
        if (products.size() > THRESHOLD)
            throw new Exception("For newbie max size of kit is 5");
        products.add(product);
    }

    public List<StationeryProduct> getProducts() {
        return new ArrayList<>(products);
    }

}



