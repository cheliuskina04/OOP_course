

import java.util.Arrays;
import java.util.stream.IntStream;

public interface matrix {
    /**
     * отримати матрицю масивом
     */
    int[][] getContent();

    /**
     * отримати елемент матриці
     */
    default int get(int row, int column) {
        return matrix.this.getContent()[row - 1][column - 1];
    }

    ;

    /**
     * вивід матриці в консоль
     */
    default void printMatrix() {
        System.out.println("========================");
        for (int[] ints : matrix.this.getContent()) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    /**
     * отримати рядок матриці
     */
    default ImmutableMatrix getRow(int row) {
        return new ImmutableMatrix(new int[][]{this.getContent()[row - 1]});
    }

    /**
     * отримати стовпчик матриці
     */
    default ImmutableMatrix getColumn(int column) {
        int[][] content = matrix.this.getContent();
        int[][] my_column = new int[content.length][1];
        for (int n = 0; n < content.length; n++) {
            my_column[n][0] = content[n][column - 1];
        }
        return new ImmutableMatrix(my_column);
    }

    /**
     * отримати розмірність матриці
     */
    default int[] getDemention() {
        return new int[]{matrix.this.getContent().length, matrix.this.getContent()[0].length};
    }

    /**
     * додавання матриць
     */
    default int[][] addMatrixes(matrix m) throws Exception {
        if (Arrays.equals(matrix.this.getDemention(), m.getDemention())) {
            int[][] result = new int[m.getDemention()[0]][m.getDemention()[1]];
            for (int row = 0; row < m.getDemention()[0]; row++) {
                for (int column = 0; column < m.getDemention()[1]; column++) {
                    result[row][column] = matrix.this.get(row+1, column+1) + m.get(row+1, column+1);
                }
            }
            return result;
        } else throw new Exception("Матриці мають різну розмірність");
    }

    /**
     * множення матриці на скаляр
     */
    default int[][] multiplyMatrixOnScalar(int num) {
        int[] dem = matrix.this.getDemention();
        int[][] result = new int[dem[0]][dem[1]];
        for (int row = 0; row < dem[0]; row++) {
            for (int column = 0; column < dem[1]; column++) {
                result[row][column] = matrix.this.get(row+1, column+1) * num;
            }
        }
        return result;
    }



}

