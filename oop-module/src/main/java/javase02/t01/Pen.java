package javase02.t01;

/**
 * Created by daddyingrave on 25/06/2017.
 *
 * Задание 1. Принципы ООП, простейшие классы и объекты
 * Разработайте спецификацию и создайте класс Ручка (Pen).
 * Определите в этом классе методы equals(), hashCode() и toString().
 */
public class Pen {

    private String vendor;
    private String bodyColor;
    private String inkColor;

    public Pen(String vendor, String bodyColor, String inkColor) {
        this.vendor = vendor;
        this.bodyColor = bodyColor;
        this.inkColor = inkColor;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public String getInkColor() {
        return inkColor;
    }

    public void setInkColor(String inkColor) {
        this.inkColor = inkColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        return vendor.equals(pen.vendor)
                && bodyColor.equals(pen.bodyColor)
                && inkColor.equals(pen.inkColor);
    }

    @Override
    public int hashCode() {
        int result = vendor.hashCode();
        result = 31 * result + bodyColor.hashCode();
        result = 31 * result + inkColor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "This pen produced by " + vendor +
                ", its body color - " + bodyColor +
                " and the ink color is " + inkColor;
    }

}