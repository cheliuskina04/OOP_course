import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    //STEP 1
    @Test
    public void empty_string() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void one_number() {
        assertEquals(11, StringCalculator.add("11"));
    }

    @Test
    public void two_number() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void two_delimiters() {
        assertEquals(-1, StringCalculator.add("1,,2"));
    }

    @Test
    public void start_delimiters() {
        assertEquals(-1, StringCalculator.add(",1,2"));
    }

    //STEP 2
    @Test
    public void tree_number() {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }
    @Test
    public void five_number() {
        assertEquals(404, StringCalculator.add("400,0,1,3"));
    }

    //STEP 3
    @Test
    public void two_number_two_delimeters() {
        assertEquals(-1, StringCalculator.add("1,\n1"));
    }
    @Test
    public void three_number_two_delimeters() {
        assertEquals(10, StringCalculator.add("1\n1,8"));
    }

    //STEP 4
    @Test
    public void my_delimiter() {
        assertEquals(6, StringCalculator.add("//;\n1;2;3"));
    }
    @Test
    public void my_delimiter1() {
        assertEquals(11, StringCalculator.add("//;\n1,5;4\n1"));
    }
}

