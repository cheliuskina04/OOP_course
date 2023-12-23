import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        MutableMatrix matrix1 = new MutableMatrix();
//ImmutableMatrix m2  = new ImmutableMatrix(new int[][]{{3,4,5},{1,3,4},{5,5,5}});
//m2.printMatrix();
//m2.trigonalMatrixUp().printMatrix();
        matrix1.fill(new int[][]{{1, 3, 2, -1}, {2, 0, 0, 1}, {-1, 3,100, -4}, {3, 3, -2, 200}});
        matrix1.printMatrix();
        matrix1.trigonalMatrixUp().printMatrix();
        matrix1.trigonalMatrixDown().printMatrix();

        matrix1.fill(new int[][]{{0, 3, 2, -1,5}, {2, 0, 0, 1,8}, {-1, 3, 2, -4,9}, {3, 3, -2, 5,7},{2,2,2,2,100}});
        matrix1.printMatrix();
        matrix1.trigonalMatrixUp().printMatrix();
        matrix1.trigonalMatrixDown().printMatrix();
    }

}


