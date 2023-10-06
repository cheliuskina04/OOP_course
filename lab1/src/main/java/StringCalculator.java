import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringCalculator {
    public static int add(String text) {

        if (text.isEmpty()) {  //empty string
            return 0;

        } else { //string is not empty
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
                        return -1;
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
            return all_nums.stream().mapToInt(i -> i).sum();
        }
    }
}
