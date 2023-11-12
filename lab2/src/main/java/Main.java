import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2,2);
        matrix1.print_matrix();
        Matrix matrix2 = new Matrix(7,8);
        matrix2.fill();
        matrix2.print_matrix();
        System.out.println(matrix2.get(7,8));
        matrix2.getrow(2).print_matrix();
        matrix2.getcolumn(3).print_matrix();

    }


}

