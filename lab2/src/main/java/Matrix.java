import java.util.Random;

class Matrix {
    private int[][] content;  //CONTENT OF MATRIX
    public int[][] getcontent(){return content;}

    //CONSTRUCTORS---------------------------------------
    public Matrix() {   //EMPTY
        this.content = new int[0][0];
    }
    public Matrix(int rows, int columns) {   //BY DIMENSION
        this.content = new int[rows][columns];
    }
    public Matrix(Matrix matrix) {   //COPY
        this.content = matrix.content;
    }

    //NON-STATIC METHODS---------------------------------------------
    public void print_matrix(){ //print matrix
        System.out.println("========================");
        for (int[] ints : content) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }

    public void fill(int[][] user_content){
        content = user_content;
    }
    public void fill(){
        for (int i = 0; i<content.length; i++) {
            for (int j = 0; j<content[i].length; j++) {
                content[i][j] = (int) (Math.random()*20-10);
            }
        }
    }
    public int get(int row, int column){
        return content[row-1][column-1];
    }
    public Matrix getrow(int row){
        Matrix res = new Matrix();
        res.fill(new int[][]{content[row - 1]});
        return res;
    }
    public Matrix getcolumn(int column){
        Matrix res = new Matrix();
        int[][] my_column = new int[content.length][1];
        for (int n = 0; n<content.length; n++) {
                my_column[n][0] = content[n][column-1];
            }
        res.fill(my_column);
        return res;
    }

    public int[] getdemention(){
         return new int[] {content.length, content[0].length};
    }
}


