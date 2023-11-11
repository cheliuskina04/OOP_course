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

    //METHODS---------------------------------------------
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
}


