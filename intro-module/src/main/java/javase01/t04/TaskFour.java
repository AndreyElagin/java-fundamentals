package javase01.t04;

import java.util.Random;

/**
 * Created by daddyingrave on 14/06/2017.
 * Даны действительные числа a1, a2 … an.  Найти...
 */
public class TaskFour {

    private Random random = new Random();

    public double getMax(double[] array) {
        double max = Double.NEGATIVE_INFINITY;
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            if (max < (array[i] + array[length - i - 1]))
                max = array[i] + array[length - i - 1];
        }
        return max;
    }

    public double[] getRandomArray(int n) {
        double[] array = new double[n * 2];
        for (int i = 0; i < n * 2; i++) {
            array[i] = random.nextDouble() * random.nextInt();
        }
        return array;
    }

}
