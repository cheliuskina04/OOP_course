import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args){
        String mystring = "1,,2";
        System.out.println("Result: " + add(mystring));
    }

    public static int add(String text) {

        if (text.isEmpty()) {  //empty string
            return 0;

        } else { //string is not empty
            String[] split_strings = text.split(",");
            List<Integer> all_nums = new ArrayList<Integer>();  //list of nums to add
            try {
                for (int i = 0; i < split_strings.length; i++)
                    all_nums.add(i, Integer.parseInt(split_strings[i]));
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: There is smth except except numbers or odd delimiters.");
                return -1;
            }

            return all_nums.stream().mapToInt(i -> i).sum();

        }
    }
}
