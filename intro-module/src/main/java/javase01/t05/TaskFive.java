package javase01.t05;

/**
 * Created by daddyingrave on 15/06/2017.
 * Получить матрицу:
 * 1 0 0 … 0 0 1
 * 0 1 0 … 0 1 0
 * 0 0 1 … 1 0 0
 * ⁞ ⁞ ⁞ ⁞ ⁞ ⁞ ⁞
 * 0 1 0 … 0 1 0
 * 1 0 0 … 0 0 1
 */
public class TaskFive {

    private byte[][] matrix;

    private TaskFive() {}

    public static TaskFive getInstance() {
        TaskFive matrix = new TaskFive();
        matrix.init();
        return matrix;
    }

    private void init() {
        matrix = new byte[5][6];
        for (int i = 0, j = 5; i < 5 && j >= 0; i++, j--) {
            if (i == 3) j--;
            matrix[i][j] = 1;
            matrix[i][matrix[i].length - j - 1] = 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 3) {
                    sb.append(" \u2026 ");
                }
                sb.append(matrix[i][j]);
                if (j != 2) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            if (i == 2) sb.append("\u205E \u205E \u205E \u205E \u205E \u205E \u205E \n");
        }
        return sb.toString();
    }

}
