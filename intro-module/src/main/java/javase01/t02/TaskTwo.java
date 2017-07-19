package javase01.t02;

import static java.lang.Math.pow;

/**
 * Created by daddyingrave on 14/06/2017.
 * Найти наименьший номер элемента последовательности, для которого выполняется условие M.
 * Вывести на экран этот номер и все элементы a[i]  где i = 1, 2, ..., п.
 */
public class TaskTwo {

    public static double findSequenceElement(double e) {
        int i = 1;
        double a;
        do {
            a = 1 / pow(i + 1, 2);
            System.out.printf("%dth element %.20f %n", i, a);
            i++;
        }
        while (a > e);
        return a;
    }

}