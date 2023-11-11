import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    int[][] zero_matrix = {{0,0,0},{0,0,0}};

    @Test
    @DisplayName("Empty matrix")
    public void test1() {
        assertTrue(Arrays.stream(new Matrix().getcontent()).toList().isEmpty());
    }

    @Test
    @DisplayName("Zero matrix and copy")
    public void test2() {
        Matrix matrix = new Matrix(2,3);
        assertArrayEquals(matrix.getcontent(), zero_matrix);
        assertArrayEquals(zero_matrix, new Matrix(matrix).getcontent());
    }

}