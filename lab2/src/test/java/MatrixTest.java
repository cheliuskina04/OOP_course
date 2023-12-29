import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    int[][] zero_matrix = {{0, 0, 0}, {0, 0, 0}};
    int[][] example = {{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}};

    @Test
    @DisplayName("Empty matrix")
    public void test1() {
        assertTrue(Arrays.stream(new MutableMatrix().getContent()).toList().isEmpty());
    }

    @Test
    @DisplayName("Zero matrix and copy")
    public void test2() {
        MutableMatrix matrix = new MutableMatrix(2, 3);
        assertArrayEquals(matrix.getContent(), zero_matrix);
        assertArrayEquals(zero_matrix, new MutableMatrix(matrix).getContent());
    }

    @Test
    @DisplayName("Fill matrix by my nums")
    public void test3() {
        MutableMatrix matrix = new MutableMatrix();
        int[][] user_content = {{5, 3}, {-3, -5}};
        matrix.fill(user_content);
        assertArrayEquals(matrix.getContent(), user_content);
    }

    @Test
    @DisplayName("Get column, row and number")
    public void test4() {
        MutableMatrix matrix = new MutableMatrix();
        matrix.fill(example);
        assertEquals(3, matrix.get(2,2));
        assertArrayEquals(example[1], matrix.getRow(2));
        assertArrayEquals(new int[] {2,3,4}, matrix.getColumn(2));



    }
    @Test
    @DisplayName("Get demention")
    public void test5() {
        MutableMatrix matrix = new MutableMatrix();
        matrix.fill(example);
        assertArrayEquals(new int[] {3,4}, matrix.getDimension());
    }

    @Test
    @DisplayName("Only equals")
    public void test6() {
        MutableMatrix matrix1 = new MutableMatrix();
        MutableMatrix matrix2 = new MutableMatrix(2,2);
        String i = "erer";

        assertTrue(matrix1.equals(matrix2) == matrix2.equals(matrix1)&&
                !matrix2.equals(matrix1));
        assertTrue(matrix1.equals(i)== i.equals(matrix1)&&
                !matrix1.equals(i));
        assertTrue(matrix1.equals(matrix1));
        matrix2.fill(matrix1.getContent());
        assertTrue(matrix1.equals(matrix2)==matrix2.equals(matrix1)
        && matrix1.equals(matrix2));
    }
    @Test
    @DisplayName("Onle equals")
    public void test7() {
        MutableMatrix matrix1 = new MutableMatrix(3,5);
        MutableMatrix matrix2 = new MutableMatrix(matrix1);

        assertTrue(matrix1.hashCode() == matrix2.hashCode());
        assertTrue(matrix1.hashCode() == matrix1.hashCode());
    }

    @Test
    @DisplayName("Adding Matrixes")
    public void test8() throws Exception {
        MutableMatrix matrix1 = new MutableMatrix();
        matrix1.fill(example);
        MutableMatrix matrix2 = new MutableMatrix();
        matrix2.fill(new int[][] {{1,1,1,1},{1,1,1,1},{1,1,1,1}});
        assertArrayEquals(matrix1.addMatrixes(matrix2).getContent(), new
     int[][] {{2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}});
    }

    @Test
    @DisplayName("Multiplying Matrixes on Scalar")
    public void test9() throws Exception {
        MutableMatrix matrix1 = new MutableMatrix();
        matrix1.fill(example);
        assertArrayEquals(matrix1.multiplyMatrixOnScalar(2).getContent(), new
                int[][] {{2, 4, 6, 8}, {4, 6, 8, 10}, {6, 8, 10, 12}});
    }

    @Test
    @DisplayName("Multiplying Matrices")
    public void test10() throws Exception {
        MutableMatrix matrix1 = new MutableMatrix();
        matrix1.fill(new int[][]{{1,2,3},{1,0,1}});
        MutableMatrix matrix2 = new MutableMatrix();
        matrix2.fill(new int[][]{{2,1},{1,5}});
        assertArrayEquals(matrix2.multiplyMatrix(matrix1).getContent(), new
                int[][] {{3,4,7}, {6,2,8}});
    }

    @Test
    @DisplayName("Transpose Matrices")
    public void test11() throws Exception {
        MutableMatrix matrix1 = new MutableMatrix();
        matrix1.fill(new int[][]{{1,2,3},{1,0,1}});
        assertArrayEquals(matrix1.transposeMatrix().getContent(), new
                int[][] {{1,1},{2,0},{3,1}});
    }

    @Test
    @DisplayName("Diagonal Matrices")
    public void test12() throws Exception {
        assertArrayEquals(ImmutableMatrix.diagonalMatrix(new int[] {1,2,3}).getContent(), new
                int[][] {{1,0,0},{0,2,0},{0,0,3}});
    }


    @Test
    @DisplayName("One Matrices")
    public void test13() throws Exception {
        assertArrayEquals(ImmutableMatrix.oneMatrix(3).getContent(), new
                int[][] {{1,0,0},{0,1,0},{0,0,1}});
    }

    @Test
    @DisplayName("Random Row")
    public void test14() {
        assertEquals(ImmutableMatrix.randomRow(3).getContent().length, 1);
        assertEquals(ImmutableMatrix.randomRow(3).getContent()[0].length, 3);
    }

    @Test
    @DisplayName("Trigonal Matrix")
    public void test15() throws Exception {
        MutableMatrix matrix1 = new MutableMatrix();
        matrix1.fill(new int[][]{{1, 2, 3}, {2, 4, 0}, {7, 3, 2}});
        assertArrayEquals(matrix1.trigonalMatrixUp().getContent(), new
                int[][]{{1, 2, 3}, {0, -11, -19}, {0, 0, -6}});

        matrix1.fill(new int[][]{{1, 3, 2, -1}, {2, 4, 0, 1}, {-1, 3, 2, -4}, {3, 3, -2, 5}});
        matrix1.trigonalMatrixUp().printMatrix();
        assertArrayEquals(matrix1.trigonalMatrixUp().getContent(), new
                int[][]{{1, 3, 2, -1}, {0, -2, -4, 3}, {0, 0, -8, 4}, {0, 0, 0, 1}});

    }
}