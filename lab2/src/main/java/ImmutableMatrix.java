public class ImmutableMatrix extends MutableMatrix implements matrix{

    private int[][] content;  //CONTENT OF MATRIX
    public int[][] getContent(){return content;}


    //CONSTRUCTORS---------------------------------------
    public ImmutableMatrix() {   //EMPTY
        this.content = new int[0][0];
    }
    public ImmutableMatrix(int rows, int columns) {   //BY DIMENSION
        this.content = new int[rows][columns];
    }
    public ImmutableMatrix(matrix matrix) {   //COPY
        this.content = matrix.getContent();
    }
    public ImmutableMatrix(int[][] user_content){ //FILL OF CONTENT
        this.content = user_content;
    }
}
