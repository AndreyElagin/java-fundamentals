package javase02.t02.supplies;

import javase02.t03.StationeryProduct;

/**
 * Created by daddyingrave on 26/06/2017.
 */
public class Pencil implements StationeryProduct {

    private int price;
    private String name;

    public Pencil(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
