import java.util.Arrays;


class MutableMatrix implements matrix {
    private int[][] content;  //CONTENT OF MATRIX
    public int[][] getContent(){return content;}

    //CONSTRUCTORS---------------------------------------
    public MutableMatrix() {   //EMPTY
        this.content = new int[0][0];
    }
    public MutableMatrix(int rows, int columns) {   //BY DIMENSION
        this.content = new int[rows][columns];
    }
    public MutableMatrix(matrix matrix) {   //COPY
        this.content = matrix.getContent();
    }

    //METHODS---------------------------------------------

    public void fill(){ //заповнення матриці рандомними числами
        for (int i = 0; i<content.length; i++) {
            for (int j = 0; j<content[i].length; j++) {
                content[i][j] = (int) (Math.random()*20-10);
            }
        }
    }
    public void fill(int[][] user_content){
        content = user_content;
    }

//HASH CODES ----------------------------------------------
    @Override
    public boolean equals(Object ob) {
        if (ob == this)
            return true;
        if (!(ob instanceof MutableMatrix))
            return false;
        return ((MutableMatrix) ob).content == content;
    }

    @Override
    public int hashCode(){
        int retVal = 0;
        for (int[] ints : content) {
            retVal += Arrays.hashCode(ints);
        }
        return retVal;
    }

    //OPERATIONS





}



