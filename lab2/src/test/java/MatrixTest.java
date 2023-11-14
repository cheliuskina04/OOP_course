import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
        assertTrue(Arrays.stream(new Matrix().getcontent()).toList().isEmpty());
    }

    @Test
    @DisplayName("Zero matrix and copy")
    public void test2() {
        Matrix matrix = new Matrix(2, 3);
        assertArrayEquals(matrix.getcontent(), zero_matrix);
        assertArrayEquals(zero_matrix, new Matrix(matrix).getcontent());
    }

    @Test
    @DisplayName("Fill matrix by my nums")
    public void test3() {
        Matrix matrix = new Matrix();
        int[][] user_content = {{5, 3}, {-3, -5}};
        matrix.fill(user_content);
        assertArrayEquals(matrix.getcontent(), user_content);
    }

    @Test
    @DisplayName("Get column, row and number")
    public void test4() {
        Matrix matrix = new Matrix();
        matrix.fill(example);
        assertEquals(3, matrix.get(2,2));
        assertArrayEquals(example[1], matrix.getrow(2).getcontent()[0]);
        for (int n = 0; n>3; n++) {
            assertEquals(example[n][1], matrix.getcolumn(2).getcontent()[n][0]);

        }

    }
    @Test
    @DisplayName("Get column, row and number")
    public void test5() {
        Matrix matrix = new Matrix();
        matrix.fill(example);
        assertArrayEquals(new int[] {3,4}, matrix.getdemention());

    }
}