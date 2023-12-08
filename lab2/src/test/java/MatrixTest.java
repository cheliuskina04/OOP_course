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
        assertArrayEquals(example[1], matrix.getRow(2).getContent()[0]);
        for (int n = 0; n>3; n++) {
            assertEquals(example[n][1], matrix.getColumn(2).getContent()[n][0]);

        }

    }
    @Test
    @DisplayName("Get demention")
    public void test5() {
        MutableMatrix matrix = new MutableMatrix();
        matrix.fill(example);
        assertArrayEquals(new int[] {3,4}, matrix.getDemention());
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


}