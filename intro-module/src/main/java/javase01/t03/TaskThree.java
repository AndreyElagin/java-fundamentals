package javase01.t03;

import static java.lang.Math.tan;

/**
 * Created by daddyingrave on 14/06/2017.
 * Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h.
 * Результат представить в виде таблицы, первый столбец которой – значения аргумента,
 * второй - соответствующие значения функции: F(x)=tg(2x)-3
 */
public class TaskThree {

    private static final String HEADER = "|--------|--------------|\n" +
                                         "|argument|function value|\n" +
                                         "|--------|--------------|";
    private static final String FOOTER = "|________|______________|";


    public static void func(double diff, int start, int end) {
        System.out.println(HEADER);
        for (int i = start; i <= end; i += diff) {
            System.out.format ("|%8d|%14f|%n", i, tan(i) - 3);
        }
        System.out.println(FOOTER);
    }
}
