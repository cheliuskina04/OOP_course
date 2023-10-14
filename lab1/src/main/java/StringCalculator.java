

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static java.lang.String.join;
import static java.lang.System.exit;

public class StringCalculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");

        String mystring = sc.nextLine();
        System.out.println(add(mystring));
    }
    public static int add(String text) {

        if (text.isEmpty()) {  //empty string
            return 0;
        } else { //string is not empty
            String[] split_strings;
            List<Integer> all_nums = new ArrayList<Integer>();  //list of nums to add

            if (text.startsWith("//")) {
                Matcher match_text = Pattern.compile("//\\[(.+)]\n(.*)", Pattern.DOTALL).matcher(text);
                match_text.matches();
                String my_delimiter = match_text.group(1);
                split_strings = match_text.group(2).replace(my_delimiter, ",").split("[,\n]");
            }
             else {
                split_strings = text.split("[,\n]");
            }
            try {
                for (int j = 0; j < split_strings.length; j++)
                    all_nums.add(j, Integer.parseInt(split_strings[j]));
            } catch (NumberFormatException ex) {
                System.out.println("ERROR: There is smth except except numbers or odd delimiters.");
                return -1;
            }

            List<Integer> negative_nums = new ArrayList<>();
            for (int i = 0; i < all_nums.toArray().length; i++)
                if (all_nums.get(i) < 0)
                    negative_nums.add(all_nums.get(i));


            if (negative_nums.toArray().length > 0)
                throw new RuntimeException("ERROR: There are negative numbers: " + join(",", Arrays.toString(negative_nums.toArray())));
            else
                return all_nums.stream().mapToInt(i -> i).filter(i -> i <= 1000).sum();
        }
    }
}

