

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static java.lang.String.join;
import static java.lang.System.exit;


public class StringCalculator {
    public static void main(String[] args){
        String mystring = "1,,2";
        System.out.println("Result: " + add(mystring));
    }
    public static int add(String text) {

        if (text.isEmpty()) {  //empty string
            return 0;

        } else { //string is not empty

            String[] split_strings = text.split("[,\n]");

            List<Integer> all_nums = new ArrayList<Integer>();  //list of nums to add

            if (text.startsWith("//")) {
                Matcher match_text = Pattern.compile("//(.)\n(.*)", Pattern.DOTALL).matcher(text);
                match_text.find();
                String my_delimiter = match_text.group(1);
                String[] half_split_strings = match_text.group(2).split(my_delimiter);

                for (int i = 0; i < half_split_strings.length; i++) {
                    text = half_split_strings[i];
                    String[] split_strings = text.split("[,\n]");
                    try {
                        for (int j = 0; j < split_strings.length; j++)
                            all_nums.add(j, Integer.parseInt(split_strings[j]));
                    } catch (NumberFormatException ex) {
                        System.out.println("ERROR: There is smth except except numbers or odd delimiters.");
                        exit(1);
                    }
                }


            } else {
                String[] split_strings = text.split("[,\n]");
                try {
                    for (int j = 0; j < split_strings.length; j++)
                        all_nums.add(j, Integer.parseInt(split_strings[j]));
                } catch (NumberFormatException ex) {
                    System.out.println("ERROR: There is smth except except numbers or odd delimiters.");
                    return -1;
                }
            }
            List<Integer> negative_nums = new ArrayList<>();
            for(int i = 0; i<all_nums.toArray().length; i++)
                if(all_nums.get(i)<0)
                    negative_nums.add(all_nums.get(i));



            if (negative_nums.toArray().length >0)
                throw new RuntimeException("ERROR: There are negative numbers: " + join(",", Arrays.toString(negative_nums.toArray())));
            else
                 return all_nums.stream().mapToInt(i -> i).sum();
        }
    }
}

