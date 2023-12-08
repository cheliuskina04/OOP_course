import java.util.Arrays;

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
    default int[] getRow(int row) {
        return this.getContent()[row - 1];
    }

    /**
     * отримати стовпчик матриці
     */
    default int[] getColumn(int column) {
        int[][] content = matrix.this.getContent();
        int[] my_column = new int[content.length];
        for (int n = 0; n < content.length; n++) {
            my_column[n] = content[n][column - 1];
        }
        return my_column;
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
    default ImmutableMatrix addMatrixes(matrix m) throws Exception {
        if (Arrays.equals(matrix.this.getDemention(), m.getDemention())) {
            int[][] result = new int[m.getDemention()[0]][m.getDemention()[1]];
            for (int row = 0; row < m.getDemention()[0]; row++) {
                for (int column = 0; column < m.getDemention()[1]; column++) {
                    result[row][column] = matrix.this.get(row+1, column+1) + m.get(row+1, column+1);
                }
            }
            return new ImmutableMatrix(result);
        } else throw new Exception("Матриці мають різну розмірність");
    }

    /**
     * множення матриці на скаляр
     */
    default ImmutableMatrix multiplyMatrixOnScalar(int num) {
        int[] dem = matrix.this.getDemention();
        int[][] result = new int[dem[0]][dem[1]];
        for (int row = 0; row < dem[0]; row++) {
            for (int column = 0; column < dem[1]; column++) {
                result[row][column] = matrix.this.get(row+1, column+1) * num;
            }
        }
        return new ImmutableMatrix(result);
    }

    /**
     * множення матриць
     */
    default ImmutableMatrix multiplyMatrix(matrix m) throws Exception {
        int[] dem = matrix.this.getDemention();
        int[] dem_m = m.getDemention();

        if (dem[1]==dem_m[0]) {
            int[][] result = new int[dem[0]][dem_m[1]];
            for(int i = 0; i< dem[0]; i++){
                int[] row = matrix.this.getRow(i+1);
                for(int j = 0; j< dem_m[1]; j++) {
                    int[] column = m.getColumn(j + 1);
                    result[i][j] = 0;
                    for (int n = 0; n < row.length; n++) {
                        result[i][j] += row[n] * column[n];
                    }
                }
            }
            return new ImmutableMatrix(result);
        } else throw new Exception("Матриці не сумісні");
    }
    /**
     * транспонування матриці
     */
    default ImmutableMatrix transposeMatrix() throws Exception {
        int[] dem = matrix.this.getDemention();
        int[][] result = new int[dem[1]][dem[0]];
        for (int i = 0; i<dem[1]; i++){
            result[i] = matrix.this.getColumn(i+1);
        }
        return new ImmutableMatrix(result);
    }

}

