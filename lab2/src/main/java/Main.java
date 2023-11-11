import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2,2);
        matrix1.print_matrix();
        Matrix matrix2 = new Matrix(matrix1);
        matrix2.print_matrix();
    }


}

