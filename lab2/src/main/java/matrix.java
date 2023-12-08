public interface matrix {
        /**отримати матрицю масивом*/
        int[][] getContent();
        /**отримати елемент матриці*/
        default int get(int row, int column){
            return matrix.this.getContent()[row-1][column-1];};
        /**вивід матриці в консоль*/
        default void printMatrix(){
            System.out.println("========================");
            for (int[] ints : matrix.this.getContent()) {
                for (int anInt : ints) {
                    System.out.print(anInt + "\t");
                }
                System.out.println();
            }
        }
        /**отримати рядок матриці*/
        default ImmutableMatrix getRow(int row){
            return new ImmutableMatrix(new int[][]{this.getContent()[row - 1]});
        }
        /**отримати стовпчик матриці*/
        default ImmutableMatrix getColumn(int column){
            int[][] content = matrix.this.getContent();
            int[][] my_column = new int[content.length][1];
            for (int n = 0; n<content.length; n++) {
                my_column[n][0] = content[n][column-1];
            }
            return new ImmutableMatrix(my_column);
        }
        /**отримати розмірність матриці*/
        default int[] getDemention(){
            return new int[] {matrix.this.getContent().length, matrix.this.getContent()[0].length};
        }

}

