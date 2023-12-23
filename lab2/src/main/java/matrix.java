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
    default int[] getDimension() {
        return new int[]{matrix.this.getContent().length, matrix.this.getContent()[0].length};
    }

    /**
     * додавання матриць
     */
    default ImmutableMatrix addMatrixes(matrix m) throws Exception {
        if (Arrays.equals(matrix.this.getDimension(), m.getDimension())) {
            int[][] result = new int[m.getDimension()[0]][m.getDimension()[1]];
            for (int row = 0; row < m.getDimension()[0]; row++) {
                for (int column = 0; column < m.getDimension()[1]; column++) {
                    result[row][column] = matrix.this.get(row + 1, column + 1) + m.get(row + 1, column + 1);
                }
            }
            return new ImmutableMatrix(result);
        } else throw new Exception("Dimensions is not equal!!!!");
    }

    /**
     * множення матриці на скаляр
     */
    default ImmutableMatrix multiplyMatrixOnScalar(int num) {
        int[] dem = matrix.this.getDimension();
        int[][] result = new int[dem[0]][dem[1]];
        for (int row = 0; row < dem[0]; row++) {
            for (int column = 0; column < dem[1]; column++) {
                result[row][column] = matrix.this.get(row + 1, column + 1) * num;
            }
        }
        return new ImmutableMatrix(result);
    }

    /**
     * множення матриць
     */
    default ImmutableMatrix multiplyMatrix(matrix m) throws Exception {
        int[] dem = matrix.this.getDimension();
        int[] dem_m = m.getDimension();

        if (dem[1] == dem_m[0]) {
            int[][] result = new int[dem[0]][dem_m[1]];
            for (int i = 0; i < dem[0]; i++) {
                int[] row = matrix.this.getRow(i + 1);
                for (int j = 0; j < dem_m[1]; j++) {
                    int[] column = m.getColumn(j + 1);
                    result[i][j] = 0;
                    for (int n = 0; n < row.length; n++) {
                        result[i][j] += row[n] * column[n];
                    }
                }
            }
            return new ImmutableMatrix(result);
        } else throw new Exception("Number of columns in M1 is not equal number of rows in M2!!!!!!!");
    }

    /**
     * транспонування матриці
     */
    default ImmutableMatrix transposeMatrix() throws Exception {
        int[] dem = matrix.this.getDimension();
        int[][] result = new int[dem[1]][dem[0]];
        for (int i = 0; i < dem[1]; i++) {
            result[i] = matrix.this.getColumn(i + 1);
        }
        return new ImmutableMatrix(result);
    }

    /**
     * верхня трикутна матриця
     */
    default ImmutableMatrix trigonalMatrixUp() throws Exception {
        int[] dem = matrix.this.getDimension();
        if (dem[0] == dem[1]) {
            //===== arr float
            float[][] result = new float[dem[0]][dem[0]];
            for (int r = 0; r<dem[0]; r++){
                for (int  c = 0; c<dem[0]; c++){
                    result[r][c] = (float) matrix.this.get(r+1,c+1);
                }
            }
            // =====
            for (int column = 0; column < dem[0]; column++) {//по колонкам

                for (int row = column + 1; row < dem[0]; row++) { //рядки нижче діагоналі

                    float[] row_st = result[column]; //рядок з числом на діагоналі
                    float num_st = row_st[column]; //число на діагоналі

                    float[] row_now = result[row];  //рядок нижче діагоналі
                    float num_now = row_now[column];
                    if (num_st != 0) { //якщо не 0
                        for (int n = 0; n < dem[0]; n++) {  //кожне число з рядку
                            float newnum = (row_now[n]) - (( num_now / num_st) *  row_st[n]);
                            result[row][n] = newnum;
                        }
                    } else {
                        result[row - 1] = result[row];
                        result[row] = row_st;
                    }
                }
            }
            // === arr int
            int[][] result_matrix = new int[dem[0]][dem[0]];
            for (int r = 0; r<dem[0]; r++){
                for (int  c = 0; c<dem[0]; c++){
                    result_matrix[r][c] = Math.round(result[r][c]);
                }
            }
            // ===
            return new ImmutableMatrix(result_matrix);
        } else throw new
                Exception("Matrix is not square!!!!!!");
    }
    /**
     * нижня трикутна матриця
     */
    default ImmutableMatrix trigonalMatrixDown() throws Exception {
        int[] dem = matrix.this.getDimension();
        if (dem[0] == dem[1]) {
            //matrix to check result ------
            int[][] matrix180 = new int[dem[0]][dem[0]];
            for (int n = 0; n <dem[0]; n++){
                int[]row = matrix.this.getRow(dem[0]-n);
                for (int m=0; m<dem[0]; m++){
                    matrix180[n][m] = row[dem[0]-m-1];
                }
            }
            ImmutableMatrix Matrix180= new ImmutableMatrix(matrix180);
            Matrix180.printMatrix();
            System.out.println("Матриця для перевірки нижньої трикутної матриці (для розробника)");
            //---------

            //===== arr float
            float[][] result = new float[dem[0]][dem[0]];
            for (int r = 0; r<dem[0]; r++){
                for (int  c = 0; c<dem[0]; c++){
                    result[r][c] = (float) matrix.this.get(r+1,c+1);
                }
            }
            // =====
            for (int column = dem[0]-1; column >=0; column--) {//по колонкам

                for (int row = column - 1; row >= 0; row--) { //рядки нижче діагоналі

                    float[] row_st = result[column]; //рядок з числом на діагоналі
                    float num_st = row_st[column]; //число на діагоналі

                    float[] row_now = result[row];  //рядок нижче діагоналі
                    float num_now = row_now[column];
                    if (num_st != 0) { //якщо не 0
                        for (int n = 0; n < dem[0]; n++) {  //кожне число з рядку
                            float newnum = (row_now[n]) - (( num_now / num_st) *  row_st[n]);
                            result[row][n] = newnum;
                        }
                    } else {
                        result[row + 1] = result[row];
                        result[row] = row_st;
                    }
                }
            }
            // === arr int
            int[][] result_matrix = new int[dem[0]][dem[0]];
            for (int r = 0; r<dem[0]; r++){
                for (int  c = 0; c<dem[0]; c++){
                    result_matrix[r][c] = Math.round(result[r][c]);
                }
            }
            // ===
            return new ImmutableMatrix(result_matrix);
        } else throw new
                Exception("Matrix is not square!!!!!!");



    }



}

